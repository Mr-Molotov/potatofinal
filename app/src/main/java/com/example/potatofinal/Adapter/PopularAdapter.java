package com.example.potatofinal.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.potatofinal.actividades.DetailActivity;
import com.example.potatofinal.databinding.ViewholderPopularBinding;
import com.example.potatofinal.dominios.Item;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<Item> items;
    Context context;
    ViewholderPopularBinding binding;

    public PopularAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ViewholderPopularBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        context=parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {

        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.addressTxt.setText(items.get(position).getAddress());
        binding.scoreTxt.setText(""+items.get(position).getScore());

        Glide.with(context)
                .load(items.get(position).getPic()).into(binding.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                Intent.putExtra("object",items.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderPopularBinding binding) {
            super(binding.getRoot());
        }
    }
}
