package com.example.mobileprogramming_team6;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    //프래그먼트 선언//

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment fragmentNews;
    private Fragment fragmentCalender;
    private Fragment fragmentCart;
    private Fragment fragmentCalender_new;
    //private FragmentNews fragmentNews = new FragmentNews();
    //private FragmentCalender fragmentCalender = new FragmentCalender();
    //private FragmentCart fragmentCart = new FragmentCart();
    //private FragmentCalender_new fragmentCalender_new = new FragmentCalender_new();

    //객체를 담을 Array배열 선언//
    private ArrayList<Stock> arrayList1;
    private ArrayList<Stock> arrayList2;
    private ArrayList<Stock> arrayList3;
    private ArrayList<Stock> arrayList4;
    private ArrayList<Stock> arrayList5;
    private ArrayList<Stock> arrayList6;
    private ArrayList<Stock> arrayList7;
    private ArrayList<Stock> arrayList8;
    private ArrayList<Stock> arrayList9;
    private ArrayList<Stock> arrayList10;
    private ArrayList<Stock> arrayList11;
    private ArrayList<Stock> arrayList12;


    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    //데이터베이스 연동, 연결//
     void dbRef(ArrayList<Stock> arr, String month){
        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("2021년 청약일정/"+ month); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arr.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("Data", snapshot.toString());
                    Stock stock = snapshot.getValue(Stock.class); // 만들어뒀던 Stock 객체에 데이터를 담는다

                    arr.add(stock); // 담은 데이터들을 배열리스트에 넣는다
                }
                Log.d("Database", "Value is: " + arr.toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던중 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        fragmentNews = new FragmentNews();

        transaction.replace(R.id.frameLayout, fragmentNews).commit();
        //transaction.replace(R.id.frameLayout, fragmentNews).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        arrayList1 = new ArrayList<>(); // Stock객체를 담을 배열 리스트 ex)arrayList1은 1월달 공모주
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList4 = new ArrayList<>();
        arrayList5 = new ArrayList<>();
        arrayList6 = new ArrayList<>();
        arrayList7 = new ArrayList<>();
        arrayList8 = new ArrayList<>();
        arrayList9 = new ArrayList<>();
        arrayList10 = new ArrayList<>();
        arrayList11 = new ArrayList<>();
        arrayList12 = new ArrayList<>();

        dbRef(arrayList1, "1월");
        dbRef(arrayList2, "2월");
        dbRef(arrayList3, "3월");
        dbRef(arrayList4, "4월");
        dbRef(arrayList5, "5월");
        dbRef(arrayList6, "6월");
        dbRef(arrayList7, "7월");
        dbRef(arrayList8, "8월");
        dbRef(arrayList9, "9월");
        dbRef(arrayList10, "10월");
        dbRef(arrayList11, "11월");
        dbRef(arrayList12, "12월");

        Log.d("hhhhhhhh", arrayList1.toString());



    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{ //프래그먼트 변환 코드
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch(item.getItemId()){
                case R.id.newsItem:
                    //transaction.replace(R.id.frameLayout, fragmentNews).commitAllowingStateLoss();
                    if (fragmentNews == null){
                        fragmentNews = new FragmentNews();
                        fragmentManager.beginTransaction().add(R.id.frameLayout, fragmentNews).commit();
                    }

                    if (fragmentNews != null)   fragmentManager.beginTransaction().show(fragmentNews).commit();
                    if (fragmentCalender_new != null)   fragmentManager.beginTransaction().hide(fragmentCalender_new).commit();
                    if (fragmentCart != null)   fragmentManager.beginTransaction().hide(fragmentCart).commit();
                    break;
                case R.id.calenderItem:
                    //transaction.replace(R.id.frameLayout, fragmentCalender_new).commitAllowingStateLoss();
                    if (fragmentCalender_new == null){
                        fragmentCalender_new = new FragmentCalender_new();
                        fragmentManager.beginTransaction().add(R.id.frameLayout, fragmentCalender_new).commit();
                    }

                    if (fragmentNews != null)   fragmentManager.beginTransaction().hide(fragmentNews).commit();
                    if (fragmentCalender_new != null)   fragmentManager.beginTransaction().show(fragmentCalender_new).commit();
                    if (fragmentCart != null)   fragmentManager.beginTransaction().hide(fragmentCart).commit();
                    break;
                case R.id.cartItem:
                    //transaction.replace(R.id.frameLayout, fragmentCart).commitAllowingStateLoss();
                    if (fragmentCart == null){
                        fragmentCart = new FragmentCart();
                        fragmentManager.beginTransaction().add(R.id.frameLayout, fragmentCart).commit();
                    }

                    if (fragmentNews != null)   fragmentManager.beginTransaction().hide(fragmentNews).commit();
                    if (fragmentCalender_new != null)   fragmentManager.beginTransaction().hide(fragmentCalender_new).commit();
                    if (fragmentCart != null)   fragmentManager.beginTransaction().show(fragmentCart).commit();
                    break;

            }
            return true;
        }
    }


}