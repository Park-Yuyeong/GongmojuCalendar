package com.example.mobileprogramming_team6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //프래그먼트 선언//

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentNews fragmentNews = new FragmentNews();
    private FragmentCalender fragmentCalender = new FragmentCalender();
    private FragmentCart fragmentCart = new FragmentCart();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentNews).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch(item.getItemId()){
                case R.id.newsItem:
                    transaction.replace(R.id.frameLayout, fragmentNews).commitAllowingStateLoss();
                    break;
                case R.id.calenderItem:
                    transaction.replace(R.id.frameLayout, fragmentCalender).commitAllowingStateLoss();
                    break;
                case R.id.cartItem:
                    transaction.replace(R.id.frameLayout, fragmentCart).commitAllowingStateLoss();
                    break;

            }
            return true;
        }
    }

}