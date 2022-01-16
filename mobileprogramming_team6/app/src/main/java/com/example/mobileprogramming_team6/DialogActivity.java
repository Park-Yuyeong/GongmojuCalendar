package com.example.mobileprogramming_team6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DialogActivity extends AppCompatActivity {
    //상세정보 페이지 액티비티 입니다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);

        TextView tvChungYakDay = findViewById(R.id.tvChungyak_Day);
        TextView tvRefundDay = findViewById(R.id.tvRefund_Day);
        TextView tvSangJangDay = findViewById(R.id.tvSangJang_Day);
        TextView tvHopePrice = findViewById(R.id.tvHope_Price);
        TextView tvSetPrice = findViewById(R.id.tvSet_Price);
        TextView tvSmallestPrice = findViewById(R.id.tvSmallest_Price);

        tvChungYakDay.setText("청약 기간 string");
        tvRefundDay.setText("환불 기간 string");
        tvSangJangDay.setText("상장 기간 string");
        tvHopePrice.setText("희망공모가 string");
        tvSetPrice.setText("확정공모가 String");
        tvSmallestPrice.setText("최소청약증거금 string");







    }
}