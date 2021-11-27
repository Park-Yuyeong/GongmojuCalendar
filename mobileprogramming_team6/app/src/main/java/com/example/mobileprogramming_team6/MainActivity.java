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
    private FragmentNews fragmentNews = new FragmentNews();
    private FragmentCalender fragmentCalender = new FragmentCalender();
    private FragmentCart fragmentCart = new FragmentCart();
    private FragmentCalender_new fragmentCalender_new = new FragmentCalender_new();

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

    // 알림 코드 구현 시 필요한 변수들
    private AlarmManager alarmManager;
    private GregorianCalendar mCalendar;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    String date = "2021-11-24"; // 임의의 날짜 설정

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
        transaction.replace(R.id.frameLayout, fragmentNews).commitAllowingStateLoss();
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
        // notification
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        mCalendar = new GregorianCalendar();

        // 알람 버튼, 임시(프엔 작성 후 맞게 수정)
        //Button button = (Button) findViewById(R.id.btntest);
        //button.setOnClickListener(new View.OnClickListener(){
            //@Override
            //public void onClick(View v){
                //Log.d("button", "button click!!");
                //setAlarm();
            //}
        //});



    }


    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{ //프래그먼트 변환 코드
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch(item.getItemId()){
                case R.id.newsItem:
                    transaction.replace(R.id.frameLayout, fragmentNews).commitAllowingStateLoss();
                    break;
                case R.id.calenderItem:
                    transaction.replace(R.id.frameLayout, fragmentCalender_new).commitAllowingStateLoss();
                    break;
                case R.id.cartItem:
                    transaction.replace(R.id.frameLayout, fragmentCart).commitAllowingStateLoss();
                    break;

            }
            return true;
        }
    }

    // 알림 ON
    private void setAlarm(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, receiverIntent, 0);

        Log.d("setAlarm", "setAlarm() start!!");

        String form = date + " 10:49:30"; // test
        // String form = date + " 22:00:00"; // 실제 구현시 알람이 울리는 시각

        // 날짜 포맷을 바꿔주는 소스코드
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = null;
        try{
            datetime = dateFormat.parse(form);
        } catch (ParseException e){
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);

        Log.d("setAlarm", form + "에 알람 울림!");


        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    public void btn(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.38.co.kr/html/fund/?o=v&no=1720&l=&page=1"));
        startActivity(intent);
    }

}