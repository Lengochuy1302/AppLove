package com.example.du_an_1_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignuUpTabFragment extends Fragment {
    TextInputEditText edtTK, edtMK, edtOTP;
    TextInputLayout edtOTPShow;
    Button btnSinUp;
    String txtTK, txtMk,txtOPT;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    FirebaseAuth firebaseAuth;
    String gioiTinh = null;
    TextView otp;
    Button btnNamWhite,btnNuWhite,btnKhacWhite,btnNamPink,btnNuPink,btnKhacPink;
    ArrayList<ThongTinDangNhap> arrLG;
    private TextView mLoginFeedbackText;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    private  String idd;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    DatabaseReference node = db.getReference("Tai_Khoan");
    DatabaseReference nodeAdmin = db.getReference("Tai_Khoan_Admin");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        edtTK = root.findViewById(R.id.edtEmailSinup);
        edtMK = root.findViewById(R.id.passSinup);
        edtOTPShow = root.findViewById(R.id.maotp);
        edtOTP = root.findViewById(R.id.edtOTP);
        firebaseAuth=FirebaseAuth.getInstance();
        btnSinUp =  root.findViewById(R.id.btn_signup);
        txtTK = edtTK.getText().toString().trim();
        txtMk = edtMK.getText().toString().trim();
        txtOPT = edtOTP.getText().toString().trim();

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();

        otp = root.findViewById(R.id.Guiotp);
        btnNamWhite = root.findViewById(R.id.btnNamWhite);
        btnNuWhite = root.findViewById(R.id.btnNuWhite);
        btnNamPink = root.findViewById(R.id.btnNamPink);
        btnNuPink = root.findViewById(R.id.btnNuPink);
        if (gioiTinh==null){
            Toast.makeText(getActivity(), "Xin mời chọn giới tính", Toast.LENGTH_SHORT).show();
        }
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
        btnNamWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Nam";
                btnNuPink.setVisibility(View.INVISIBLE);
                btnNamWhite.setVisibility(View.INVISIBLE);
                btnNuWhite.setVisibility(View.VISIBLE);
                btnNamPink.setVisibility(View.VISIBLE);
            }
        });
        btnNuWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gioiTinh = "Nữ";
                btnNamPink.setVisibility(View.INVISIBLE);
                btnNuWhite.setVisibility(View.INVISIBLE);
                btnNamWhite.setVisibility(View.VISIBLE);
                btnNuPink.setVisibility(View.VISIBLE);
            }
        });


        edtTK.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String duLieu = edtTK.getText().toString().trim();
                if (checkGmail(duLieu) == true) {
                    otp.setVisibility(View.INVISIBLE);
                    edtOTPShow.setVisibility(View.INVISIBLE);
                }
                else if (duLieu.matches("^[0-9]{10}$")){
                    otp.setVisibility(View.VISIBLE);
                    edtOTPShow.setVisibility(View.VISIBLE);

                }
                else {
                    otp.setVisibility(View.INVISIBLE);
                    edtOTPShow.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
        mLoginFeedbackText = root.findViewById(R.id.login_form_feedback);

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                txtTK = edtTK.getText().toString().trim();

                String complete_phone_number = "+" + "84" + ""+txtTK+"";

                if(txtTK.isEmpty()){
                    mLoginFeedbackText.setText("Vui lòng điền vào biểu mẫu để tiếp tục.");
                    mLoginFeedbackText.setVisibility(View.VISIBLE);
//                    btnSinUp.setBackgroundColor(R.drawable.boder_button_test);
                } else {

                    otp.setEnabled(false);


                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            complete_phone_number,
                            60,
                            TimeUnit.SECONDS,
                            getActivity(),
                            mCallbacks

                    );


                }
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


            @Override
            public void onVerificationFailed(FirebaseException e) {
                mLoginFeedbackText.setText("Mã xác nhận thất bại. Vui lòng thử lại.");
                mLoginFeedbackText.setVisibility(View.VISIBLE);
                otp.setEnabled(true);
            }

            @Override
            public void onCodeSent(final String sid, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(sid, forceResendingToken);


                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                idd = sid;
                            }
                        },
                        3000);
            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }
        };


        btnSinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTK = root.findViewById(R.id.edtEmailSinup);
                edtMK = root.findViewById(R.id.passSinup);
                edtOTP = root.findViewById(R.id.edtOTP);
                txtTK = edtTK.getText().toString().trim();
                txtMk = edtMK.getText().toString().trim();
                String otp = edtOTP.getText().toString();
                String duLieu = edtTK.getText().toString().trim();
                if (checkGmail(duLieu) == true) {
                    Toast.makeText(getActivity(), "Đây là gmail", Toast.LENGTH_SHORT).show();
                    dangKyFB(txtTK,txtMk);
                }
                else if (duLieu.matches("^[0-9]{10}$")){
                    Toast.makeText(getActivity(), "Đây là số điện thoại", Toast.LENGTH_SHORT).show();
                    if(otp.isEmpty()){

                        mLoginFeedbackText.setVisibility(View.VISIBLE);
                        mLoginFeedbackText.setText("Vui lòng điền vào biểu mẫu và thử lại.");

                    } else {

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(idd, otp);
                        signInWithPhoneAuthCredential(credential,txtTK,txtMk);
                    }

                }
                else {
                    Toast.makeText(getActivity(), "Hãy nhập thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });
        return root ;
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean checkGmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential,String tk,String mk) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            sendUserToHome();
                            FirebaseUser user = mAuth.getCurrentUser();
                            String id = user.getUid();
                            ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                            thongTinDangNhap.setId(id.toString());
                            thongTinDangNhap.setTenDangNhap(tk);
                            thongTinDangNhap.setMatKhau(mk);
                            thongTinDangNhap.setSDT(tk);
                            thongTinDangNhap.setGioiTinh(gioiTinh);
                            Toast.makeText(getActivity(), ""+gioiTinh, Toast.LENGTH_SHORT).show();
                            nodeAdmin.child(id).setValue(thongTinDangNhap);
                            node.child(gioiTinh).child(id).setValue(thongTinDangNhap);
                            Intent homeIntent = new Intent(getActivity(), thongtin_email.class);
                            startActivity(homeIntent);
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                mLoginFeedbackText.setVisibility(View.VISIBLE);
                                mLoginFeedbackText.setText("Sai Mã OTP");
                            }

                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            mLoginFeedbackText.setVisibility(View.VISIBLE);
                                            mLoginFeedbackText.setText("Đăng kí Thàng Công");
                                        }
                                    },
                                    3000);
                        }
