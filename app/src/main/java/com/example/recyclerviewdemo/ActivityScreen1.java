package com.example.recyclerviewdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;
import java.util.Date;


public class ActivityScreen1 extends AppCompatActivity {

    private Button btnConfirm, btnSearch, btnClean;
    private EditText etGuestNumber, etGuestName;
    private DatePicker dpCheckIn, dpCheckOut;
    private TextView tvConfirmMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        btnConfirm = findViewById(R.id.btn_confirm);
        btnSearch = findViewById(R.id.btn_search);
        btnClean = findViewById(R.id.btn_clean);
        etGuestNumber = findViewById(R.id.et_guest_number);
        etGuestName = findViewById(R.id.et_guest_name);
        dpCheckIn = findViewById(R.id.dp_checkin);
        dpCheckOut = findViewById(R.id.dp_checkout);
        tvConfirmMsg = findViewById(R.id.tv_confirm);


        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);

        dpCheckIn.init(year, month, date, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(getApplicationContext(), "Check-in date changed", Toast.LENGTH_SHORT).show();
                    }
                });

        String guestNumber = etGuestNumber.getText().toString();
        String guestName = etGuestNumber.getText().toString();


         // Begin the transaction
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                        // Replace the contents of the container with the new fragment
//        fragmentTransaction.replace(R.id.frame_layout, new HotelSearchFragment());

                        // Complete the changes added above
//        fragmentTransaction.commit();
    }

    public void confirmSearch(View view) {
        if(etGuestName.getText().length() > 0){
            String confirmMsg = "";
            confirmMsg = "Dear " + etGuestName.getText().toString() +
                    ", your are browsing room(s) for "  + etGuestNumber.getText().toString() + " people.";
            tvConfirmMsg.setText(confirmMsg);

        }else{

            tvConfirmMsg.setText("Please input your name.");
        }

    }

    public void jumpToHotelList(View view) {

        Calendar cCheckIn = Calendar.getInstance();
        Calendar cCheckOut = Calendar.getInstance();
        cCheckIn.set(dpCheckIn.getYear(), dpCheckIn.getMonth() + 1, dpCheckIn.getDayOfMonth(), 0, 0);
        cCheckOut.set(dpCheckOut.getYear(), dpCheckOut.getMonth() + 1, dpCheckOut.getDayOfMonth(), 0, 0);

        if (cCheckOut.after(cCheckIn)){

            //Save input data with SharedPreferences
            SharedPreferences spRecord = getSharedPreferences("spRecord", MODE_PRIVATE);
            SharedPreferences.Editor edit = spRecord.edit();
            edit.putString("number", etGuestNumber.getText().toString());
            edit.putString("name", etGuestName.getText().toString());
            edit.putInt("check_in_year", dpCheckIn.getYear());
            edit.putInt("check_in_month", dpCheckIn.getMonth());
            edit.putInt("check_in_day", dpCheckIn.getDayOfMonth());
            edit.putInt("check_out_year", dpCheckOut.getYear());
            edit.putInt("check_out_month", dpCheckOut.getMonth());
            edit.putInt("check_out_day", dpCheckOut.getDayOfMonth());
            edit.apply();

            etGuestNumber.setText("");
            etGuestName.setText("");

            //Jump to hotel list page
            Intent intent = new Intent(ActivityScreen1.this, ActivityScreen2.class);
            startActivity(intent);

        }else{
            tvConfirmMsg.setText("Sorry, check-out date should be after check-in date.");

        }

    }

    public void cleanInputText(View view) {
        etGuestName.setText("");
        etGuestNumber.setText("");
        tvConfirmMsg.setText("");
    }

}
