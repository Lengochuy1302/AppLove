package com.example.du_an_1_android;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class thongtin_ngaysinh extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button dateButton, datePickerButton;
    Button tieptuc_Date;
    ImageView trove_Date;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_thongtin_ngaysinh);
        initDatePicker();
        firebaseAuth=FirebaseAuth.getInstance();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        
        //         tiếp tục
        tieptuc_Date = findViewById(R.id.btnTT_ngaysinh);
        tieptuc_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentGEt = getIntent();
                String gioiTinh = intentGEt.getStringExtra("gt");
                String id = firebaseAuth.getUid();
                datePickerButton = findViewById(R.id.datePickerButton);
                String TenCuaBan = datePickerButton.getText().toString().trim();
                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                thongTinDangNhap.setNgaySinh(TenCuaBan);

                node.child(id).updateChildren(thongTinDangNhap.toMapNgaySinh());
                nodeAdmin.child(id).updateChildren(thongTinDangNhap.toMapNgaySinh());

                Intent intent = new Intent(thongtin_ngaysinh.this, thongtin_sothich.class);
                intent.putExtra("gt",gioiTinh);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

//        Trờ về
        trove_Date = findViewById(R.id.back_ngaysinh);
        trove_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thongtin_ngaysinh.this, thongtin_Name.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return day +"/" + getMonthFormat(month) + "/" + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "1";
        if(month == 2)
            return "2";
        if(month == 3)
            return "3";
        if(month == 4)
            return "4";
        if(month == 5)
            return "5";
        if(month == 6)
            return "6";
        if(month == 7)
            return "7";
        if(month == 8)
            return "8";
        if(month == 9)
            return "9";
        if(month == 10)
            return "10";
        if(month == 11)
            return "11";
        if(month == 12)
            return "12";

        //default should never happen
        return "1";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}