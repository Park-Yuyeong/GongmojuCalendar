package com.example.mobileprogramming_team6;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessControlContext;
import java.util.ArrayList;

public class NewsCartAdapter extends RecyclerView.Adapter<NewsCartAdapter.NewsCartViewHolder> {


    private ArrayList<Cart> arrayList;
    private Context context;





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
        holder.tvListingDate.setText(arrayList.get(position).getListingDate());
        holder.tvSubscriptDate.setText(arrayList.get(position).getSubscriptDate());

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
