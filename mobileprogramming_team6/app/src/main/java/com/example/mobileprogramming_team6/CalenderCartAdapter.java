package com.example.mobileprogramming_team6;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CalenderCartAdapter extends RecyclerView.Adapter<CalenderCartAdapter.CalenderCartViewHolder> {


    private ArrayList<Cart> arrayList;
    private Context context;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;



    public CalenderCartAdapter(ArrayList<Cart> arrayList , Context context){

        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CalenderCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calender_bottom_item_layout, parent, false);
        CalenderCartViewHolder holder = new CalenderCartViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CalenderCartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String month = arrayList.get(position).getMonth();
        String listingDay = arrayList.get(position).getListingDate();
        String subscriptDay = arrayList.get(position).getSubscriptDate();


        holder.tvName.setText(arrayList.get(position).getName());

        if(listingDay != null){
            if(listingDay.length() != 1) {
                holder.tvDate.setText("상장일 2021-" + month + "-" + listingDay);
                holder.tvDate.setTextColor(Color.rgb(225, 102, 102));
            }
            else{
                holder.tvDate.setText("상장일 2021-" + month + "-0" + listingDay);
                holder.tvDate.setTextColor(Color.rgb(225, 102, 102));
            }
        }
        else if(subscriptDay != null){
            if(subscriptDay.length() != 1){
                holder.tvDate.setText("청약일 2021-" + month + "-" + subscriptDay);
                holder.tvDate.setTextColor(Color.rgb(102,153,255));
            }
            else{
                holder.tvDate.setText("청약일 2021-" + month + "-0" + subscriptDay);
                holder.tvDate.setTextColor(Color.rgb(102,153,255));
            }
        }
        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference();
        holder.btnCart.setOnClickListener(new View.OnClickListener() {
            String idByANDROID_ID =
                    Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            @Override
            public void onClick(View view) {
                if(listingDay != null) {
                    if (listingDay.length() != 1) {
                        databaseReference.child("Users").child(idByANDROID_ID).child(arrayList.get(position).getName()).child("listingDate").setValue("2021-" + month + "-" + listingDay);
                        Toast.makeText(context.getApplicationContext(), "관심종목에 등록되었습니다.", Toast.LENGTH_LONG).show();
                    } else {
                        databaseReference.child("Users").child(idByANDROID_ID).child(arrayList.get(position).getName()).child("listingDate").setValue("2021-" + month + "-0" + listingDay);
                        Toast.makeText(context.getApplicationContext(), "관심종목에 등록되었습니다.", Toast.LENGTH_LONG).show();
                    }
                }
                else if(subscriptDay != null) {
                    if (subscriptDay.length() != 1) {
                        databaseReference.child("Users").child(idByANDROID_ID).child(arrayList.get(position).getName()).child("subscriptDate").setValue("2021-" + month + "-" + subscriptDay);
                        Toast.makeText(context.getApplicationContext(), "관심종목에 등록되었습니다.", Toast.LENGTH_LONG).show();
                    } else {
                        databaseReference.child("Users").child(idByANDROID_ID).child(arrayList.get(position).getName()).child("subscriptDate").setValue("2021-" + month + "-0" + subscriptDay);
                        Toast.makeText(context.getApplicationContext(), "관심종목에 등록되었습니다.", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), ShowActivity.class);
//                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(arrayList.get(position).getInfor()));
//                view.getContext().startActivity(intent);
                    context.startActivity(new Intent(context, DialogActivity.class));

            }
        });



    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CalenderCartViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDate;
        ImageView image;
        Button btnCart;

        public CalenderCartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvDate = itemView.findViewById(R.id.tv_date);
            this.image = itemView.findViewById(R.id.image);
            this.btnCart = itemView.findViewById(R.id.btn_cart);



        }
    }
}
