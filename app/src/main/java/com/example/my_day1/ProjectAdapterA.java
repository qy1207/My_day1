package com.example.my_day1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.frame.ProjectBean;

import java.util.List;

public class ProjectAdapterA extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProjectBean.DataBean.DatasBean> list;

    public ProjectAdapterA(Context context, List<ProjectBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.aaa_item, null);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProjectBean.DataBean.DatasBean bean = list.get(position);
        ViewHolder1 viewHolder1= (ViewHolder1) holder;
        viewHolder1.title1.setText(bean.getTitle());
        Glide.with(context).load(bean.getEnvelopePic()).into(viewHolder1.image1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image1;
        public TextView title1;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image1 = (ImageView) rootView.findViewById(R.id.image1);
            this.title1 = (TextView) rootView.findViewById(R.id.title1);
        }

    }
}
