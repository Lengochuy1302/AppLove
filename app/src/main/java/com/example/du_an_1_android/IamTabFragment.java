package com.example.du_an_1_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class IamTabFragment extends AppCompatActivity {
    LinearLayout logout;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.iam_tab_fragment);
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        logout = findViewById(R.id.onClickLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(IamTabFragment.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Menu_Nav();
    }

    public void Menu_Nav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Iam_fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home_fragment:
                        startActivity(new Intent(getApplicationContext(), HomeTabFragment.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Ib_fragment:
                        startActivity(new Intent(getApplicationContext(), IbTabFragment.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Iam_fragment:
                        return true;
                }
                return false;
            }
        });
    }
}
