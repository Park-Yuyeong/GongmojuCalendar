package com.example.mobileprogramming_team6;

//기업들의 이름과 상장일 객체를 만들 class
public class Stock {
    private String name; // 기업명
    private String listingDate; // 상장일
    private String month; // 해당 월
    private String subscriptDate; // 청약일
    private String infor; // 기업정보

    public Stock() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public String getInfor(){return infor;}

    public void setInfor(String infor) { this.infor = infor;}

}
