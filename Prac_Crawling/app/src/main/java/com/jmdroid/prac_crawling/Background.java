package com.jmdroid.prac_crawling;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by X on 12/28/2016.
 */

public class Background extends AsyncTask<Void, String, Void> {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog progressDialog;
    ArrayList<String> arrayList = new ArrayList<>();
    Context context;
    Activity activity;

    public Background(Context context) {
        this.context = context;
        activity = (Activity) context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new BackMyRecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

//        progressDialog = new ProgressDialog(context);
//        progressDialog.setTitle("Please wait...");
//        progressDialog.setMessage("Loading contacts...");
//        progressDialog.setIndeterminate(true);
//        progressDialog.setCancelable(false);
//        progressDialog.show();


    }

    @Override
    protected Void doInBackground(Void... voids) {
//        String url1 = "http://10.0.3.2/Contacts/displayContacts.php";
//        String data = "";
//
//
//        try {
//            URL url = new URL(url1);
//            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuilder sb = new StringBuilder();
//            String line="";
//            while ((line=bufferedReader.readLine())!=null){
//                sb.append(line+"\n");
//            }
//            String json_data = sb.toString().trim();
//            Log.d("JSON",json_data);
//            JSONObject jsonObject = new JSONObject(json_data);
//            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
//            int count = 0;
//            while (count<jsonArray.length()){
//                JSONObject JO = jsonArray.getJSONObject(count);
//                count++;
//                Thread.sleep(300);
//                ContactModel contactModel = new ContactModel(JO.getString("name"),JO.getInt("number"));
//                publishProgress(contactModel);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return null;
        try {
            String url = "http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx";
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select("div.gallery-item-group > a > img");

            Log.i("확인 : ", elements.size() + "개");

            int i = 0;

            for (Element element : elements) {
                Log.i("확인 : ", ++i + "번째 : http://www.gettyimagesgallery.com" + element.attr("src"));
                //Single_Value.getInstance().imageData.add("http://www.gettyimagesgallery.com" + element.attr("src"));
//                int position = Single_Value.getInstance().imageData.size();
//                Single_Value.getInstance().imageData.add("http://www.gettyimagesgallery.com" + element.attr("src"));
//                myRecyclerAdapter.notifyItemInserted(position);
//                myRecyclerAdapter.notifyDataSetChanged();
                Thread.sleep(200);
                publishProgress("http://www.gettyimagesgallery.com" + element.attr("src"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }

    @Override
    protected void onProgressUpdate(String... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // progressDialog.dismiss();
    }
}
