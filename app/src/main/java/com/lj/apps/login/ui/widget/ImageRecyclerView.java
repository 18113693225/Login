package com.lj.apps.login.ui.widget;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lj.apps.login.R;

import java.util.ArrayList;
import java.util.List;

public class ImageRecyclerView extends RecyclerView {
    private static final int spanCount = 3;
    private SimpleAdapter mAdapter;

    public ImageRecyclerView(Context context) {
        this(context, null);
    }

    public ImageRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    private void initialize() {
        setNestedScrollingEnabled(false);
        setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        mAdapter = new SimpleAdapter();
        setAdapter(mAdapter);
    }

    public void setData(List<String> data, OnItemClickListener listener) {
        mAdapter.setData(data, listener);
    }

    static class SimpleViewHolder extends ViewHolder {
        public Context mContext;
        public String data;
        public ImageView img;


        private SimpleViewHolder(Context context, ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.list_item_image, parent, false));
            mContext = context;
            img = (ImageView) itemView.findViewById(R.id.icon);
        }

        static SimpleViewHolder create(Context context, ViewGroup parent) {
            return new SimpleViewHolder(context, parent);
        }

        public void bind(String data) {
            this.data = data;
            Glide.with(mContext).load(data).error(R.mipmap.ic_launcher).into(img);
        }

    }

    /**
     * RecyclerView适配器
     */
    private class SimpleAdapter extends Adapter<ViewHolder> {
        private ArrayList<String> mData;
        private OnItemClickListener mOnItemClickListener;

        public SimpleAdapter() {
            mData = new ArrayList<>();
        }


        public void setData(List<String> data, OnItemClickListener listener) {
            this.mOnItemClickListener = listener;
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return SimpleViewHolder.create(getContext(), parent);
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String data = mData.get(position);
            SimpleViewHolder viewHolder = (SimpleViewHolder) holder;
            viewHolder.bind(data);
            viewHolder.itemView.setTag(data);
            setOnClickListener(viewHolder);
        }

        protected void setOnClickListener(final RecyclerView.ViewHolder holder) {
            if (mOnItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int layoutPosition = holder.getPosition();
                        String data = (String) holder.itemView.getTag();
                        mOnItemClickListener.onSubjectItemClick(holder.itemView, data, layoutPosition);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    public interface OnItemClickListener {
        void onSubjectItemClick(View v, String data, int position);
    }

}
