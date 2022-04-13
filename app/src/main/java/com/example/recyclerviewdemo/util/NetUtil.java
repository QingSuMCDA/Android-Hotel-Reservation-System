package com.example.recyclerviewdemo.util;

import android.content.ContentProviderOperation;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetUtil {


    public static String doGet(){
        OkHttpClient okHttpClient = new OkHttpClient();
        String results = "";
        String jsonRaw = "";
        Request request = new Request.Builder()
                .url("https://booking-com.p.rapidapi.com/v1/hotels/search?checkout_date=2022-10-01&units=metric&dest_id=-553173&dest_type=city&locale=en-us&adults_number=2&order_by=popularity&filter_by_currency=CAD&checkin_date=2022-09-27&room_number=1&children_number=2&page_number=0&children_ages=5%2C0&categories_filter_ids=class%3A%3A2%2Cclass%3A%3A4%2Cfree_cancellation%3A%3A1&include_adjacency=true")
                .get()
                .addHeader("X-RapidAPI-Host", "booking-com.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "20616d1505msh9ba31309e10bd41p135580jsnfc78fb11134a")
                .build();

        Call call = okHttpClient.newCall(request);
        try{
            Response response = call.execute();
            jsonRaw = response.body().string();

            Log.e("URL Req", "getSync: " + jsonRaw);
        }catch (IOException e){
            e.printStackTrace();
        }
//        parseJsonDataAndShow(jsonRaw);
        try{
            JSONObject jsonObject = new JSONObject(jsonRaw);
//            String hotelSearchPrimaryCount = jsonObject.optString("primary_count");
//            String hotelSearchUnfilteredCount = jsonObject.optString("unfiltered_count");
//            String hotelSearchSort = jsonObject.optString("sort");
//            expJsonObj = jsonObject;

            String hotelSearchResult = jsonObject.optString("result");

//            JSONObject jsonObject2 = new JSONObject(hotelSearchResult);
//            String hotelSearchResultName = jsonObject2.optString("wishlist_count");
            try {
                JSONArray array = new JSONArray(hotelSearchResult);

                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String hotelName = object.optString("hotel_name_trans");
                    String hotelPrice = object.optString("min_total_price");
                    buffer.append("name：" + hotelName + ",  price：" + hotelPrice + ";\n");
                }

                results = buffer.toString();

            }catch(JSONException e1){
                e1.printStackTrace();
            }

        }catch(JSONException e){
            e.printStackTrace();
        }

        return results;

    }

}
