package com.example.mobileprogramming_team6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Cart> arrayList;
    private Context context;

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


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvSubscriptDate = itemView.findViewById(R.id.tvSubscriptDate);
            this.tvListingDate = itemView.findViewById(R.id.tvListingDate);
        }
    }
}
