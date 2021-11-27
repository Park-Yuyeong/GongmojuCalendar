package com.example.mobileprogramming_team6;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

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


//
//        dbRef(arrayList1, "1월");
//        dbRef(arrayList2, "2월");
//        dbRef(arrayList3, "3월");
//        dbRef(arrayList4, "4월");
//        dbRef(arrayList5, "5월");
//        dbRef(arrayList6, "6월");
//        dbRef(arrayList7, "7월");
//        dbRef(arrayList8, "8월");
//        dbRef(arrayList9, "9월");
//        dbRef(arrayList10, "10월");
//        dbRef(arrayList11, "11월");
//        dbRef(arrayList12, "12월");
//
//        Log.d("hhhhhhhh", arrayList1.toString());



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


    //관심종목의 기업이름 클릭시 사이트로 이동

    public void btn(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.38.co.kr/html/fund/?o=v&no=1720&l=&page=1"));
        startActivity(intent);
    }

    public void btn1(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.38.co.kr/html/fund/?o=v&no=1720&l=&page=1"));
        startActivity(intent);
    }


}