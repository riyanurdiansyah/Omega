package com.riyanurdiansyah.omega.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riyanurdiansyah.omega.R;
import com.riyanurdiansyah.omega.model.Penjualan;

import java.util.List;

public class NotExistsAdapter extends RecyclerView.Adapter<NotExistsAdapter.MyViewHolder> {

    List<Penjualan> penjualans;
    Context context;

    public NotExistsAdapter(List<Penjualan> penjualans, Context context) {
        this.penjualans = penjualans;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notexist, null, false);

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_id.setText(""+penjualans.get(position).getId_staf());
        holder.tv_nama.setText(penjualans.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return penjualans.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_nama;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tvIdEx);
            tv_nama = itemView.findViewById(R.id.tvNamaEx);
        }
    }
}