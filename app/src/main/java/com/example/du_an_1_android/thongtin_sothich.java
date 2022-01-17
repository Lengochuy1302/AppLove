package com.example.du_an_1_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class thongtin_sothich extends AppCompatActivity {
    Button tieptuc_sothich;
    Button btnTheThao,btnVeDem,btnAmNhac,btnDulich,btnCafe,btnDocsach,btnCauca,btnDientu,btnAmThuc,btnNauan,btnXemay;
    Button btnTheThao2,btnVeDem2,btnAmNhac2,btnDulich2,btnCafe2,btnDocsach2,btnCauca2,btnDientu2,btnAmThuc2,btnNauan2,btnXemay2;
    ImageView trove_sothich;
    String sothich1,sothich2,sothich3,sothich4,sothich5,sothich6,sothich7,sothich8,sothich9,sothich10,sothich11;
    TextView txtErroSoThich;
    int dem = 0;
    String soThichChon1 = null,soThichChon2= null,soThichChon3= null;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_sothich);
        firebaseAuth=FirebaseAuth.getInstance();
        Anhxa();
        //                 tiếp tục


//        Trờ về
        trove_sothich = findViewById(R.id.back_sothich);
        trove_sothich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongtin_sothich.this, com.example.du_an_1_android.thongtin_gioitinh.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        btnTheThao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich1 = "Thể thao";
                btnTheThao.setVisibility(View.INVISIBLE);
                btnTheThao2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");

                if(soThichChon1 == null){
                    soThichChon1 ="Thể thao";
                } else if(soThichChon2 == null ){
                    soThichChon2 ="Thể thao";
                } else if(soThichChon3 == null){
                    soThichChon3 ="Thể thao";
                }




            }
        });
        btnTheThao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich1 = "";
                btnTheThao2.setVisibility(View.INVISIBLE);
                btnTheThao.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");

                if( soThichChon1 == "Thể thao"){
                    soThichChon1 =null;
                } else if(soThichChon2 == "Thể thao" ){
                    soThichChon2 =null;
                } else if(soThichChon3 == "Thể thao"){
                    soThichChon3 =null;
                }

            }
        });
        btnVeDem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich2 = "Sống về đêm";
                btnVeDem.setVisibility(View.INVISIBLE);
                btnVeDem2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich2;
                } else if( soThichChon2 == null  ){
                    soThichChon2 =sothich2;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich2;
                }
            }
        });
        btnVeDem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich2 = "";
                btnVeDem2.setVisibility(View.INVISIBLE);
                btnVeDem.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");

                if( soThichChon1 == "Sống về đêm"){
                    soThichChon1 =null;
                } else if(soThichChon2 == "Sống về đêm" ){
                    soThichChon2 =null;
                } else if(soThichChon3 == "Sống về đêm"){
                    soThichChon3 =null;
                }
            }
        });
        btnAmNhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich3 = "Âm nhạc";
                btnAmNhac.setVisibility(View.INVISIBLE);
                btnAmNhac2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich3;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich3;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich3;
                }
            }
        });
        btnAmNhac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich3 = "";
                 String sothich31 = "Âm nhạc";
                btnAmNhac2.setVisibility(View.INVISIBLE);
                btnAmNhac.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnDulich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich4 = "Du lịch";
                btnDulich.setVisibility(View.INVISIBLE);
                btnDulich2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich4;
                } else if( soThichChon2 == null ){
                    soThichChon2 =sothich4;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich4;
                }
            }
        });
        btnDulich2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich4 = "";

                btnDulich2.setVisibility(View.INVISIBLE);
                btnDulich.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Du lịch";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich5 = "Cafe";
                btnCafe.setVisibility(View.INVISIBLE);
                btnCafe2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich5;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich5;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich5;
                }
            }
        });
        btnCafe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich5 = "";
                btnCafe2.setVisibility(View.INVISIBLE);
                btnCafe.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Cafe";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnDocsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich6 = "Đọc sách";
                btnDocsach.setVisibility(View.INVISIBLE);
                btnDocsach2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich6;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich6;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich6;
                }
            }
        });
        btnDocsach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich6 = "";
                btnDocsach2.setVisibility(View.INVISIBLE);
                btnDocsach.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Đọc sách";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnCauca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich7 = "Câu cá";
                btnCauca.setVisibility(View.INVISIBLE);
                btnCauca2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich7;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich7;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich7;
                }
            }
        });
        btnCauca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich7 = "";
                btnCauca2.setVisibility(View.INVISIBLE);
                btnCauca.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Câu cá";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnDientu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich8 = "Thể thao điện tử";
                btnDientu.setVisibility(View.INVISIBLE);
                btnDientu2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich8;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich8;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich8;
                }
            }
        });
        btnDientu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich8 = "";
                btnDientu2.setVisibility(View.INVISIBLE);
                btnDientu.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Thể thao điện tử";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnAmThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich9 = "Ẩm thực";
                btnAmThuc.setVisibility(View.INVISIBLE);
                btnAmThuc2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich9;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich9;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich9;
                }
            }
        });
        btnAmThuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich9 = "";
                btnAmThuc2.setVisibility(View.INVISIBLE);
                btnAmThuc.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Ẩm thực";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnNauan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich10 = "Nấu ăn";
                btnNauan.setVisibility(View.INVISIBLE);
                btnNauan2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");

                if(soThichChon1 == null){
                    soThichChon1 =sothich10;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich10;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich10;
                }
            }
        });
        btnNauan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich10 = "";
                btnNauan2.setVisibility(View.INVISIBLE);
                btnNauan.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Nấu ăn";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });
        btnXemay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich11 = "Xe máy";
                btnXemay.setVisibility(View.INVISIBLE);
                btnXemay2.setVisibility(View.VISIBLE);
                dem++;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                if(soThichChon1 == null){
                    soThichChon1 =sothich11;
                } else if( soThichChon2 == null   ){
                    soThichChon2 =sothich11;
                } else if(soThichChon3 == null){
                    soThichChon3 =sothich11;
                }
            }
        });
        btnXemay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sothich11 = "";
                btnXemay2.setVisibility(View.INVISIBLE);
                btnXemay.setVisibility(View.VISIBLE);
                dem--;
                tieptuc_sothich.setText("Tiếp tục "+dem+"/3");
                String sothich31 = "Xe máy";
                if( soThichChon1 == sothich31){
                    soThichChon1 =null;
                } else if(soThichChon2 == sothich31){
                    soThichChon2 =null;
                } else if(soThichChon3 == sothich31){
                    soThichChon3 =null;
                }
            }
        });


        tieptuc_sothich = findViewById(R.id.btnTT_sothich);
        tieptuc_sothich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dem>3){
                    txtErroSoThich.setVisibility(View.VISIBLE);
                }else{
                    txtErroSoThich.setVisibility(View.INVISIBLE);
                    Intent intentGEt = getIntent();
                    String gioiTinh = intentGEt.getStringExtra("gt");
                    Intent intent = new Intent(thongtin_sothich.this, com.example.du_an_1_android.thongtin_mota.class);
                    intent.putExtra("gt",gioiTinh);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    String id = firebaseAuth.getUid();
                    ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                    thongTinDangNhap.setSoThich1(soThichChon1);
                    node.child(id).updateChildren(thongTinDangNhap.toMapSoThich1());
                    nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapSoThich1());

                    ThongTinDangNhap thongTinDangNhap2 = new ThongTinDangNhap();
                    thongTinDangNhap2.setSoThich2(soThichChon2);
                    node.child(id).updateChildren(thongTinDangNhap2.toMapSoThich2());
                    nodeAdmin.child(id).updateChildren(thongTinDangNhap2.toMapSoThich2());

                    ThongTinDangNhap thongTinDangNhap3 = new ThongTinDangNhap();
                    thongTinDangNhap3.setSoThich3(soThichChon3);
                    node.child(id).updateChildren(thongTinDangNhap3.toMapSoThich3());
                    nodeAdmin.child(id).updateChildren(thongTinDangNhap3.toMapSoThich3());
                }

            }
        });




    }
    public void Anhxa(){
        btnTheThao = findViewById(R.id.btnTheThao);
        btnVeDem = findViewById(R.id.btnVeDem);
        btnAmNhac = findViewById(R.id.btnAmNhac);
        btnDulich = findViewById(R.id.btnDulich);
        btnCafe = findViewById(R.id.btnCafe);
        btnDocsach = findViewById(R.id.btnDocsach);
        btnCauca = findViewById(R.id.btnCauca);
        btnDientu = findViewById(R.id.btnDientu);
        btnAmThuc = findViewById(R.id.btnAmtThuc);
        btnNauan = findViewById(R.id.btnNauan);
        btnXemay = findViewById(R.id.btnXemay);

        btnTheThao2 = findViewById(R.id.btnTheThao2);
        btnVeDem2 = findViewById(R.id.btnVeDem2);
        btnAmNhac2 = findViewById(R.id.btnAmNhac2);
        btnDulich2 = findViewById(R.id.btnDulich2);
        btnCafe2 = findViewById(R.id.btnCafe2);
        btnDocsach2 = findViewById(R.id.btnDocsach2);
        btnCauca2 = findViewById(R.id.btnCauca2);
        btnDientu2 = findViewById(R.id.btnDientu2);
        btnAmThuc2 = findViewById(R.id.btnAmtThuc2);
        btnNauan2 = findViewById(R.id.btnNauan2);
        btnXemay2 = findViewById(R.id.btnXemay2);

        txtErroSoThich = findViewById(R.id.txtErroSoThich);
    }
}