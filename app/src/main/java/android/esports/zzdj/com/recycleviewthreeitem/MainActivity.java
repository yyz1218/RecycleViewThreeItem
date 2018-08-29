package android.esports.zzdj.com.recycleviewthreeitem;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Activity activity;
    private MyRecycleViewAdapter adapter;
    private ArrayList<ItemBean> list;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }
    private void initView() {
        activity = this;
        recyclerView = findViewById(R.id.recyclerView);
        btn1 = findViewById(R.id.btn1);
    }
    private void initData() {
        list = new ArrayList<>();
        ItemBean itemBean;
        for(int i=0;i<20;i++){
            itemBean = new ItemBean();
            itemBean.setContent("三行测试"+i);
            itemBean.setSelect(false);
            list.add(itemBean);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        //设置添加或删除item时的动画，这里使用默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyRecycleViewAdapter(activity,list);
        recyclerView.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity",list.toString());
            }
        });
    }
}
