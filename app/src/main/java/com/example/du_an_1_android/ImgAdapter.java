package com.example.du_an_1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImgAdapter extends PagerAdapter {
    private Context mContext;
    private List<Image> mListPhoto;

    public ImgAdapter(Context mContext, List<Image> mListPhoto) {
        this.mContext = mContext;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgPhoto = view.findViewById(R.id.imgPhoto);

        Image photo = mListPhoto.get(position);
        if (photo != null){
            Glide.with(mContext).load(photo.getArt()).into(imgPhoto);

        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (mListPhoto != null){
            return mListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }
}