//
                    }
                });
    }
    private void dangKyFB(String email,String password){
        email = edtTK.getText().toString();
        password = edtMK.getText().toString();
        if(TextUtils.isEmpty(email)){
            edtTK.setError("Email không được để trống hoặc không đúng định dạng");
            edtTK.requestFocus();
            return;
        }else if(TextUtils.isEmpty(password) && password.length()<6){
            edtMK.setError("Password không được để trống và không được bé hơn 6 ký tự");
            edtMK.requestFocus();
            return;
        }else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener( getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getActivity(), "Tài khoản được tạo thành công", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                String id = user.getUid();
                                String gmail = edtTK.getText().toString().trim();
                                String password2 = edtMK.getText().toString().trim();
                                ThongTinDangNhap thongTinDangNhap = new ThongTinDangNhap();
                                thongTinDangNhap.setId(id);
                                thongTinDangNhap.setGmail(gmail);
                                thongTinDangNhap.setTenDangNhap(gmail);
                                thongTinDangNhap.setMatKhau(password2);
                                thongTinDangNhap.setGioiTinh(gioiTinh);
                                nodeAdmin.child(id).setValue(thongTinDangNhap);
                                node.child(id).setValue(thongTinDangNhap);
                                Intent otpIntent = new Intent(getActivity(),thongtin_sdt.class);
                                otpIntent.putExtra("gt",gioiTinh);
                                startActivity(otpIntent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getActivity(), "Tạo tài khoản không thành công",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

    public void sendUserToHome() {
    }

}
