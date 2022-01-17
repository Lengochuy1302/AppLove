package com.example.du_an_1_android;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class CardStackCallback extends DiffUtil.Callback {

    private List<ThongTinXuat> old, baru;

    public CardStackCallback(List<ThongTinXuat> old, List<ThongTinXuat> baru) {
        this.old = old;
        this.baru = baru;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return baru.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).getHinh1() == baru.get(newItemPosition).getHinh1();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == baru.get(newItemPosition);
    }
}
