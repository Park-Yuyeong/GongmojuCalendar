package com.example.mobileprogramming_team6;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.EventListener;
import java.util.Random;


public class FragmentCalender_new extends Fragment {
    ArrayList<CalendarDay> dates = new ArrayList<>(); //날짜를 저장하는 리스트
    ArrayList<Integer> colors = new ArrayList<>(); //그에대한 색깔을 저장하는 리스트
    Collection<Eventdecorator> e = new ArrayList<>(); //eventdecorator 저장하는 리스트
    TextView tv_selected_date;
    MaterialCalendarView materialCalendarView;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public void adddate(int year, int month, int day){ //날짜 리스트 만드는 함수

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        CalendarDay day1 = CalendarDay.from(calendar);

        dates.add(day1);
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

            }
        });





        return rootView;
    }
}