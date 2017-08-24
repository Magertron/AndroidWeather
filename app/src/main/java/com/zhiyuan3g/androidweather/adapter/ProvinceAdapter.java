package com.zhiyuan3g.androidweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhiyuan3g.androidweather.R;
import com.zhiyuan3g.androidweather.db.ProvinceDB;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by Administrator on 2017/8/23.
 */

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {


    private Context context;
    private List<ProvinceDB> ProvinceDBList;

    private onItemClick onItemClick;

    public void setOnItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ProvinceAdapter(Context context, List<ProvinceDB> ProvinceDBList) {
        this.context = context;
        this.ProvinceDBList = ProvinceDBList;
    }

    public interface onItemClick {
        void onItemClick(int position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_public, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(ProvinceDBList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return ProvinceDBList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }
    }
}
