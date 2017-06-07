package com.jmdroid.prac_angularweb.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.jmdroid.prac_angularweb.R;
import com.jmdroid.prac_angularweb.storage.SPHelper;
import com.jmdroid.prac_angularweb.util.Util;

public class MainActivity extends BaseActivity {

    WebView webView;
    boolean isFinishLoading;  // 화면 로딩이 완전히 끝나면 true가 됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request_READ_PHONE_STATE_permission();

        webView = (WebView) findViewById(R.id.webView);
        loadWeb();
    }

    public void loadWeb() {
        // 세팅 (성능, 자바스크립트 인터페이스 부분(안드<->웹 통신),
        // 웹 클라이언트, 크롬설정, 스토리지, 로그등등)
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(false);    // 캐싱
        // WebSQL 데이터베이스를 유효하게 한다
        webView.getSettings().setDatabaseEnabled(true);
        // localStorage, sessionStorage를 유효화한다
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSaveFormData(false);       // 입력값 저장 창 안띄움 저장안함
        webView.getSettings().setSavePassword(false);
        // WebView도 컨텐트 프로바이더가 제공하는 컨텐츠를 읽어올 수 있다
        webView.getSettings().setAllowContentAccess(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.addJavascriptInterface(new MyInterface(), "myInterface");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100 && !isFinishLoading) {
                    isFinishLoading = true;   // 결제 페이지가 로딩이 모두 완료되었다.
                    String phone = SPHelper.getInstance().getString(MainActivity.this, "my_phone_number");
                    String os_version = SPHelper.getInstance().getString(MainActivity.this, "my_os_version");

                    // 웹뷰로 전달
                    webView.loadUrl("javascript:transData('"+phone+"', '"+os_version+"');");
                }
            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //super.onPageFinished(view, url);
                hideProgress();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //super.onPageStarted(view, url, favicon);
                showProgress("Loading...");
            }

            /*@Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.indexOf("http://219.248.137.8:8888") >= 0) {
                    webView.addJavascriptInterface(new MyInterface(), "myInterface");
                }
                return false;
            }*/
        });
        webView.loadUrl(SPHelper.getInstance().getString(MainActivity.this, "url"));
    }

    public class MyInterface {
        @JavascriptInterface
        public void webToAndroid(String data) {
            Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack() ){
            webView.goBack();
            return true;
        }

        //백할 페이가 없다면
        if ((keyCode == KeyEvent.KEYCODE_BACK) && (webView.canGoBack() == false)){
            //Toast.makeText(this, "버튼 클릭 이벤트", Toast.LENGTH_SHORT).show();

            //다이아로그박스 출력
            new AlertDialog.Builder(this)
                    .setTitle("프로그램 종료")
                    .setMessage("프로그램을 종료하시겠습니까?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    })
                    .setNegativeButton("아니오",  null).show();
        }

        return super.onKeyDown(keyCode, event);
    }


    /////permission
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    // 사용자가 권한 동의를 안하므로 종료
                    finish();
                }
            }
        }
    }

    public void request_READ_PHONE_STATE_permission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            //권한이 없을 경우

            //최초 권한 요청인지 혹은 사용자에 의한 재요청인지 확인
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)) {
                //사용자가 임의로 권한을 취소시킨 경우
                //권한 재요청
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            } else {
                //최초로 권한을 요청하는 경우(첫실행)
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            }
        } else {
            SPHelper.getInstance().setString(MainActivity.this, "my_phone_number", Util.getInstance().getMyPhoneNum(MainActivity.this));
            SPHelper.getInstance().setString(MainActivity.this, "my_os_version", android.os.Build.VERSION.SDK_INT+"");
            SPHelper.getInstance().setString(MainActivity.this, "my_os_version", android.os.Build.VERSION.SDK_INT+"");
        }
    }
}
