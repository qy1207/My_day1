package com.example.my_day1;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frame.CommonModel;
import com.example.frame.CommonPresenter;
import com.example.frame.ICommonModel;
import com.example.frame.ICommonPreserent;
import com.example.frame.ICommonView;
import com.example.frame.ProjectBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ICommonView {

    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mRefreshLayout;
    private List<ProjectBean.DataBean.DatasBean> list;
    private ICommonPreserent pre;
    private int p;
    private int c;
    private ProjectAdapterA projectAdapterA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        pre.getData(p+"",c+"");
    }

    private void initView() {
        CommonModel model=new CommonModel();
        pre = new CommonPresenter(model,this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        projectAdapterA = new ProjectAdapterA(this,list);
        mRecyclerView.setAdapter(projectAdapterA);
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                p++;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                p=1;
                initData();
        }
        });
    }


    @Override
    public void onSuccess(Object[] a) {
        if (p==1){
            mRefreshLayout.finishRefresh();
            ProjectBean bean= (ProjectBean) a[0];
            list.clear();
            list.addAll(bean.getData().getDatas());
            projectAdapterA.notifyDataSetChanged();
        }else {
            mRefreshLayout.finishLoadMore();
            ProjectBean bean= (ProjectBean) a[0];
            list.addAll(bean.getData().getDatas());
            projectAdapterA.notifyDataSetChanged();
        }

    }

    @Override
    public void onFailed(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
