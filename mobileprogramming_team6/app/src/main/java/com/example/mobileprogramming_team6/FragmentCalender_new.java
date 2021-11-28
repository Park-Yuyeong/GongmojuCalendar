package com.example.mobileprogramming_team6;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;


public class FragmentCalender_new extends Fragment {
    ArrayList<CalendarDay> dates = new ArrayList<>(); //날짜를 저장하는 리스트(시작,끝,시작,끝,시작,끝)
    ArrayList<CalendarDay> dates_1 = new ArrayList<>(); //날짜를 저장하는 리스트
//    ArrayList<Integer> colors = new ArrayList<>(); //그에대한 색깔을 저장하는 리스트
//    ArrayList<String> names = new ArrayList<>();//회사 이름 리스트 (회사1, 회사1, 회사2, 회사2, 회사3, 회사3 ...)
    ArrayList<CalendarDay> dates_2 = new ArrayList<>(); //상장일을 저장하는 리스트(상장1, 상장1, 상장2, 상장2, 상장3, 상장3.....)
    Collection<Eventdecorator> e = new ArrayList<>(); //eventdecorator 저장하는 리스트
    TextView tv_selected_date;
    private RecyclerView.Adapter adapter;
    MaterialCalendarView materialCalendarView;
    RecyclerView recyclerView;
    ArrayList<Cart> c;
    ArrayList<Stock> stockInfo;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();


    public void adddate(int year, int month, int day){ //날짜 리스트 만드는 함수

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        CalendarDay day1 = CalendarDay.from(calendar);

        dates.add(day1);
    }
    public void adddate2(int year, int month, int day){ //날짜 리스트 만드는 함수

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        CalendarDay day1 = CalendarDay.from(calendar);

        dates_2.add(day1);
    }
    public void adddate1(int year, int month, int day){ //날짜 리스트 만드는 함수

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        CalendarDay day1 = CalendarDay.from(calendar);

        dates_1.add(day1);
    }
    public String CalenderdaytoString(CalendarDay calendarDay){
        String c = calendarDay.toString().substring(12, 21);
        return c;


    }

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    //데이터베이스 연동, 연결//
     void dbRef(String month, ViewGroup rootView){
        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("2021년 청약일정/"+ month); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                c = new ArrayList<>();

                recyclerView = rootView.findViewById(R.id.recyclerView1);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Stock stock = snapshot.getValue(Stock.class);
                    int dateMonth =  Integer.parseInt(month)-1;
                    int dateListingDay =  Integer.parseInt(stock.getListingDate());
                    int dateSubscriptDay =  Integer.parseInt(stock.getSubscriptDate());
                    String name = snapshot.getKey();
                    stock.setName(name);
                    stock.setMonth(month);
                    stockInfo = new ArrayList<>();
                    stockInfo.add(stock);
//                    Log.d("name", String.valueOf(name));
                    Log.d("month", String.valueOf(dateMonth));
                    Log.d("ListingDay", String.valueOf(dateListingDay));
                    Log.d("SubscriptDay", String.valueOf(dateSubscriptDay));
                    if(dateListingDay != 0){
                        adddate2(2021, dateMonth, dateListingDay);
                    }
                    if(dateSubscriptDay != 0){
                        adddate(2021, dateMonth, dateSubscriptDay-1);
                        adddate(2021, dateMonth, dateSubscriptDay);

                    }
                    Cart c1 = new Cart();
                    c1.setListingDate("상장일 2021-" + dateMonth + "-" + dateListingDay);
                    c1.setName(name);
                    materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
                        @Override
                        public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                            Log.d("name", String.valueOf(name));
                            c.clear();
                            if(date.getDay() == dateListingDay && date.getMonth() == dateMonth){
                                Cart c1 = new Cart();
                                c1.setListingDate("상장일 2021-" + date.getMonth() + "-" + date.getDay());
                                c1.setName(name);
                                c.add(c1);
                            }
//                            if(date.getDay() == dateSubscriptDay-1 && date.getMonth() == dateMonth){
//                                Cart c1 = new Cart();
//                                c1.setSubscriptDate("청약일 2021-" + date.getMonth() + "-" + date.getDay());
//                                c1.setName(name);
//                                c.add(c1);
//                            }
//
//                            if(date.getDay() == dateSubscriptDay && date.getMonth() == dateMonth){
//                                Cart c1 = new Cart();
//                                c1.setSubscriptDate("청약일 2021-" + date.getMonth() + "-" + date.getDay());
//                                c1.setName(name);
//                                c.add(c1);
//                            }
                            adapter.notifyDataSetChanged();
                        }

                    });
                    adapter = new CalenderCartAdapter(c, getActivity());
                    recyclerView.setAdapter(adapter);
                }


                for(int i = 0 ; i < dates.size()-1; i++){
                    if (i%2 == 0 ){
                        ArrayList<CalendarDay> dates1 = new ArrayList<>();
                        dates1.add(dates.get(i));
                        dates1.add(dates.get(i+1));
//                        Log.d("hello", dates1.toString());
//                        Log.d("hello", colors.get(i).toString());
                        Eventdecorator e1 = new Eventdecorator(Color.BLUE, dates1);
                        e.add(e1);

                        materialCalendarView.addDecorators(e);
                        Log.d("hello", e.toString());
                    }
                }

                for(int i = 0; i<dates_2.size(); i++){
                    ArrayList<CalendarDay> dates1 = new ArrayList<>();
                    dates1.add(dates_2.get(i));
                    Eventdecorator e1 = new Eventdecorator(Color.RED, dates1);
                    e.add(e1);
                    materialCalendarView.addDecorators(e);
                }


            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던중 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_calender_new, container, false) ;
        materialCalendarView = (MaterialCalendarView)rootView.findViewById(R.id.calender);



//        names.add("NH");
//        names.add("NH");
//        names.add("카카오");
//        names.add("카카오");
//        names.add("daum");
//        names.add("daum");
        
        //DB에서 데이터를 가져와서 1~12달력에 찍어주는 함수//
//        dbRef("1");
//        dbRef("2");
//        dbRef("3");
//        dbRef("4");
//        dbRef("5");
//        dbRef("6");
//        dbRef("7");
//        dbRef("8");
//        dbRef("9");
//        dbRef("10");
        dbRef("11", rootView);
        dbRef("12", rootView);


//        c = new ArrayList<>();


//        recyclerView = rootView.findViewById(R.id.recyclerView1);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new CalenderCartAdapter(c, getActivity());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter.notifyDataSetChanged();
//
//
//
//
//        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
//
//                c.clear();
//                String a = materialCalendarView.getSelectedDate().toString();
//                Cart c1 = new Cart();
//                c1.setListingDate(a);
//                c1.setName("회사명");
//                c1.setSubscriptDate("2021 ~~~");
//                c.add(c1);
//                adapter.notifyDataSetChanged();
//
//                Cart c2 = new Cart();
//                c2.setListingDate(a);
//                c2.setName("ㅁㅁㅁ");
//                c2.setSubscriptDate("2021~~~");
//                c.add(c2);
//                adapter.notifyDataSetChanged();
//
//
//            }
//
//        });




//        adapter.notifyDataSetChanged();
//        adapter = new CalenderCartAdapter(c, getActivity());
//        recyclerView.setAdapter(adapter);




        return rootView;
    }
}