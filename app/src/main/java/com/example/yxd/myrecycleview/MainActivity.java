package com.example.yxd.myrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyOnItemClickListener myOnItemClickListener;
    private RVAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.Recycleview);
        recyclerView.setLayoutManager(gridLayoutManager=new GridLayoutManager(MainActivity.this,6));
        adapter=new RVAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(myOnItemClickListener=new MyOnItemClickListener() {

            @Override
            public void onItemClick(View view, int postion, String itemString) {
                Toast.makeText(MainActivity.this,"第"+postion+"项的值是"+itemString,Toast.LENGTH_LONG).show();
            }
        });
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (adapter.getItemViewType(position)==1) ? gridLayoutManager.getSpanCount() :1; //返回的数值表示当前的item占总份数的比重
            }
        });



    }
}
