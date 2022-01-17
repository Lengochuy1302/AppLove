package com.example.du_an_1_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private List<ThongTinXuat> items;

    public CardStackAdapter(List<ThongTinXuat> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_swipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView nama, usia, kota;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            nama = itemView.findViewById(R.id.item_name);
            usia = itemView.findViewById(R.id.item_age);
            kota = itemView.findViewById(R.id.item_city);
        }

        void setData(ThongTinXuat data) {
            Picasso.get()
                    .load(data.getHinh1())
                    .fit()
                    .centerCrop()
                    .into(image);
            nama.setText(data.getTenCuaBan());
            usia.setText(data.getNgaySinh());
            kota.setText(data.getSoThich1());
        }
    }

    public List<ThongTinXuat> getItems() {
        return items;
    }

    public void setItems(List<ThongTinXuat> items) {
        this.items = items;
    }
}
