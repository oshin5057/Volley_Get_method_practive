package com.example.android.volleyselftaskone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.volleyselftaskone.R;
import com.example.android.volleyselftaskone.model.Hero;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Hero> heroList;
    private Context mContext;

    public RecyclerViewAdapter(List<Hero> heroes, Context context){
        this.heroList = heroes;
        this.mContext = context;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(heroList.get(position).getImage());
        holder.tvImageUrl.setText(heroList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvImageUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textViewName);
            tvImageUrl = itemView.findViewById(R.id.textViewImageUrl);
        }
    }
}
