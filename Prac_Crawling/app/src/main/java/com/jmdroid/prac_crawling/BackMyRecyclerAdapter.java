package com.jmdroid.prac_crawling;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jimin on 2017. 5. 21..
 */

public class BackMyRecyclerAdapter extends RecyclerView.Adapter<BackMyRecyclerAdapter.ViewHolder> {

    ArrayList<String> arrayList = new ArrayList<>();
    public BackMyRecyclerAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
    /**
     * 레이아웃을 만들어서 Holer에 저장
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cardview_image, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * listView getView 를 대체
     * 넘겨 받은 데이터를 화면에 출력하는 역할
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.bindOnPost(
                arrayList.get(position).toString(),
                position
        );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * 뷰 재활용을 위한 viewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        // 뷰로부터 컴포넌트를 획득
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

        public void bindOnPost(String url, final int position) {

            ImageProc.getInstance().drawImage(url, imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(Single_Value.getInstance().context, position + "", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
