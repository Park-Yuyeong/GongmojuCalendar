package com.example.mobileprogramming_team6;

import android.graphics.Color;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Eventdecorator implements DayViewDecorator {


    private final int color;
    private final ArrayList<CalendarDay> dates;

    public Eventdecorator(int color, Collection<CalendarDay> dates){
        this.color = color; //색
        this.dates = new ArrayList<>(dates); //날짜들
    }
    public int getColor(){return color;}

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(10, color));
    }
}
