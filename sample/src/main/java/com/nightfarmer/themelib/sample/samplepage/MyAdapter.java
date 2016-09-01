package com.nightfarmer.themelib.sample.samplepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nightfarmer.themelib.sample.R;

/**
 * Created by zhangfan on 16-9-1.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.item_tv.setText("recyclerViewItem " + position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView item_tv;


        public MyHolder(View itemView) {
            super(itemView);
            item_tv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
