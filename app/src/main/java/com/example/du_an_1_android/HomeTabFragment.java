package com.example.du_an_1_android;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeTabFragment extends AppCompatActivity {
    private static final String TAG = "HomeTabFragment";

    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;
    private FirebaseAuth mAuth;


    int i;
    List<ThongTinXuat> arr;

    SharedPreferences sharedPreferences;

    FirebaseDatabase db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
    private DatabaseReference usersDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.home_tab_fragment);

        db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
        usersDb = db.getReference().child("Tai_Khoan");
        mAuth = FirebaseAuth.getInstance();


//        goi sharedPreferences
        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        String idUsur = sharedPreferences.getString("id", "");
        String name = intent.getStringExtra("name");
        arr = new ArrayList<>();


        CardStackView cardStackView = findViewById(R.id.card_stack_view);
//        luot app
        manager = new CardStackLayoutManager(HomeTabFragment.this, new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);
                ThongTinXuat thongTinXuat = new ThongTinXuat();

                if (direction == Direction.Right) {
                    int vitri = manager.getTopPosition() - 1;
                    String id = arr.get(vitri).getId();
                    db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
                    db.getReference().child("Tai_Khoan").child(id).child("connections").child("nope").child(idUsur).setValue(true);



                }
                if (direction == Direction.Top) {
                    Toast.makeText(HomeTabFragment.this, "Direction Top", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Left) {
                    int vitri = manager.getTopPosition() - 1;
                    String id = arr.get(vitri).getId();
                    db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
                    db.getReference().child("Tai_Khoan").child(id).child("connections").child("yeps").child(idUsur).setValue(true);
                    isConnectionMatch(id);

                }
                if (direction == Direction.Bottom) {
                    Toast.makeText(HomeTabFragment.this, "Direction Bottom", Toast.LENGTH_SHORT).show();
                }

//                 Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - 5) {
                    paginate();
                }

            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
                TextView tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                TextView tv = view.findViewById(R.id.item_name);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
        adapter = new CardStackAdapter(addList());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());

        Menu_Nav();
    }

    private void paginate() {
        adapter.notifyDataSetChanged();
        List<ThongTinXuat> old = adapter.getItems();
        List<ThongTinXuat> baru = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, baru);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setItems(baru);
        hasil.dispatchUpdatesTo(adapter);
        adapter.notifyDataSetChanged();
    }
    private String userSex;
    private String oppositeUserSex;
    private List<ThongTinXuat> addList() {
        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        String idUsur = sharedPreferences.getString("id", "");
            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
            DatabaseReference gioitinh = db.getReference().child("Tai_Khoan").child(idUsur);

            gioitinh.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            if (dataSnapshot.child("gioiTinh").getValue() != null){
                                userSex = dataSnapshot.child("gioiTinh").getValue().toString();
                                switch (userSex){
                                    case "Nam":
                                        oppositeUserSex = "Nữ";
                                        break;
                                    case "Nữ":
                                        oppositeUserSex = "Nam";
                                        break;
                                }

                            }
                            getOppositeSexUsers();
                        }
                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return arr;
    }



    public void getOppositeSexUsers(){
        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        String idUsur = sharedPreferences.getString("id", "");
        db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
        DatabaseReference gioitinh = db.getReference().child("Tai_Khoan");
        gioitinh.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {
                if (snapshot.exists() && !snapshot.child("connections").child("nope").hasChild(idUsur) && !snapshot.child("connections").child("yeps").hasChild(idUsur) && snapshot.child("gioiTinh").getValue().toString().equals(oppositeUserSex)){
                    ThongTinXuat item = new ThongTinXuat(snapshot.getKey(),
                            snapshot.child("tenCuaBan").getValue().toString(),
                            snapshot.child("ngaySinh").getValue().toString(),
                            snapshot.child("soThich1").getValue().toString(),
                            snapshot.child("hinh1").getValue().toString());
                    arr.add(item);
                    adapter.notifyDataSetChanged();
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
    }

    private void isConnectionMatch(String s) {
        Intent intent = getIntent();
        sharedPreferences = getSharedPreferences("AccountSharedPreferences", MODE_PRIVATE);
        String idUsur = sharedPreferences.getString("id", "");
        db = FirebaseDatabase.getInstance("https://du-an-1-android-75d60-default-rtdb.firebaseio.com/");
        DatabaseReference currentUserConnectionsDb = db.getReference().child("Tai_Khoan").child(idUsur).child("connections").child("yeps").child(s);
        currentUserConnectionsDb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String key = FirebaseDatabase.getInstance().getReference().child("Chat").push().getKey();
                    db.getReference().child("Tai_Khoan").child(dataSnapshot.getKey()).child("connections").child("matches").child(idUsur).child("ChatId").setValue(key);
                    db.getReference().child("Tai_Khoan").child(idUsur).child("connections").child("matches").child(dataSnapshot.getKey()).child("ChatId").setValue(key);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void Menu_Nav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Home_fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home_fragment:
                        return true;
                    case R.id.Ib_fragment:
                        startActivity(new Intent(getApplicationContext(), IbTabFragment.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Iam_fragment:
                        startActivity(new Intent(getApplicationContext(), IamTabFragment.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    protected void onStop() {
        finish();
        super.onStop();

    }

}
