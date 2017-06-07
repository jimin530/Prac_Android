package com.jmdroid.prac_crawling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jmdroid.prac_crawling.Parser.HtmlParser;
import com.jmdroid.prac_crawling.Parser.ParserResponseInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ParserResponseInterface {

    RecyclerView recyclerView;
    public static MyRecyclerAdapter myRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;

    boolean isLoading;
    boolean isLastPage;
    int page_size = 7;

    int finishCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageProc.getInstance().getImageLoader(this);
        Single_Value.getInstance().context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnScrollListener(recyclerViewViewOnScrollListener);

        gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        // recyclerView.setLayoutManager(gridLayoutManager);

        new HtmlParser(this).execute();
//        Background background = new Background(this);
//        background.execute();
    }

    private RecyclerView.OnScrollListener recyclerViewViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int visibleItemCount = linearLayoutManager.getChildCount();
            int toalItemCount = linearLayoutManager.getItemCount();
            int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

            if (!isLoading && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= toalItemCount && firstVisibleItemPosition >= 0 && toalItemCount >= page_size) {
                    Toast.makeText(MainActivity.this, "페이징", Toast.LENGTH_SHORT).show();
                    loadMoreItems();
                }
            }
        }
    };

    @Override
    public void onParsingDone(String result) {
        Log.i("OK?", result);

        myRecyclerAdapter = new MyRecyclerAdapter(this, getItems());
        recyclerView.setAdapter(myRecyclerAdapter);
    }

    private void loadMoreItems() {
        myRecyclerAdapter.addItems(getItems());
        myRecyclerAdapter.notifyDataSetChanged();
    }

    private ArrayList<String> getItems() {
        ArrayList<String> items = new ArrayList<>();
        int i = 0;
        for (i = finishCount; i < finishCount + 7; i++) {
            items.add(Single_Value.getInstance().imageData.get(i).toString());
        }
        finishCount = i + 1;
        return items;
    }
}
