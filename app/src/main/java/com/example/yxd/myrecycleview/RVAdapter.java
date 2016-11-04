package com.example.yxd.myrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    public int getItemViewType(int position) {
        if (position==0)
        {
            return 1;
        }
        return 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType)
        {
            case 1:
                MyHeaViewHolder myHeaViewHolder=new MyHeaViewHolder(inflater.inflate(R.layout.head,parent,false));
                return myHeaViewHolder;

            case 2:
                MyViewHolder holder=new MyViewHolder(inflater.inflate(R.layout.item,parent,false));
                return holder;

            default:
                MyViewHolder myViewHolder=new MyViewHolder(inflater.inflate(R.layout.item,parent,false));
                return myViewHolder;

        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==1 && position==0)
        {
            ((MyHeaViewHolder)holder).tv.setText("recycleView的头部");
            ((MyHeaViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContex,position+"",Toast.LENGTH_LONG).show();
                }
            });

        }
        if (getItemViewType(position)==2 && position!=0)
        {
            ((MyViewHolder)holder).tv.setText(itemStrings[position-1]);
            ((MyViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContex,position+"",Toast.LENGTH_LONG).show();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return itemStrings.length+1;
    }
    class  MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
    class MyHeaViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;

        public MyHeaViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.heae_text);
        }
    }
}
