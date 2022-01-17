package com.example.du_an_1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class thongtin_gioitinh extends AppCompatActivity {
    Button tieptuc_gioitinh;
    ImageView trove_gioitinh;
    String gioiTinh = null;
    Button btnNamWhite,btnNuWhite,btnKhacWhite,btnNamPink,btnNuPink,btnKhacPink;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("TaiKhoan");
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_gioitinh);
        firebaseAuth=FirebaseAuth.getInstance();
//        ánh xạ
        btnNamWhite = findViewById(R.id.btnNamWhite);
        btnNuWhite = findViewById(R.id.btnNuWhite);
        btnKhacWhite = findViewById(R.id.btnKhacWhite);
        btnNamPink = findViewById(R.id.btnNamPink);
        btnNuPink = findViewById(R.id.btnNuPink);
        btnKhacPink = findViewById(R.id.btnKhacPink);

//        Trờ về
        trove_gioitinh = findViewById(R.id.back_gioitinh);
        trove_gioitinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongtin_gioitinh.this, com.example.du_an_1_android.thongtin_ngaysinh.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        btnNamWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Nam";
            }
        });
        btnNuWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Nữ";
            }
        });
        btnKhacWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Khác";
            }
        });

        btnNamWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Nam";
                btnKhacPink.setVisibility(View.INVISIBLE);
                btnNuPink.setVisibility(View.INVISIBLE);
                btnNamWhite.setVisibility(View.INVISIBLE);
                btnNuWhite.setVisibility(View.VISIBLE);
                btnKhacWhite.setVisibility(View.VISIBLE);
                btnNamPink.setVisibility(View.VISIBLE);
            }
        });
        btnNuWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Nữ";
                btnNamPink.setVisibility(View.INVISIBLE);
                btnKhacPink.setVisibility(View.INVISIBLE);
                btnNuWhite.setVisibility(View.INVISIBLE);
                btnNamWhite.setVisibility(View.VISIBLE);
                btnKhacWhite.setVisibility(View.VISIBLE);
                btnNuPink.setVisibility(View.VISIBLE);
            }
        });
        btnKhacWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Khác";
                btnNamPink.setVisibility(View.INVISIBLE);
                btnNuPink.setVisibility(View.INVISIBLE);
                btnKhacWhite.setVisibility(View.INVISIBLE);
                btnNamWhite.setVisibility(View.VISIBLE);
                btnNuWhite.setVisibility(View.VISIBLE);
                btnKhacPink.setVisibility(View.VISIBLE);
            }
        });



        //                 tiếp tục
        tieptuc_gioitinh = findViewById(R.id.btnTT_gioitinh);
        tieptuc_gioitinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String id = firebaseAuth.getUid();
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setGioiTinh(gioiTinh);

                node.child(gioiTinh).child(id).updateChildren(thongTinDangNhap.toMapGioiTinh());
                Intent intent = new Intent(thongtin_gioitinh.this, thongtin_sothich.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }
}