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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;


public class FragmentCalender_new extends Fragment {
    ArrayList<CalendarDay> dates = new ArrayList<>(); //날짜를 저장하는 리스트(시작,끝,시작,끝,시작,끝)
    ArrayList<CalendarDay> dates_1 = new ArrayList<>(); //날짜를 저장하는 리스트
    ArrayList<Integer> colors = new ArrayList<>(); //그에대한 색깔을 저장하는 리스트
    ArrayList<String> names = new ArrayList<>();//회사 이름 리스트 (회사1, 회사1, 회사2, 회사2, 회사3, 회사3 ...)
    ArrayList<CalendarDay> dates_2 = new ArrayList<>(); //상장일을 저장하는 리스트(상장1, 상장1, 상장2, 상장2, 상장3, 상장3.....)
    Collection<Eventdecorator> e = new ArrayList<>(); //eventdecorator 저장하는 리스트
    TextView tv_selected_date;
    private RecyclerView.Adapter adapter;
    MaterialCalendarView materialCalendarView;
    RecyclerView recyclerView;
    ArrayList<Cart> c;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_calender_new, container, false) ;
        materialCalendarView = (MaterialCalendarView)rootView.findViewById(R.id.calender);
        tv_selected_date = (TextView)rootView.findViewById(R.id.tv_selected_date);


        colors.add(Color.rgb(255,204,255));
        colors.add(Color.rgb(255,204,255));
        colors.add(Color.rgb(255,255,153));
        colors.add(Color.rgb(255,255,153));
        colors.add(Color.rgb(204,204,255));
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.YELLOW);


        adddate(2021,10,11);
        adddate(2021, 10, 10);
        adddate(2021, 11, 10);
        adddate(2021, 11, 11);
        adddate(2021, 11, 11);
        adddate(2021,11,12);


        adddate2(2021, 10, 10);
        adddate2(2021, 10, 10);
        adddate2(2021, 10 , 11);
        adddate2(2021, 10 , 11);
        adddate2(2021, 10 , 11);
        adddate2(2021, 10 , 11);


        names.add("NH");
        names.add("NH");
        names.add("카카오");
        names.add("카카오");
        names.add("daum");
        names.add("daum");

        c = new ArrayList<>();


        recyclerView = rootView.findViewById(R.id.recyclerView1);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CalenderCartAdapter(c, getActivity());
        recyclerView.setAdapter(adapter);


        adapter.notifyDataSetChanged();




        for(int i = 0 ; i < dates.size()-1; i ++){
            if (i%2 == 0 ){
                ArrayList<CalendarDay> dates1 = new ArrayList<>();
                dates1.add(dates.get(i));
                dates1.add(dates.get(i+1));
                Log.d("hello", dates1.toString());
                Log.d("hello", colors.get(i).toString());
                Eventdecorator e1 = new Eventdecorator(colors.get(i), dates1);
                e.add(e1);

                materialCalendarView.addDecorators(e);
                Log.d("hello", e.toString());
            }

        }

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                tv_selected_date.setText(materialCalendarView.getSelectedDate().toString());
//                c.clear();
//                String a = materialCalendarView.getSelectedDate().toString();
//                Cart c1 = new Cart("11",a, "2021" );
//                c.add(c1);
                adapter.notifyDataSetChanged();

                for(int i = 1 ; i < dates.size()-1 ; i ++){
                    if(dates.get(i).toString().equals(materialCalendarView.getSelectedDate())){


                    }
                }


            }

        });




//        adapter.notifyDataSetChanged();
//        adapter = new CalenderCartAdapter(c, getActivity());
//        recyclerView.setAdapter(adapter);






        return rootView;
    }
}