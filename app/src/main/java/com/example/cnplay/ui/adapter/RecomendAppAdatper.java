package com.example.cnplay.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cnplay.R;
import com.example.cnplay.bean.AppInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     author:LHT
 *     date:20190814
 *     desc:推荐   Adapter
 * </pre>
 */
public class RecomendAppAdatper extends RecyclerView.Adapter<RecomendAppAdatper.ViewHolder> {

    private Context mContext;
    private List<AppInfo> mDatas;

    private LayoutInflater mLayoutInflater;

    public RecomendAppAdatper(Context context, List<AppInfo> datas) {
        mContext = context;
        mDatas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.template_recomend_app, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        AppInfo appInfo = mDatas.get(i);

        String baseImgUtl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
        Glide.with(mContext)
                .load(baseImgUtl + appInfo.getIcon())
                .placeholder(R.mipmap.icon_bird)//设置默认占位图
                .into(viewHolder.imgIcon);
        viewHolder.textTitle.setText(appInfo.getDisplayName());
        viewHolder.textSize.setText((appInfo.getApkSize() /1024/1024) + " MB");

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.text_title)
        TextView textTitle;
        @BindView(R.id.text_size)
        TextView textSize;
        @BindView(R.id.btn_dl)
        Button btnDl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
