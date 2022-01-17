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

public class thongtin_mota extends AppCompatActivity {
    Button tieptuc_mota;
    ImageView trove_mota;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;
    TextInputEditText editTextTextMultiLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //full main
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_mota);
        //                 tiếp tục
        firebaseAuth=FirebaseAuth.getInstance();
        tieptuc_mota = findViewById(R.id.btnTT_mota);
        tieptuc_mota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                String id = firebaseAuth.getUid();
                editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
                String Mota = editTextTextMultiLine.getText().toString().trim();
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setMoTa(Mota);

                node.child(id).updateChildren(thongTinDangNhap.toMapMoTa());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapMoTa());
                Intent intent = new Intent(thongtin_mota.this, thongtin_addArt.class);
                intent.putExtra("gt",gioiTinh);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

//        Trờ về
        trove_mota = findViewById(R.id.back_mota);
        trove_mota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongtin_mota.this, thongtin_sothich.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}