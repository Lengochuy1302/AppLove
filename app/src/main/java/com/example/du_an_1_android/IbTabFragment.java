package com.example.du_an_1_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class IbTabFragment extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mMatchesAdapter;
    private RecyclerView.LayoutManager mMatchesLayoutManager;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ib_tab_fragment);
        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        String idUsur = sharedPreferences.getString("id", "");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);
        mMatchesLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mMatchesLayoutManager);
        mMatchesAdapter = new ib_adapter(getDataSetMatches(), this);
        mRecyclerView.setAdapter(mMatchesAdapter);

        getUserMatchId();

        Menu_Nav();
    }
    private void getUserMatchId() {
        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        String idUsur = sharedPreferences.getString("id", "");
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
        DatabaseReference matchDb = db.getReference().child("Tai_Khoan").child(idUsur).child("connections").child("matches");

        matchDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for(DataSnapshot match : dataSnapshot.getChildren()){
                        FetchMatchInformation(match.getKey());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void FetchMatchInformation(String key) {
        DatabaseReference userDb = FirebaseDatabase.getInstance().getReference().child("Tai_Khoan").child(key);
        userDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String userId = dataSnapshot.getKey();
                    String name = "";
                    String hinh1 = "";
                    if(dataSnapshot.child("tenCuaBan").getValue()!=null){
                        name = dataSnapshot.child("tenCuaBan").getValue().toString();
                    }
                    if(dataSnapshot.child("hinh1").getValue()!=null){
                        hinh1 = dataSnapshot.child("hinh1").getValue().toString();
                    }


                    ib_object obj = new ib_object(userId, name, hinh1);
                    resultsMatches.add(obj);
                    mMatchesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private ArrayList<ib_object> resultsMatches = new ArrayList<ib_object>();
    private List<ib_object> getDataSetMatches() {
        return resultsMatches;
    }
    public void Menu_Nav(){
        BottomNavigationView bottomNavigationView   = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Ib_fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.Home_fragment:
                        startActivity(new Intent(getApplicationContext(),HomeTabFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.Ib_fragment:
                        return true;
                    case  R.id.Iam_fragment:
                        startActivity(new Intent(getApplicationContext(), IamTabFragment.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
