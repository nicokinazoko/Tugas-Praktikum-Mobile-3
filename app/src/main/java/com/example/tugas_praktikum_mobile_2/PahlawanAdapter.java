package com.example.tugas_praktikum_mobile_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PahlawanAdapter extends RecyclerView.Adapter<PahlawanAdapter.ViewHolder> {

    @NonNull


    private Context context;
    private ArrayList<PahlawanModel> pahlawanModels;

    public PahlawanAdapter(@NonNull Context context) {
        this.context = context;
    }

    public ArrayList<PahlawanModel> getPahlawanModels() {
        return pahlawanModels;
    }

    public void setPahlawanModels(ArrayList<PahlawanModel> pahlawanModels) {
        this.pahlawanModels = pahlawanModels;
    }


//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View itemRow = LayoutInflater.from(viewGroup.getContext()).
//                inflate(R.layout.item_pahlawan_baru,viewGroup,false);
//        return new ViewHolder(itemRow);
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow        =   LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan_baru,parent,false);

        return  new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(getPahlawanModels().get(position).getFotoPahlawan()).into(holder.ivFotoPahlawan);

        holder.tvNamaPahlawan.setText(getPahlawanModels().get(position).getNamaPahlawan());

        holder.tvDetailPahlawan.setText(getPahlawanModels().get(position).getBiografiPahlawan());
    }

    //    @Override
//    public void onBindViewHolder(@NonNull  PahlawanModel.ViewHolder viewHolder, int i) {
//        Glide.with(context).load(getPahlawanModels().get(i).getFotoPahlawan()).into(viewHolder.ivFotoPahlawan);
//        viewHolder.tvNamaPahlawan.setText(getPahlawanModels().get(i).getNamaPahlawan());
//        viewHolder.tvDetailPahlawan.setText(getPahlawanModels().get(i).getBiografiPahlawan());
//
//    }

    //    @Override
    public int getItemCount() {
        return getPahlawanModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFotoPahlawan;
        private TextView tvNamaPahlawan;
        private TextView tvDetailPahlawan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoPahlawan          =   itemView.findViewById(R.id.iv_FotoPahlawan);
            tvNamaPahlawan          =   itemView.findViewById(R.id.tv_NamaPahlawan);
            tvDetailPahlawan        =   itemView.findViewById(R.id.tv_DetailPahlawan);
        }
    }

    public class Adapter<T> {
    }
}