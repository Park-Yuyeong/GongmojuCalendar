package com.example.mobileprogramming_team6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentCalender extends Fragment {
    Calendar cal = Calendar.getInstance();
    String weekDay;
    Integer year;
    Integer month;
    Integer day;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_calender, container, false) ;
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE", Locale.getDefault());
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        String weekDay = weekdayFormat.format(currentTime);
        year = Integer.parseInt(yearFormat.format(currentTime));
        month = Integer.parseInt(monthFormat.format(currentTime));
        day = Integer.parseInt(dayFormat.format(currentTime));
        Log.d("webnautes", year + "년 " + month + "월 " + day + "일 " + weekDay + "요일");

        TextView tvYear = (TextView)rootView.findViewById(R.id.tvYear);
        TextView tvMonth = (TextView)rootView.findViewById(R.id.tvMonth);
        tvYear.setText(year.toString());
        tvMonth.setText(month.toString());


        return rootView;

    }

    public void Calender_update(){


    }



}
