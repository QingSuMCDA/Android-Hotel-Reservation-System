package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ActivityScreen3 extends AppCompatActivity {

    private TextView tvHotelName;
    private TextView tvCheckInDate;
    private TextView tvCheckOutDate;
    private TextView tvPrice;
    private TextView tvGuestName;
    private String defaultHotel;
    private String defaultPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        tvHotelName = findViewById(R.id.tv_confirm_hotel_name);
        tvCheckInDate = findViewById(R.id.tv_confirm_check_in_date);
        tvCheckOutDate = findViewById(R.id.tv_confirm_check_out_date);
        tvPrice = findViewById(R.id.tv_confirm_price);
        tvGuestName = findViewById(R.id.tv_confirm_guest_name);

        defaultHotel = "Halifax Hampton Inn";
        tvHotelName.setText(defaultHotel);

        tvCheckInDate.setText(getCheckInDateStr());
        tvCheckOutDate.setText(getCheckOutDateStr());

        defaultPrice = "$249.99";
        tvPrice.setText(defaultPrice);

        tvGuestName.setText(getGuestNameStr());

    }

    public String getCheckInDateStr(){
        Calendar calendar = Calendar.getInstance();
        SharedPreferences spRecord = getSharedPreferences("spRecord", MODE_PRIVATE);
        int checkInYear = spRecord.getInt("check_in_year", calendar.get(calendar.YEAR));
        int checkInMonth = spRecord.getInt("check_in_month", calendar.get(calendar.MONTH)+1);
        int checkInDay = spRecord.getInt("check_in_day", calendar.get(calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
        Calendar cCheckIn = Calendar.getInstance();
        cCheckIn.set(checkInYear, checkInMonth, checkInDay, 0, 0);
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
        cCheckOut.set(checkOutYear, checkOutMonth, checkOutDay, 0, 0);
        Date dateCheckOut = cCheckOut.getTime();

        return sdf.format(dateCheckOut);
    }

    public String getGuestNameStr(){
        SharedPreferences spRecord = getSharedPreferences("spRecord", MODE_PRIVATE);
        String guestName = "";
        guestName = spRecord.getString("name", "");
        return guestName;
    }

    public void confirm(View view) {
        Intent intent = new Intent(ActivityScreen3.this, ActivityScreen4.class);
        startActivity(intent);
    }

}