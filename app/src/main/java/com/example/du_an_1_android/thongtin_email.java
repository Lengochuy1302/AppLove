package com.example.du_an_1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class thongtin_email extends AppCompatActivity {

    Button tieptuc_email;
    ImageView troVe1;
    TextInputEditText edtGmail;
    Button btnTT_email;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_email);
        AnhXa();

        firebaseAuth=FirebaseAuth.getInstance();

        Intent intent = getIntent();
        //
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(thongtin_email.this);
        String tentk = account.getEmail();
        edtGmail.setText(tentk);
        tieptuc_email = findViewById(R.id.btnTT_email);
        tieptuc_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = firebaseAuth.getUid();
                String gmail = edtGmail.getText().toString().trim();
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setGmail(gmail);
                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                node.child(id).updateChildren(thongTinDangNhap.toMapGmail());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapGmail());
                Intent intent = new Intent(thongtin_email.this, thongtin_Name.class);
                Toast.makeText(thongtin_email.this, "chuyển thành công", Toast.LENGTH_SHORT).show();
                intent.putExtra("gt",gioiTinh);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });

//        troVe1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseAuth.signOut();
//
//                Intent otpIntent = new Intent(thongtin_email.this, MainActivity.class);
//                startActivity(otpIntent);
//            }
//        });














    }
    private void AnhXa(){
        edtGmail = findViewById(R.id.edtEmailTT);
        btnTT_email = findViewById(R.id.btnTT_email);
//        troVe1 = findViewById(R.id.back_email);
    }
}