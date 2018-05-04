package com.printsaas.reportapp.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.printsaas.reportapp.R;
import com.printsaas.reportapp.bean.ProductionBean;
import com.printsaas.reportapp.utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by stone on 2018/5/3.
 */

public class ProductionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private ArrayList<ProductionBean> mDatas;
    private ArrayList<ProductionBean> mDatasFinished = new ArrayList<>();

    public ProductionListAdapter(Context mContext, ArrayList<ProductionBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.main_recycleview_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MainViewHolder) {
            ((MainViewHolder) holder).product_id.setText(mDatas.get(position).getProductId());
            ((MainViewHolder) holder).product_name.setText(mDatas.get(position).getProductName());
            ((MainViewHolder) holder).producess1.setText(mDatas.get(position).getProducessName1());
            ((MainViewHolder) holder).producess2.setText(mDatas.get(position).getProducessName2());
            ((MainViewHolder) holder).start_time.setText(mDatas.get(position).getStartTime());
            ((MainViewHolder) holder).end_time.setText(mDatas.get(position).getEndTime());

            holder.itemView.findViewById(R.id.item_detail).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showToast(mContext, "点击了item具体洗信息" + position);
                }
            });
            //设置开始上报按钮
            TextView start_production = holder.itemView.findViewById(R.id.start_production);
            start_production.setOnClickListener(new View.OnClickListener() {
                private boolean clickable = true;

                @Override
                public void onClick(View v) {
                    if (clickable) {
                        holder.itemView.findViewById(R.id.commit).setVisibility(View.VISIBLE);
                        holder.itemView.findViewById(R.id.cancle).setVisibility(View.VISIBLE);
                        clickable = false;
                    } else {
                        holder.itemView.findViewById(R.id.commit).setVisibility(View.INVISIBLE);
                        holder.itemView.findViewById(R.id.cancle).setVisibility(View.INVISIBLE);
                        clickable = true;
                    }
                }
            });
            //设置提交
            ImageView commit = holder.itemView.findViewById(R.id.commit);
            commit.setOnClickListener(new View.OnClickListener() {
                private boolean isFrist = true;//判断是不是第一次点击开始

                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    if (isFrist) {
                        TextView start_production = holder.itemView.findViewById(R.id.start_production);
                        start_production.setText("结束生产");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            start_production.setBackground(mContext.getDrawable(R.drawable.blue_shape_corner));
                        }
                        isFrist = false;
                    }else {
                        //移除已经完成的任务item
                        mDatas.remove(position);
                        mDatasFinished.add(mDatas.get(position));//存放完成的任务
                        notifyDataSetChanged();
                    }
                }
            });

            //取消按钮
            ImageView cancle = holder.itemView.findViewById(R.id.cancle);
            cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.itemView.findViewById(R.id.commit).setVisibility(View.INVISIBLE);
                    holder.itemView.findViewById(R.id.cancle).setVisibility(View.INVISIBLE);
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    // TODO: 2018/5/3 内部类
    public static class MainViewHolder extends RecyclerView.ViewHolder {
        TextView product_id, product_name, producess1, producess2, end_time, start_time;

        public MainViewHolder(View itemView) {
            super(itemView);
            product_id = itemView.findViewById(R.id.product_id);
            product_name = itemView.findViewById(R.id.product_name);

            producess1 = itemView.findViewById(R.id.producess1);
            producess2 = itemView.findViewById(R.id.producess2);

            start_time = itemView.findViewById(R.id.start_time);
            end_time = itemView.findViewById(R.id.end_time);
        }

    }
}
