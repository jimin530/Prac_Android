package com.jmdroid.prac_realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    Realm mRealm;
    RealmResults<UserVO> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 초기화
        init();
    }

    public void onInit(View view) {
        Log.i(TAG, ">>>>>   userList.size :  " + userList.size());
    }

    public void onInsert(View view) {
        //유저 정보 데이터 DB 저장
        try {
            mRealm.beginTransaction();
            UserVO user = mRealm.createObject(UserVO.class, "John");
            user.setAge(27);
            //mRealm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, ">>>>>   Primary Key :  겹침");
        } finally {
            mRealm.commitTransaction();
        }

        Log.i(TAG, ">>>>>   userList.size :  " + userList.size());
    }

    public void onDelete(View view) {
        //유저 정보 삭제
        mRealm.beginTransaction();
        RealmResults<UserVO> userList = mRealm.where(UserVO.class).findAll();
        //userList.deleteFromRealm(0);
        //userList.deleteAllFromRealm();
        mRealm.commitTransaction();

        Log.i(TAG, ">>>>>   userList.size :  " + userList.size());
    }

    public void onGet(View view) {
        mRealm.beginTransaction();
        RealmResults<UserVO> userList = mRealm.where(UserVO.class).equalTo("name", "John").findAll();
        mRealm.commitTransaction();

        Log.i("최종 확인 : ", "이름 : " + userList.get(0).getName() + ", 나이 : " + userList.get(0).getAge());
    }

    /**
     * 데이터 초기화
     */
    private void init() {
        // Realm을 초기화합니다.
        Realm.init(this);
        // 이 스레드에서 Realm 인스턴스 얻기
        mRealm = Realm.getDefaultInstance();
        userList = mRealm.where(UserVO.class).findAll();
    }
}
