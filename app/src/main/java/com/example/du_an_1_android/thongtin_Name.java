package com.example.du_an_1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class thongtin_Name extends AppCompatActivity {
    Button tieptuc_name;
    ImageView trove_name;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;
    TextInputEditText edtTenCuaBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_name);
        firebaseAuth=FirebaseAuth.getInstance();
        //         tiếp tục
        tieptuc_name = findViewById(R.id.btnTT_ten);
        tieptuc_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                String id = firebaseAuth.getUid();
                edtTenCuaBan = findViewById(R.id.edtName);
                String TenCuaBan = edtTenCuaBan.getText().toString().trim();
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setTenCuaBan(TenCuaBan);
                node.child(id).updateChildren(thongTinDangNhap.toMapTenCuaBan());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapTenCuaBan());
                Intent intent = new Intent(thongtin_Name.this, com.example.du_an_1_android.thongtin_ngaysinh.class);
                intent.putExtra("gt",gioiTinh);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

//        Trờ về
        trove_name = findViewById(R.id.back_ten);
        trove_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongtin_Name.this, thongtin_sdt.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}