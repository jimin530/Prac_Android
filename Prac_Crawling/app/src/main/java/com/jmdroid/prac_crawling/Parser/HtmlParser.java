package com.jmdroid.prac_crawling.Parser;

import android.os.AsyncTask;
import android.util.Log;

import com.jmdroid.prac_crawling.Single_Value;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlParser extends AsyncTask<String, Void, String> {

    private ParserResponseInterface parserResponseInterface;

    public HtmlParser(ParserResponseInterface parserResponseInterface) {
        this.parserResponseInterface = parserResponseInterface;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            String url = "http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx";
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select("div.gallery-item-group > a > img");

            Log.i("확인 : ", elements.size() + "개");

            for (Element element : elements) {
                // Log.i("확인 : ", "http://www.gettyimagesgallery.com" + element.attr("src"));
                Single_Value.getInstance().imageData.add("http://www.gettyimagesgallery.com" + element.attr("src"));
            }

        } catch (Exception e) {
            return "FAIL";
        }

        return "SUCCESS";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        parserResponseInterface.onParsingDone(result);
    }
}
