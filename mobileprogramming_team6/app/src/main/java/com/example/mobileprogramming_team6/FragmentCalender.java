package com.example.mobileprogramming_team6;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentCalender extends Fragment {

    Integer year;
    Integer month;
    Integer day;

    int[] calenderday = new int[35];



    private ArrayList<Stock> arrayList1 = new ArrayList<>();
    private ArrayList<Stock> arrayList2 = new ArrayList<>();
    private ArrayList<Stock> arrayList3 = new ArrayList<>();
    private ArrayList<Stock> arrayList4 = new ArrayList<>();
    private ArrayList<Stock> arrayList5 = new ArrayList<>();
    private ArrayList<Stock> arrayList6 = new ArrayList<>();
    private ArrayList<Stock> arrayList7 = new ArrayList<>();
    private ArrayList<Stock> arrayList8 = new ArrayList<>();
    private ArrayList<Stock> arrayList9 = new ArrayList<>();
    private ArrayList<Stock> arrayList10 = new ArrayList<>();
    private ArrayList<Stock> arrayList11 = new ArrayList<>();
    private ArrayList<Stock> arrayList12 = new ArrayList<>();



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
        TextView tv_1 = (TextView)rootView.findViewById(R.id.tv_1);
        TextView tv_2 = (TextView)rootView.findViewById(R.id.tv_2);
        TextView tv_3 = (TextView)rootView.findViewById(R.id.tv_3);
        TextView tv_4 = (TextView)rootView.findViewById(R.id.tv_4);
        TextView tv_5 = (TextView)rootView.findViewById(R.id.tv_5);
        TextView tv_6 = (TextView)rootView.findViewById(R.id.tv_6);
        TextView tv_7 = (TextView)rootView.findViewById(R.id.tv_7);
        TextView tv_8 = (TextView)rootView.findViewById(R.id.tv_8);
        TextView tv_9 = (TextView)rootView.findViewById(R.id.tv_9);
        TextView tv_10 = (TextView)rootView.findViewById(R.id.tv_10);
        TextView tv_11 = (TextView)rootView.findViewById(R.id.tv_11);
        TextView tv_12 = (TextView)rootView.findViewById(R.id.tv_12);
        TextView tv_13 = (TextView)rootView.findViewById(R.id.tv_13);
        TextView tv_14 = (TextView)rootView.findViewById(R.id.tv_14);
        TextView tv_15 = (TextView)rootView.findViewById(R.id.tv_15);
        TextView tv_16 = (TextView)rootView.findViewById(R.id.tv_16);
        TextView tv_17 = (TextView)rootView.findViewById(R.id.tv_17);
        TextView tv_18 = (TextView)rootView.findViewById(R.id.tv_18);
        TextView tv_19 = (TextView)rootView.findViewById(R.id.tv_19);
        TextView tv_20 = (TextView)rootView.findViewById(R.id.tv_20);
        TextView tv_21 = (TextView)rootView.findViewById(R.id.tv_21);
        TextView tv_22 = (TextView)rootView.findViewById(R.id.tv_22);
        TextView tv_23 = (TextView)rootView.findViewById(R.id.tv_23);
        TextView tv_24 = (TextView)rootView.findViewById(R.id.tv_24);
        TextView tv_25 = (TextView)rootView.findViewById(R.id.tv_25);
        TextView tv_26 = (TextView)rootView.findViewById(R.id.tv_26);
        TextView tv_27 = (TextView)rootView.findViewById(R.id.tv_27);
        TextView tv_28 = (TextView)rootView.findViewById(R.id.tv_28);
        TextView tv_29 = (TextView)rootView.findViewById(R.id.tv_29);
        TextView tv_30 = (TextView)rootView.findViewById(R.id.tv_30);
        TextView tv_31 = (TextView)rootView.findViewById(R.id.tv_31);
        TextView tv_32 = (TextView)rootView.findViewById(R.id.tv_32);
        TextView tv_33 = (TextView)rootView.findViewById(R.id.tv_33);
        TextView tv_34 = (TextView)rootView.findViewById(R.id.tv_34);
        TextView tv_35 = (TextView)rootView.findViewById(R.id.tv_35);


        Button btn_to_lastday = (Button)rootView.findViewById(R.id.btn_to_lastday);
        Button btn_to_nextday = (Button)rootView.findViewById(R.id.btn_to_nextday);




        tvYear.setText(year.toString());
        tvMonth.setText(month.toString());



        tv_1.setTextColor(Color.parseColor("#000000"));
        tv_2.setTextColor(Color.parseColor("#000000"));
        tv_3.setTextColor(Color.parseColor("#000000"));
        tv_4.setTextColor(Color.parseColor("#000000"));
        tv_5.setTextColor(Color.parseColor("#000000"));
        tv_6.setTextColor(Color.parseColor("#000000"));
        tv_7.setTextColor(Color.parseColor("#000000"));
        tv_8.setTextColor(Color.parseColor("#000000"));
        tv_9.setTextColor(Color.parseColor("#000000"));
        tv_10.setTextColor(Color.parseColor("#000000"));
        tv_11.setTextColor(Color.parseColor("#000000"));
        tv_12.setTextColor(Color.parseColor("#000000"));
        tv_13.setTextColor(Color.parseColor("#000000"));
        tv_14.setTextColor(Color.parseColor("#000000"));
        tv_15.setTextColor(Color.parseColor("#000000"));
        tv_16.setTextColor(Color.parseColor("#000000"));
        tv_17.setTextColor(Color.parseColor("#000000"));
        tv_18.setTextColor(Color.parseColor("#000000"));
        tv_19.setTextColor(Color.parseColor("#000000"));
        tv_20.setTextColor(Color.parseColor("#000000"));
        tv_21.setTextColor(Color.parseColor("#000000"));
        tv_22.setTextColor(Color.parseColor("#000000"));
        tv_23.setTextColor(Color.parseColor("#000000"));
        tv_24.setTextColor(Color.parseColor("#000000"));
        tv_25.setTextColor(Color.parseColor("#000000"));
        tv_26.setTextColor(Color.parseColor("#000000"));
        tv_27.setTextColor(Color.parseColor("#000000"));
        tv_28.setTextColor(Color.parseColor("#000000"));
        tv_29.setTextColor(Color.parseColor("#000000"));
        tv_30.setTextColor(Color.parseColor("#000000"));
        tv_31.setTextColor(Color.parseColor("#000000"));
        tv_32.setTextColor(Color.parseColor("#000000"));
        tv_33.setTextColor(Color.parseColor("#000000"));
        tv_34.setTextColor(Color.parseColor("#000000"));
        tv_35.setTextColor(Color.parseColor("#000000"));




        calenderday = calenderUpdate(year, month);


        tv_1.setText(String.valueOf(calenderday[0]));
        tv_2.setText(String.valueOf(calenderday[1]));
        tv_3.setText(String.valueOf(calenderday[2]));
        tv_4.setText(String.valueOf(calenderday[3]));
        tv_5.setText(String.valueOf(calenderday[4]));
        tv_6.setText(String.valueOf(calenderday[5]));
        tv_7.setText(String.valueOf(calenderday[6]));
        tv_8.setText(String.valueOf(calenderday[7]));
        tv_9.setText(String.valueOf(calenderday[8]));
        tv_10.setText(String.valueOf(calenderday[9]));
        tv_11.setText(String.valueOf(calenderday[10]));
        tv_12.setText(String.valueOf(calenderday[11]));
        tv_13.setText(String.valueOf(calenderday[12]));
        tv_14.setText(String.valueOf(calenderday[13]));
        tv_15.setText(String.valueOf(calenderday[14]));
        tv_16.setText(String.valueOf(calenderday[15]));
        tv_17.setText(String.valueOf(calenderday[16]));
        tv_18.setText(String.valueOf(calenderday[17]));
        tv_19.setText(String.valueOf(calenderday[18]));
        tv_20.setText(String.valueOf(calenderday[19]));
        tv_21.setText(String.valueOf(calenderday[20]));
        tv_22.setText(String.valueOf(calenderday[21]));
        tv_23.setText(String.valueOf(calenderday[22]));
        tv_24.setText(String.valueOf(calenderday[23]));
        tv_25.setText(String.valueOf(calenderday[24]));
        tv_26.setText(String.valueOf(calenderday[25]));
        tv_27.setText(String.valueOf(calenderday[26]));
        tv_28.setText(String.valueOf(calenderday[27]));
        tv_29.setText(String.valueOf(calenderday[28]));
        tv_30.setText(String.valueOf(calenderday[29]));
        tv_31.setText(String.valueOf(calenderday[30]));
        tv_32.setText(String.valueOf(calenderday[31]));
        tv_33.setText(String.valueOf(calenderday[32]));
        tv_34.setText(String.valueOf(calenderday[33]));
        tv_35.setText(String.valueOf(calenderday[34]));


        if(calenderday[0] > 10)
            tv_1.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[1] > 10)
            tv_2.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[2] > 10)
            tv_3.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[3] > 10)
            tv_4.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[4] > 10)
            tv_5.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[5] > 10)
            tv_6.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[6] > 10)
            tv_7.setTextColor(Color.parseColor("#33000000"));

        if(calenderday[34] < 10)
            tv_35.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[33] < 10)
            tv_34.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[32] < 10)
            tv_33.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[31] < 10)
            tv_32.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[30] < 10)
            tv_31.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[29] < 10)
            tv_30.setTextColor(Color.parseColor("#33000000"));
        if(calenderday[28] < 10)
            tv_29.setTextColor(Color.parseColor("#33000000"));





        btn_to_lastday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(month != 1)
                    month -=1;
                else if(month == 1){
                    year -=1;
                    month = 12;
                }
                tvYear.setText(year.toString());
                tvMonth.setText(month.toString());


                tv_1.setTextColor(Color.parseColor("#000000"));
                tv_2.setTextColor(Color.parseColor("#000000"));
                tv_3.setTextColor(Color.parseColor("#000000"));
                tv_4.setTextColor(Color.parseColor("#000000"));
                tv_5.setTextColor(Color.parseColor("#000000"));
                tv_6.setTextColor(Color.parseColor("#000000"));
                tv_7.setTextColor(Color.parseColor("#000000"));
                tv_8.setTextColor(Color.parseColor("#000000"));
                tv_9.setTextColor(Color.parseColor("#000000"));
                tv_10.setTextColor(Color.parseColor("#000000"));
                tv_11.setTextColor(Color.parseColor("#000000"));
                tv_12.setTextColor(Color.parseColor("#000000"));
                tv_13.setTextColor(Color.parseColor("#000000"));
                tv_14.setTextColor(Color.parseColor("#000000"));
                tv_15.setTextColor(Color.parseColor("#000000"));
                tv_16.setTextColor(Color.parseColor("#000000"));
                tv_17.setTextColor(Color.parseColor("#000000"));
                tv_18.setTextColor(Color.parseColor("#000000"));
                tv_19.setTextColor(Color.parseColor("#000000"));
                tv_20.setTextColor(Color.parseColor("#000000"));
                tv_21.setTextColor(Color.parseColor("#000000"));
                tv_22.setTextColor(Color.parseColor("#000000"));
                tv_23.setTextColor(Color.parseColor("#000000"));
                tv_24.setTextColor(Color.parseColor("#000000"));
                tv_25.setTextColor(Color.parseColor("#000000"));
                tv_26.setTextColor(Color.parseColor("#000000"));
                tv_27.setTextColor(Color.parseColor("#000000"));
                tv_28.setTextColor(Color.parseColor("#000000"));
                tv_29.setTextColor(Color.parseColor("#000000"));
                tv_30.setTextColor(Color.parseColor("#000000"));
                tv_31.setTextColor(Color.parseColor("#000000"));
                tv_32.setTextColor(Color.parseColor("#000000"));
                tv_33.setTextColor(Color.parseColor("#000000"));
                tv_34.setTextColor(Color.parseColor("#000000"));
                tv_35.setTextColor(Color.parseColor("#000000"));

                calenderday = calenderUpdate(year, month);


                tv_1.setText(String.valueOf(calenderday[0]));
                tv_2.setText(String.valueOf(calenderday[1]));
                tv_3.setText(String.valueOf(calenderday[2]));
                tv_4.setText(String.valueOf(calenderday[3]));
                tv_5.setText(String.valueOf(calenderday[4]));
                tv_6.setText(String.valueOf(calenderday[5]));
                tv_7.setText(String.valueOf(calenderday[6]));
                tv_8.setText(String.valueOf(calenderday[7]));
                tv_9.setText(String.valueOf(calenderday[8]));
                tv_10.setText(String.valueOf(calenderday[9]));
                tv_11.setText(String.valueOf(calenderday[10]));
                tv_12.setText(String.valueOf(calenderday[11]));
                tv_13.setText(String.valueOf(calenderday[12]));
                tv_14.setText(String.valueOf(calenderday[13]));
                tv_15.setText(String.valueOf(calenderday[14]));
                tv_16.setText(String.valueOf(calenderday[15]));
                tv_17.setText(String.valueOf(calenderday[16]));
                tv_18.setText(String.valueOf(calenderday[17]));
                tv_19.setText(String.valueOf(calenderday[18]));
                tv_20.setText(String.valueOf(calenderday[19]));
                tv_21.setText(String.valueOf(calenderday[20]));
                tv_22.setText(String.valueOf(calenderday[21]));
                tv_23.setText(String.valueOf(calenderday[22]));
                tv_24.setText(String.valueOf(calenderday[23]));
                tv_25.setText(String.valueOf(calenderday[24]));
                tv_26.setText(String.valueOf(calenderday[25]));
                tv_27.setText(String.valueOf(calenderday[26]));
                tv_28.setText(String.valueOf(calenderday[27]));
                tv_29.setText(String.valueOf(calenderday[28]));
                tv_30.setText(String.valueOf(calenderday[29]));
                tv_31.setText(String.valueOf(calenderday[30]));
                tv_32.setText(String.valueOf(calenderday[31]));
                tv_33.setText(String.valueOf(calenderday[32]));
                tv_34.setText(String.valueOf(calenderday[33]));
                tv_35.setText(String.valueOf(calenderday[34]));


                if(calenderday[0] > 10)
                    tv_1.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[1] > 10)
                    tv_2.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[2] > 10)
                    tv_3.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[3] > 10)
                    tv_4.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[4] > 10)
                    tv_5.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[5] > 10)
                    tv_6.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[6] > 10)
                    tv_7.setTextColor(Color.parseColor("#33000000"));

                if(calenderday[34] < 10)
                    tv_35.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[33] < 10)
                    tv_34.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[32] < 10)
                    tv_33.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[31] < 10)
                    tv_32.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[30] < 10)
                    tv_31.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[29] < 10)
                    tv_30.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[28] < 10)
                    tv_29.setTextColor(Color.parseColor("#33000000"));


            }
        });

        btn_to_nextday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(month == 12){
                    year +=1;
                    month = 1;
                }
                else if(month < 12)
                    month +=1;

                tvYear.setText(year.toString());
                tvMonth.setText(month.toString());


                tv_1.setTextColor(Color.parseColor("#000000"));
                tv_2.setTextColor(Color.parseColor("#000000"));
                tv_3.setTextColor(Color.parseColor("#000000"));
                tv_4.setTextColor(Color.parseColor("#000000"));
                tv_5.setTextColor(Color.parseColor("#000000"));
                tv_6.setTextColor(Color.parseColor("#000000"));
                tv_7.setTextColor(Color.parseColor("#000000"));
                tv_8.setTextColor(Color.parseColor("#000000"));
                tv_9.setTextColor(Color.parseColor("#000000"));
                tv_10.setTextColor(Color.parseColor("#000000"));
                tv_11.setTextColor(Color.parseColor("#000000"));
                tv_12.setTextColor(Color.parseColor("#000000"));
                tv_13.setTextColor(Color.parseColor("#000000"));
                tv_14.setTextColor(Color.parseColor("#000000"));
                tv_15.setTextColor(Color.parseColor("#000000"));
                tv_16.setTextColor(Color.parseColor("#000000"));
                tv_17.setTextColor(Color.parseColor("#000000"));
                tv_18.setTextColor(Color.parseColor("#000000"));
                tv_19.setTextColor(Color.parseColor("#000000"));
                tv_20.setTextColor(Color.parseColor("#000000"));
                tv_21.setTextColor(Color.parseColor("#000000"));
                tv_22.setTextColor(Color.parseColor("#000000"));
                tv_23.setTextColor(Color.parseColor("#000000"));
                tv_24.setTextColor(Color.parseColor("#000000"));
                tv_25.setTextColor(Color.parseColor("#000000"));
                tv_26.setTextColor(Color.parseColor("#000000"));
                tv_27.setTextColor(Color.parseColor("#000000"));
                tv_28.setTextColor(Color.parseColor("#000000"));
                tv_29.setTextColor(Color.parseColor("#000000"));
                tv_30.setTextColor(Color.parseColor("#000000"));
                tv_31.setTextColor(Color.parseColor("#000000"));
                tv_32.setTextColor(Color.parseColor("#000000"));
                tv_33.setTextColor(Color.parseColor("#000000"));
                tv_34.setTextColor(Color.parseColor("#000000"));
                tv_35.setTextColor(Color.parseColor("#000000"));






                calenderday = calenderUpdate(year, month);


                tv_1.setText(String.valueOf(calenderday[0]));
                tv_2.setText(String.valueOf(calenderday[1]));
                tv_3.setText(String.valueOf(calenderday[2]));
                tv_4.setText(String.valueOf(calenderday[3]));
                tv_5.setText(String.valueOf(calenderday[4]));
                tv_6.setText(String.valueOf(calenderday[5]));
                tv_7.setText(String.valueOf(calenderday[6]));
                tv_8.setText(String.valueOf(calenderday[7]));
                tv_9.setText(String.valueOf(calenderday[8]));
                tv_10.setText(String.valueOf(calenderday[9]));
                tv_11.setText(String.valueOf(calenderday[10]));
                tv_12.setText(String.valueOf(calenderday[11]));
                tv_13.setText(String.valueOf(calenderday[12]));
                tv_14.setText(String.valueOf(calenderday[13]));
                tv_15.setText(String.valueOf(calenderday[14]));
                tv_16.setText(String.valueOf(calenderday[15]));
                tv_17.setText(String.valueOf(calenderday[16]));
                tv_18.setText(String.valueOf(calenderday[17]));
                tv_19.setText(String.valueOf(calenderday[18]));
                tv_20.setText(String.valueOf(calenderday[19]));
                tv_21.setText(String.valueOf(calenderday[20]));
                tv_22.setText(String.valueOf(calenderday[21]));
                tv_23.setText(String.valueOf(calenderday[22]));
                tv_24.setText(String.valueOf(calenderday[23]));
                tv_25.setText(String.valueOf(calenderday[24]));
                tv_26.setText(String.valueOf(calenderday[25]));
                tv_27.setText(String.valueOf(calenderday[26]));
                tv_28.setText(String.valueOf(calenderday[27]));
                tv_29.setText(String.valueOf(calenderday[28]));
                tv_30.setText(String.valueOf(calenderday[29]));
                tv_31.setText(String.valueOf(calenderday[30]));
                tv_32.setText(String.valueOf(calenderday[31]));
                tv_33.setText(String.valueOf(calenderday[32]));
                tv_34.setText(String.valueOf(calenderday[33]));
                tv_35.setText(String.valueOf(calenderday[34]));


                if(calenderday[0] > 10)
                    tv_1.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[1] > 10)
                    tv_2.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[2] > 10)
                    tv_3.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[3] > 10)
                    tv_4.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[4] > 10)
                    tv_5.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[5] > 10)
                    tv_6.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[6] > 10)
                    tv_7.setTextColor(Color.parseColor("#33000000"));

                if(calenderday[34] < 10)
                    tv_35.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[33] < 10)
                    tv_34.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[32] < 10)
                    tv_33.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[31] < 10)
                    tv_32.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[30] < 10)
                    tv_31.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[29] < 10)
                    tv_30.setTextColor(Color.parseColor("#33000000"));
                if(calenderday[28] < 10)
                    tv_29.setTextColor(Color.parseColor("#33000000"));
            }
        });

        ((MainActivity)getActivity()).dbRef(arrayList1, "1월");
        ((MainActivity)getActivity()).dbRef(arrayList2, "2월");
        ((MainActivity)getActivity()).dbRef(arrayList3, "3월");
        ((MainActivity)getActivity()).dbRef(arrayList4, "4월");
        ((MainActivity)getActivity()).dbRef(arrayList5, "5월");
        ((MainActivity)getActivity()).dbRef(arrayList6, "6월");
        ((MainActivity)getActivity()).dbRef(arrayList7, "7월");
        ((MainActivity)getActivity()).dbRef(arrayList8, "8월");

        Log.d("hello", arrayList1.toString());








        return rootView;

    }

    public static int monthDay(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                return 29;
            } else {
                return 28;
            }
        }

    }
    public static int[] calenderUpdate(int year, int month){
        int last_max_day = 0;
        int sum = 0 ;
        for(int i = 1583; i < year ; i++){
            if((i % 4 == 0 && i % 100 != 0) || i %400 == 0){
                sum += 2;
            }else{
                sum += 1;
            }
        }
        int first = (sum + 6) % 7;


        for(int j = 1; j < month; j ++){
            first += monthDay(year, j) % 7;
        }
        int first_weekday = first % 7;
        int max_day = monthDay(year, month);

        // 전달 마지막 날
        if(month != 1){
            last_max_day = monthDay(year, month-1);
        }
        if(month == 1)
            last_max_day = monthDay(year-1, 12);
        Log.d("hello" , "달 첫째 날 요일" +String.valueOf(first_weekday) +"달 마지막 날 날짜"+ String.valueOf(max_day) + "전달의 마지막 날짜" + String.valueOf(last_max_day));
        int[] calenderday = new int[35];
        int a= 1;
        int b =1;
        for (int i = 0; i < 35;i ++ ){
            if( i < first_weekday){
                calenderday[i] = last_max_day - first_weekday +1;

                last_max_day += 1;

            }
            if(i >= max_day + first_weekday){
                calenderday[i] = a;
                a+= 1;
            }
            if( (first_weekday<= i) & (i < max_day + first_weekday)){
                calenderday[i] = b;
                b+=1;
            }

        }
        return calenderday;

    }



}
