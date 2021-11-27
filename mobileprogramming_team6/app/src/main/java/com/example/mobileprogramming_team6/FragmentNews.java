package com.example.mobileprogramming_team6;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentNews extends Fragment {



    private ArrayList<Cart> cartArrayList;

    //Recycleview 사용//
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    private ArrayList<Cart> cartArrayList2;
    private RecyclerView recyclerView2;
    private RecyclerView.Adapter adapter2;
    private FirebaseDatabase database2;
    private DatabaseReference databaseReference2;




    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_news, container, false) ;


        recyclerView = rootView.findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true); //리사이클뷰 기존성능 강화
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        cartArrayList = new ArrayList<>(); // Cart 객체를 담을 어레이 리스트(어뎁터 쪽으로_)

        database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동
        databaseReference = database.getReference("Users"); //DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                cartArrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){ // 반복문으로 데이터 List를 추출해냄
                    Cart cart = snapshot.getValue(Cart.class); // 만들어뒀던 Cart 객체에 데이터를 담는다.


                    ////////////////이곳은 오늘 날짜와 같은 데이터만 뽑아야함/////////////////
                    cartArrayList.add(cart);
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("MainActivity",String.valueOf(error.toException())); // 에러문 출력
            }
        });
        adapter = new NewsCartAdapter(cartArrayList, getActivity());
        recyclerView.setAdapter(adapter);







        recyclerView2 = rootView.findViewById(R.id.recyclerView_other);
        recyclerView2.setHasFixedSize(true); //리사이클뷰 기존성능 강화
        RecyclerView.LayoutManager layoutManager2= new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(layoutManager2);
        cartArrayList2 = new ArrayList<>(); // Cart 객체를 담을 어레이 리스트(어뎁터 쪽으로_)

        database2 = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동
        databaseReference2 = database.getReference("2021년 청약일정"); //DB 테이블 연결
        databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                cartArrayList2.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){ // 반복문으로 데이터 List를 추출해냄
                    Cart cart = snapshot.getValue(Cart.class); // 만들어뒀던 Cart 객체에 데이터를 담는다.

                    ////////////////이곳은 오늘 날짜와 같은 데이터만 뽑아야함/////////////////
                    cartArrayList2.add(cart);
                }
                adapter2.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("MainActivity",String.valueOf(error.toException())); // 에러문 출력
            }
        });
        adapter2 = new NewsCartAdapter(cartArrayList2, getActivity());
        recyclerView2.setAdapter(adapter2);




        return rootView;
    }
}