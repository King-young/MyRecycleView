# MyRecycleView主要功能
1：使用recycleview实现gridview的功能
2：添加头部
  2.1：实现过程：
    1：添加两种item的布局实现头部以及实现
    2：创建两个ViewHolder
    
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
    
    3：重写getViewType（）；
    
     @Override
    public int getItemViewType(int position) {
        if (position==0)
        {
            return 1;
        }
        return 2;
    }
    
    4：在adapter中重写onCreateViewHolder（ViewGroup parent, int viewType）;viewType，返回不同的ViewHolder；
3：添加点击事件
4：增加item
 public void addData(int position) {

        mDatas.add(position, "Insert"+a);
        notifyItemInserted(position);                       //
        notifyItemRangeChanged(position,mDatas.size()+1);
        notifyDataSetChanged();
        a++;
    }
5：删除item
 public void removeData(int position) {
        mDatas.remove(position-1);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDatas.size()+1);
        notifyDataSetChanged();

    }
