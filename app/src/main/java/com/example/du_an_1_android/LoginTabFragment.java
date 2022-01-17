package com.example.du_an_1_android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LoginTabFragment extends Fragment {
    TextInputLayout edtLogin, edtPass;
    TextInputEditText edtGmail, edtPassword;
    String tendangnhap, matkhau;
    TextView txtForget;
    Button btnLogin;
    String idput;
    SharedPreferences sharedPreferences;
    float v = 0;
    ArrayList<ThongTinDangNhap> arrLG;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
        DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
        //Anh xa
        arrLG = new ArrayList<ThongTinDangNhap>();
        edtLogin = root.findViewById(R.id.edtLogin);
        edtPass = root.findViewById(R.id.edtPass);
        btnLogin = root.findViewById(R.id.btn_login);
        txtForget = root.findViewById(R.id.txtForget);
        edtGmail = getActivity().findViewById(R.id.edtEmail);
        edtPassword = getActivity().findViewById(R.id.edtPassword);
        edtLogin.setTranslationX(800);
        edtPass.setTranslationX(800);
        btnLogin.setTranslationX(800);
        txtForget.setTranslationX(800);

        edtLogin.setAlpha(v);
        edtPass.setAlpha(v);
        btnLogin.setAlpha(v);
        txtForget.setAlpha(v);

        edtLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edtPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        txtForget.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        btnLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();


        Query query = nodeAdmin.orderByChild("gmail");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                ThongTinDangNhap thongTinDangNhap = snapshot.getValue(ThongTinDangNhap.class);
                if (thongTinDangNhap != null) {
                    arrLG.add(thongTinDangNhap);
                }
            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        sharedPreferences = this.getActivity().getSharedPreferences("AccountSharedPreferences", Context.MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username1, passwords1;
                int vitri = 0;
                edtGmail = root.findViewById(R.id.edtEmail);
                edtPassword = root.findViewById(R.id.edtPassword);
                username1 = edtGmail.getText().toString().trim();
                passwords1 = edtPassword.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String id;
                boolean check = false;
                if (arrLG != null) {
                    for (int i = 0; i < arrLG.size(); i = i + 1) {
                        String userName = arrLG.get(i).getTenDangNhap();
                        String passwords = arrLG.get(i).getMatKhau();
                        id = arrLG.get(i).getId().toString();
                        if (username1.equals(userName)) {
                            if (passwords1.equals(passwords)) {
                                check = true;
                                idput = id;
                            }
                        }
                    }
                }
                if (!check) {
                    Toast.makeText(getActivity(), "Sai tai khoan", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("id", idput.toString());
                    editor.apply();
                    Intent intent = new Intent(getActivity(), HomeTabFragment.class);
                    Toast.makeText(getActivity(), "" + idput, Toast.LENGTH_SHORT).show();
                    intent.putExtra("name", idput);
                    startActivity(intent);
                }
                editor.apply();
            }
        });

        return root;
    }
}
