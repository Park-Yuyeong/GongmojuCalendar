package com.example.mobileprogramming_team6;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessControlContext;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NewsCartAdapter extends RecyclerView.Adapter<NewsCartAdapter.NewsCartViewHolder> {


    private ArrayList<Cart> arrayList;
    private Context context;
    LocalDateTime now = LocalDateTime.now();
    String today_day = String.valueOf(now.getDayOfMonth());
    String today_dayminus1 = String.valueOf(now.getDayOfMonth()-1);





    public NewsCartAdapter(ArrayList<Cart> arrayList , Context context){

        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_layout, parent, false);
        NewsCartViewHolder holder = new NewsCartViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCartViewHolder holder, int position) {

        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvListingDate.setText(arrayList.get(position).getSubscriptDate());
        holder.tvSubscriptDate.setText(arrayList.get(position).getListingDate());
        if(arrayList.get(position).getListingDate() != null) {
            if (arrayList.get(position).getListingDate().length() < 3) {

                if (holder.tvListingDate.getText().equals(today_day)) {
                    holder.tvSubscriptDate.setText("                   청약");
                    holder.tvSubscriptDate.setTextColor(Color.rgb(102, 153, 255));
                    holder.tvSubscriptDate.setTextSize(14);
                    holder.tvListingDate.setText("");

                }
                if (holder.tvSubscriptDate.getText().equals(today_day)) {
                    holder.tvSubscriptDate.setText("                   상장");
                    holder.tvSubscriptDate.setTextColor(Color.rgb(225, 102, 102));
                    holder.tvSubscriptDate.setTextSize(14);
                    holder.tvListingDate.setText("");

                }
            }
        }


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class NewsCartViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvSubscriptDate;
        TextView tvListingDate;

        public NewsCartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvSubscriptDate = itemView.findViewById(R.id.tvListingDate);
            this.tvListingDate = itemView.findViewById(R.id.tvSubscriptDate);


        }
    }
}
