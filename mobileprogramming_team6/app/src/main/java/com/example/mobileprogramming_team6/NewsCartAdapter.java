package com.example.mobileprogramming_team6;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsCartAdapter extends RecyclerView.Adapter<NewsCartAdapter.NewsCartViewHolder> {


    private ArrayList<Cart> arrayList;
    private Context context;

    String plusoneday(String date){
        String day = date.substring(7,8);
        int day2 = Integer.parseInt(day);
        day2 += 1;
        return String.valueOf(day2);
    }

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
        holder.tvSubscriptDate.setText(arrayList.get(position).getSubscriptDate());
        holder.tvListingDate.setText(arrayList.get(position).getListingDate());

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
