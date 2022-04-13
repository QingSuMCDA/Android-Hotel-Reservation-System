package com.example.recyclerviewdemo.myBean;

import java.io.Serializable;

public class HotelBean implements Serializable {
    private String hotelName;
    private String hotelPrice;
    private int imgResourceID;


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public int getImgResourceID() {
        return imgResourceID;
    }

    public void setImgResourceID(int imgResourceID) {
        this.imgResourceID = imgResourceID;
    }
}
