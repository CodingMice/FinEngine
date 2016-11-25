package com.ifinver.myopengles.singleswitch;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ifinver.myopengles.MyApp;
import com.ifinver.myopengles.R;
import com.ifinver.myopengles.sdk.TextureRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iFinVer on 2016/11/25.
 * ilzq@foxmail.com
 */

class FilterAdapter extends RecyclerView.Adapter<FilterViewHolder>{

    private List<FilterDataModel> mDataList;
    private OnItemClickListener mOnItemClickListener;

    public FilterAdapter(OnItemClickListener listener){
        mOnItemClickListener = listener;
        mDataList = new ArrayList<>();
        FilterDataModel model;

        model = new FilterDataModel();
        model.filterName = "Normal";
        model.filterType = TextureRenderer.FILTER_TYPE_NORMAL;
        mDataList.add(model);

        model = new FilterDataModel();
        model.filterName = "Cyan";
        model.filterType = TextureRenderer.FILTER_TYPE_CYAN;
        mDataList.add(model);

        model = new FilterDataModel();
        model.filterName = "Fish eye";
        model.filterType = TextureRenderer.FILTER_TYPE_FISH_EYE;
        mDataList.add(model);

        model = new FilterDataModel();
        model.filterName = "Grey scale";
        model.filterType = TextureRenderer.FILTER_TYPE_GREY_SCALE;
        mDataList.add(model);

        model = new FilterDataModel();
        model.filterName = "Negative color";
        model.filterType = TextureRenderer.FILTER_TYPE_NEGATIVE_COLOR;
        mDataList.add(model);
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View filterView = View.inflate(MyApp.getContext(), R.layout.list_item_filter, parent);
        return new FilterViewHolder(filterView);
    }

    @Override
    public void onBindViewHolder(final FilterViewHolder holder, int position) {
        Resources resources = MyApp.getContext().getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher);
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(resources, bitmap);
        holder.ivFilter.setImageDrawable(drawable);
        final FilterDataModel filterDataModel = mDataList.get(position);
        holder.tvFilter.setText(filterDataModel.filterName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onFilterItemClick(filterDataModel.filterType);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    interface OnItemClickListener{
        void onFilterItemClick(int filter);
    }
}
