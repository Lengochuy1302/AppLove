package com.example.du_an_1_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ahihihihihi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        Button btn = findViewById(R.id.ahihi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9])|(9[0-46-9]))(\\d)(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})?(\\d)$";
                EditText editText = findViewById(R.id.edttest);
                String duLieu = editText.getText().toString().trim();
                if (checkGmail(duLieu) == true) {
                    Toast.makeText(ahihihihihi.this, "m nhập gmail à", Toast.LENGTH_SHORT).show();
                }
                else if (duLieu.matches("^[0-9]{10}$")){
                     Toast.makeText(ahihihihihi.this, "m nhập sđt à", Toast.LENGTH_SHORT).show();
                 }
                else {
                    Toast.makeText(ahihihihihi.this, "m nhập gì z", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });





    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean checkGmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}