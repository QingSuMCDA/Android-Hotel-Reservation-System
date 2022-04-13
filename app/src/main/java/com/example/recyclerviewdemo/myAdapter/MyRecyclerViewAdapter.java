package com.example.recyclerviewdemo.myAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.myBean.HotelBean;

import java.util.List;
import java.util.Random;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<HotelBean> mBeanList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, List<HotelBean> mBeanList){
        this.mContext = context;
        this.mBeanList = mBeanList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return mBeanList.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HotelBean hotelBean = mBeanList.get(position);
        holder.mTvName.setText(hotelBean.getHotelName());
        holder.mTvPrice.setText(hotelBean.getHotelPrice());
        holder.mIvImage.setImageResource(hotelBean.getImgResourceID());

        Random random = new Random();
        int rand = random.nextInt(40) - 10;
        holder.mIvImage.setLayoutParams(new RelativeLayout.LayoutParams(dip2px(168), dip2px(150 + rand)));

    }


    private int dip2px(int dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTvName;
        TextView mTvPrice;
        ImageView mIvImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mIvImage = itemView.findViewById(R.id.iv_img);
            this.mTvName = itemView.findViewById(R.id.tv_name);
            this.mTvPrice = itemView.findViewById(R.id.tv_price);

        }
    }

}
