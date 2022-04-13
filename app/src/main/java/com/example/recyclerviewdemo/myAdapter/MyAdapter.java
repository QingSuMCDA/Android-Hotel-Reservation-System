package com.example.recyclerviewdemo.myAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewdemo.myBean.HotelBean;
import com.example.recyclerviewdemo.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<HotelBean> mBeanList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private MyAdapter(Context context, List<HotelBean> mBeanList){
        this.mContext = context;
        this.mBeanList = mBeanList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return mBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        // Build view controller
        convertView = mLayoutInflater.inflate(R.layout.item_layout, viewGroup, false);
        ImageView imageView = convertView.findViewById(R.id.iv_img);
        TextView tvName = convertView.findViewById(R.id.tv_name);
        TextView tvPrice = convertView.findViewById(R.id.tv_price);

        //Pass values to the controller
        HotelBean hotelBean = mBeanList.get(i);

        imageView.setImageResource(hotelBean.getImgResourceID());
        tvName.setText(hotelBean.getHotelName());
        tvPrice.setText(hotelBean.getHotelPrice());

        return convertView;
    }
}
