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

public class thongtin_sdt extends AppCompatActivity {
    Button tieptuc_sdt;
    ImageView trove_sdt;
    TextInputEditText edtSDT;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_sdt);

        AnhXa();
        firebaseAuth=FirebaseAuth.getInstance();

        //         tiếp tục
        tieptuc_sdt = findViewById(R.id.btnTT_sdt);
        tieptuc_sdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sdt = edtSDT.getText().toString().trim();
                String id = firebaseAuth.getUid();
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setSDT(sdt);
                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                node.child(id).updateChildren(thongTinDangNhap.toMapSDT());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapSDT());
                Intent intent = new Intent(thongtin_sdt.this, com.example.du_an_1_android.thongtin_Name.class);
                intent.putExtra("gt",gioiTinh);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

//        Trờ về
//        trove_sdt = findViewById(R.id.back_sdt);
//        trove_sdt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(thongtin_sdt.this, com.example.du_an_1_android.thongtin_email.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//
//            }
//        });
    }

    private void AnhXa(){
        edtSDT = findViewById(R.id.edtSdt);
    }
}