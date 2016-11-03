package com.example.yxd.myrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Yxd on 2016/11/3.
 */
public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContex;
    private LayoutInflater inflater;
    private String[] itemStrings={"aaaaa","bbbbb","ccccc","ddddd","eeeee","fffff","ggggg","hhhhh"};
    private MyOnItemClickListener onItemClickListener;

    public RVAdapter(Context mContex) {
        this.mContex = mContex;
        this.inflater = LayoutInflater.from(mContex);
    }

    public void setOnItemClickListener(MyOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(inflater.inflate(R.layout.item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder)holder).tv.setText(itemStrings[position]);
        if (onItemClickListener!=null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView,position,itemStrings[position]);
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return itemStrings.length;
    }
    class  MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
