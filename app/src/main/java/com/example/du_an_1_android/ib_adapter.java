package com.example.du_an_1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ib_adapter extends RecyclerView.Adapter<ib_ViewHolders>{
    private List<ib_object> matchesList;
    private Context context;
    public ib_adapter(List<ib_object> matchesList, Context context) {
        this.matchesList = matchesList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ib_ViewHolders onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ib, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        ib_ViewHolders rcv = new ib_ViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ib_ViewHolders holder, int position) {
        holder.mMatchId.setText(matchesList.get(position).getId());
        holder.mMatchName.setText(matchesList.get(position).getTenCuaBan());
        Picasso.get()
                .load(matchesList.get(position).getHinh1())
                .fit()
                .centerCrop()
                .into(holder.mMatchImage);
    }






    @Override
    public int getItemCount() {
        return this.matchesList.size();
    }
}
