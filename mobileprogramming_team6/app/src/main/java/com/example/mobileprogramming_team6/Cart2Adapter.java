package com.example.mobileprogramming_team6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart2Adapter extends RecyclerView.Adapter<Cart2Adapter.Cart2ViewHolder> {
    @NonNull

    private ArrayList<Cart> arrayList;
    private Context context;



    public Cart2Adapter(ArrayList<Cart> arrayList, Context context){
        this.arrayList = arrayList;
        this.context  = context;
    }
    public Cart2Adapter.Cart2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_2, parent, false);
        Cart2ViewHolder holder = new Cart2ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Cart2Adapter.Cart2ViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvSubscriptDate.setText(arrayList.get(position).getSubscriptDate());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class Cart2ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvSubscriptDate;
        public Cart2ViewHolder(@NonNull View itemView){
            super(itemView);

            this.tvName= itemView.findViewById(R.id.tvName);
            this.tvSubscriptDate= itemView.findViewById(R.id.tvSubscriptDate);
        }
    }
}
