package com.example.mobileprogramming_team6;

//기업들의 이름과 상장일 객체를 만들 class
public class Stock {
    private String listingDate; // 상장일
    private String subscriptDate; // 청약일

    public Stock(){}

    public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }

    public String getSubscriptDate() {
        return subscriptDate;
    }

    public void setSubscriptDate(String subscriptDate) {
        this.subscriptDate = subscriptDate;
    }
}
