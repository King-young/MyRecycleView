package com.example.yxd.myrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yxd on 2016/11/3.
 */
public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContex;
    private LayoutInflater inflater;
    private List<String> mDatas;
    private MyOnItemClickListener onItemClickListener;

    public RVAdapter(Context mContex) {
        this.mContex = mContex;
        this.inflater = LayoutInflater.from(mContex);
        mDatas=new ArrayList<>();
        mDatas.add("aa");
        mDatas.add("qq");
        mDatas.add("ww");
        mDatas.add("ee");
        mDatas.add("rr");
        mDatas.add("tt");
        mDatas.add("yy");
        mDatas.add("uu");
        mDatas.add("ii");
        mDatas.add("oo");
        mDatas.add("pp");
        mDatas.add("ss");
        mDatas.add("dd");
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
    int a=0;
    public void addData(int position) {

        mDatas.add(position, "Insert"+a);
        notifyItemInserted(position);                       //
        notifyItemRangeChanged(position,mDatas.size()+1);
        notifyDataSetChanged();
        a++;
    }

    public void removeData(int position) {
        mDatas.remove(position-1);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDatas.size()+1);
        notifyDataSetChanged();

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
                    addData(mDatas.size());
                }
            });

        }
        if (getItemViewType(position)==2 && position!=0)
        {
            ((MyViewHolder)holder).tv.setText(mDatas.get(position-1));
            ((MyViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContex,position+"",Toast.LENGTH_LONG).show();
                    removeData(position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mDatas.size()+1;
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
