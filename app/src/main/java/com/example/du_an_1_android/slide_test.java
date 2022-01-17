package com.example.du_an_1_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class slide_test extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ImgAdapter slideAdapterTest;
    Button btnve,btntien;
    private int mCurrentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_test);
//        anh xa
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);
        btnve = findViewById(R.id.btnve);
        btntien = findViewById(R.id.btntien);

        slideAdapterTest = new ImgAdapter(this,getListPhoto());
        viewPager.setAdapter(slideAdapterTest);
        circleIndicator.setViewPager(viewPager);
        slideAdapterTest.registerDataSetObserver(circleIndicator.getDataSetObserver());

        btntien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cho thêm điều kiện mCurrentPage < độ dài ảnh và lớn hơn 0
                    viewPager.setCurrentItem(mCurrentPage + 1);
                    mCurrentPage++;

            }
        });
        btnve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cho thêm điều kiện mCurrentPage < độ dài ảnh và lớn hơn 0
                viewPager.setCurrentItem(mCurrentPage - 1);
                mCurrentPage--;
            }
        });
    }

    private List<Image> getListPhoto(){
        List<Image> list = new ArrayList<>();
        list.add(new Image(R.drawable.trung));
        list.add(new Image(R.drawable.bao));
        list.add(new Image(R.drawable.toan));
        return list;
    }
}