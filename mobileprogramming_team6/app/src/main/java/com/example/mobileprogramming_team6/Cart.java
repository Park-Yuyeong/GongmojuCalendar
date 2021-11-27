package com.example.mobileprogramming_team6;

// Cart 페이지에 넣어줄 객체 생성
public class Cart {
    private String Name; // 기업명
    private String listingDate; // 상장일
    private String subscriptDate; // 청약일

    public Cart() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

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

