package com.example.mobileprogramming_team6;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CalenderCartAdapter extends RecyclerView.Adapter<CalenderCartAdapter.CalenderCartViewHolder> {


    private ArrayList<Cart> arrayList;
    private Context context;


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
    public void onBindViewHolder(@NonNull CalenderCartViewHolder holder, int position) {

        holder.tvName.setText(arrayList.get(position).getName());
        if(arrayList.get(position).getListingDate() != null){
            holder.tvDate.setText("상장일 2021-" +arrayList.get(position).getMonth()+"-" +arrayList.get(position).getListingDate());
        }
        else if(arrayList.get(position).getSubscriptDate() != null){
            holder.tvDate.setText("청약일 2021-" +arrayList.get(position).getMonth()+"-" +arrayList.get(position).getSubscriptDate());
        }

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CalenderCartViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDate;

        public CalenderCartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvDate = itemView.findViewById(R.id.tv_date);

            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(context, ShowActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        context.startActivity(intent);
                    }
                }
            });


        }
    }
}
