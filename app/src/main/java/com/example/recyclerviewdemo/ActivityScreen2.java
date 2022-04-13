package com.example.recyclerviewdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerviewdemo.myAdapter.MyRecyclerViewAdapter;
import com.example.recyclerviewdemo.myBean.HotelBean;
import com.example.recyclerviewdemo.util.NetUtil;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ActivityScreen2 extends AppCompatActivity {

    private List<HotelBean> mHotelBeanList;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private TextView tvContent;
    private String strFromNet;
    private OkHttpClient okHttpClient;
    private int[] imgs = {
        R.drawable.hotel1,
        R.drawable.hotel2,
        R.drawable.hotel3,
        R.drawable.hotel4,
        R.drawable.hotel5,
        R.drawable.hotel6,
        R.drawable.hotel7,
        R.drawable.hotel8,
        R.drawable.hotel9
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        tvContent = findViewById(R.id.tv_content);
        okHttpClient = new okhttp3.OkHttpClient();

//        String strData = NetUtil2.getSync();
//        tvContent.setText(strData);

        initView();
        initData();
        initEvent();

    }

    private void initView(){
        mRecyclerView = findViewById(R.id.rlv);
    }

    private void initData(){

        mHotelBeanList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            HotelBean hotelBean = new HotelBean();
            hotelBean.setHotelName("Hotel No." + i);
            hotelBean.setHotelPrice("$" + i * 100);
            hotelBean.setImgResourceID(imgs[i % imgs.length]);
            mHotelBeanList.add(hotelBean);
        }

    }

    private void initEvent(){
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, mHotelBeanList);
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public String getCheckInDateStr(){
        Calendar calendar = Calendar.getInstance();
        SharedPreferences spRecord = getSharedPreferences("spRecord", MODE_PRIVATE);
        int checkInYear = spRecord.getInt("check_in_year", calendar.get(calendar.YEAR));
        int checkInMonth = spRecord.getInt("check_in_month", calendar.get(calendar.MONTH)+1);
        int checkInDay = spRecord.getInt("check_in_day", calendar.get(calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
        Calendar cCheckIn = Calendar.getInstance();
        cCheckIn.set(checkInYear, checkInMonth + 1, checkInDay, 0, 0);
        Date dateCheckIn = cCheckIn.getTime();

        return sdf.format(dateCheckIn);
    }

    public String getCheckOutDateStr(){
        Calendar calendar = Calendar.getInstance();
        SharedPreferences spRecord = getSharedPreferences("spRecord", MODE_PRIVATE);
        int checkOutYear = spRecord.getInt("check_out_year", calendar.get(calendar.YEAR));
        int checkOutMonth = spRecord.getInt("check_out_month", calendar.get(calendar.MONTH)+1);
        int checkOutDay = spRecord.getInt("check_out_day", calendar.get(calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
        Calendar cCheckOut = Calendar.getInstance();
        cCheckOut.set(checkOutYear, checkOutMonth + 1, checkOutDay, 0, 0);
        Date dateCheckOut = cCheckOut.getTime();

        return sdf.format(dateCheckOut);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {


            case R.id.menu_linear:
                RecyclerView.LayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(llManager);
                return true;

            case R.id.menu_grid:
                RecyclerView.LayoutManager gdManager = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(gdManager);
                return true;

            case R.id.menu_stagger:
                RecyclerView.LayoutManager stManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(stManager);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void jumpToConfirmPage(View view) {
        Intent intent = new Intent(ActivityScreen2.this, ActivityScreen3.class);
        startActivity(intent);

    }

}