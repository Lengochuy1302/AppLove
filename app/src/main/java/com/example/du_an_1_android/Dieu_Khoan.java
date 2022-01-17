package com.example.du_an_1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.jetbrains.annotations.NotNull;

public class Dieu_Khoan extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    DatabaseReference nodeList;
    FirebaseAuth firebaseAuth;
    Button confim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dieu_khoan);
        firebaseAuth=FirebaseAuth.getInstance();
        confim = findViewById(R.id.btnCFLogin);
        confim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = firebaseAuth.getUid();
                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setTrangThai("1");
                thongTinDangNhap.setNgayYeu("None");
                thongTinDangNhap.setVitri("None");
                thongTinDangNhap.setLoaiTaiKhoan("NguoiDung");
                thongTinDangNhap.setDieuKhoan("Co");
                thongTinDangNhap.setTinhYeu("None");
                node.child(id).updateChildren(thongTinDangNhap.toMapTrangThai());
                node.child(id).updateChildren(thongTinDangNhap.toMapNgayYeu());
                node.child(id).updateChildren(thongTinDangNhap.toMapVitri());
                node.child(id).updateChildren(thongTinDangNhap.toMapLoaiTaiKhoan());
                node.child(id).updateChildren(thongTinDangNhap.toMapDieuKhoan());
                node.child(id).updateChildren(thongTinDangNhap.toMapTinhYeu());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapTrangThai());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapNgayYeu());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapVitri());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapLoaiTaiKhoan());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapDieuKhoan());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapTinhYeu());
                Intent intent = new Intent(Dieu_Khoan.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}