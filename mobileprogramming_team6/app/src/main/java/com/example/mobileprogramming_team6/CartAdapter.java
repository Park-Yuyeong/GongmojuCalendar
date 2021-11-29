package com.example.mobileprogramming_team6;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.shapes.Shape;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Cart> arrayList;
    private Context context;

    // 알림 기능 구현 시 필요한 변수들
    //private AlarmManager alarmManager;
    private AlarmManager am_list;
    private AlarmManager am_subs;
    private GregorianCalendar mCalendar;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    String date = "2021-10-31"; // 임의의 날짜 설정
    String listDate; // 상장일 string
    String subsDate; // 청약일 string

    // 알림 상태 저장 prefences
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public CartAdapter(ArrayList<Cart> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        CartViewHolder holder = new CartViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvListingDate.setText(arrayList.get(position).getListingDate());
        holder.tvSubscriptDate.setText(arrayList.get(position).getSubscriptDate());

        // 알림 상태 저장을 위한 코드
        pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        editor = pref.edit();

        boolean temp = pref.getBoolean(holder.tvName.getText().toString(), false);
        if (temp == true){
            holder.btnNoti.setSelected(true);
        }
        else {
            holder.btnNoti.setSelected(false);
        }



        holder.linearlayout.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.shape_yellow));




        // 알림 버튼 on&off
        holder.btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listDate = holder.tvListingDate.getText().toString();
                subsDate = holder.tvSubscriptDate.getText().toString();
                //listDate = makeDateString(2021, 10, Integer.parseInt(holder.tvListingDate.getText().toString()));
                //subsDate = makeDateString(2021, 11, Integer.parseInt(holder.tvSubscriptDate.getText().toString()));
                if (listDate == "") { // 상장일이 0값일 때
                    listDate = date;
                }
                if (subsDate == ""){ // 청약일이 0값일 떄
                    subsDate = date;
                }
                else{
                    String first = subsDate.substring(0, 8);
                    int second = Integer.parseInt(subsDate.substring(8,10)) - 1;

                    if (second == 0){
                        if (Integer.parseInt(subsDate.substring(5,7)) == 11){
                            subsDate = date;
                        }
                        else{
                            subsDate = "2021-11-30";
                        }
                    }
                    else if (second < 10){
                        subsDate = first + "0" + Integer.toString(second);
                    }
                    else{
                        subsDate = first + Integer.toString(second);
                    }
                }

                if (holder.btnNoti.isSelected()){
                    if (am_list == null || am_subs == null){
                        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                        am_list = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                        am_subs = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                        mCalendar = new GregorianCalendar();

                        if (am_subs != null){
                            setAlarm_list();
                        }
                        else if (am_list != null){
                            setAlarm_subs();
                        }else{
                            setAlarm_list();
                            setAlarm_subs();
                        }
                    }
                    holder.btnNoti.setSelected(false);

                    editor.putBoolean(holder.tvName.getText().toString(), false);
                    editor.commit();

                    if (am_subs != null){
                        cancelAlarm_list();
                    }
                    else if (am_list != null){
                        cancelAlarm_subs();
                    }else{
                        cancelAlarm_list();
                        cancelAlarm_subs();
                    }
                    Toast.makeText(context.getApplicationContext(), "공모주 알림 취소", Toast.LENGTH_LONG).show();
                }
                else{
                    holder.btnNoti.setSelected(true);

                    editor.putBoolean(holder.tvName.getText().toString(), true);
                    editor.commit();

                    notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                    am_list = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    am_subs = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

                    mCalendar = new GregorianCalendar();

                    setAlarm_list();
                    setAlarm_subs();

                    Toast.makeText(context.getApplicationContext(), "공모주 알림 ON!!", Toast.LENGTH_LONG).show();


                    try {
                        if(!nowCompare(listDate)){
                            cancelAlarm_list();
                            setAlarm_list();
                            return;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    try {
                        if (!nowCompare(subsDate)){
                            cancelAlarm_subs();
                            setAlarm_subs();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 관심종목에서 삭제
        holder.btnDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (am_list != null && holder.btnNoti.isSelected()){
                    cancelAlarm_list();
                }
                if (am_subs != null && holder.btnNoti.isSelected()){
                    cancelAlarm_subs();
                }

                editor.putBoolean(holder.tvName.getText().toString(), false);
                editor.commit();

                Toast.makeText(context.getApplicationContext(), "관심종목 삭제", Toast.LENGTH_LONG).show();

                String idByANDROID_ID =
                        Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                FirebaseDatabase.getInstance().getReference("Users/" + idByANDROID_ID).child(holder.tvName.getText().toString()).removeValue();

                arrayList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), arrayList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        //삼항연사자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvName; // 기업명
        TextView tvSubscriptDate; // 상장일
        TextView tvListingDate; // 청약일
        LinearLayout linearlayout;

        Button btnNoti; // 알림 버튼
        Button btnDel; // 관심종목 삭제 버튼

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvSubscriptDate = itemView.findViewById(R.id.tvSubscriptDate);
            this.tvListingDate = itemView.findViewById(R.id.tvListingDate);
            this.linearlayout = itemView.findViewById(R.id.linearlayout);


            this.btnNoti = itemView.findViewById(R.id.btnNoti);
            this.btnDel = itemView.findViewById(R.id.btnDel);
        }
    }

    private String makeDateString(int year, int month, int day){
        month += 1;
        date = year + "-" + month + "-"+ day;
        return date;
    }

    private boolean nowCompare(String date) throws ParseException {
        long now = System.currentTimeMillis();
        Date nowDate = new Date(now);
        Date comparedate = null;

        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

        String nowFormat = dataFormat.format(nowDate);

        Log.d("currentTime", "현재 시각: " + nowFormat);

        try {
            comparedate = dataFormat.parse(date);
            nowDate = dataFormat.parse(nowFormat);
        } catch (ParseException e){
            e.printStackTrace();;
        }

        int compare = nowDate.compareTo(comparedate);

        if (compare >= 0){
            return false;
        }
        else{
            return true;
        }
    }

    // 청약일 알림 on
    private void setAlarm_list(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);

        Log.d("setAlarm", "setAlarm() start!!");

        //String form = date + " 16:10:00"; // test
        String form = listDate + " 22:00:00"; // 실제 구현시 알람이 울리는 시각

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

        am_list.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    // 상장일 알림 on
    private void setAlarm_subs(){
        // AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);

        Log.d("setAlarm", "setAlarm() start!!");

        //String form = date + " 16:10:00"; // test
        String form = subsDate + " 22:00:00"; // 실제 구현시 알람이 울리는 시각

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

        am_subs.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    // 청약일 알람 off
    private void cancelAlarm_list(){
        Intent cancelIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, cancelIntent, 0);

        Log.d("cancelAlarm", "cancelAlarm() start!!");

        Log.d("setAlarm", "알림 해제!!");

        am_list.cancel(pendingIntent);
    }

    // 상장일 알람 off
    private void cancelAlarm_subs(){
        Intent cancelIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, cancelIntent, 0);

        Log.d("cancelAlarm", "cancelAlarm() start!!");

        Log.d("setAlarm", "알림 해제!!");

        am_subs.cancel(pendingIntent);
    }
}
