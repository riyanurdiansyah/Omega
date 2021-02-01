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

public class ByTanggalAdapter extends RecyclerView.Adapter<ByTanggalAdapter.MyViewHolder> {

    List<Penjualan> penjualans;
    Context context;

    public ByTanggalAdapter(List<Penjualan> penjualans, Context context) {
        this.penjualans = penjualans;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_by_tanggal, null, false);

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_tanggal.setText(penjualans.get(position).getTanggal());
        holder.tv_jumlah.setText(""+penjualans.get(position).getJumlah());
        holder.tv_item_id.setText(""+penjualans.get(position).getId_detail());
    }

    @Override
    public int getItemCount() {
        return penjualans.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal, tv_item_id, tv_jumlah;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tanggal = itemView.findViewById(R.id.tvTanggalDate);
            tv_item_id = itemView.findViewById(R.id.tvItemIdDate);
            tv_jumlah = itemView.findViewById(R.id.tvJmlDate);
        }
    }
}