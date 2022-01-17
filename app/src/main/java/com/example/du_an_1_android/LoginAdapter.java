package com.example.du_an_1_android;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.jetbrains.annotations.NotNull;

public class LoginAdapter extends FragmentStatePagerAdapter {

    public LoginAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new LoginTabFragment();
            case 1:
                return  new com.example.du_an_1_android.SignuUpTabFragment();
            default:
                return new LoginTabFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Login";
                break;
            case 1:
                title = "Signup";
                break;
        }
        return title;
    }
}
