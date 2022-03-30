package com.example.roughwork02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<userdata>list;

    public MyAdapter(Context context, ArrayList<userdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    userdata user = list.get(position);

    holder.name.setText(user.getName());
    holder.article.setText(user.getArticle());
    holder.category.setText(user.getCategory());
    holder.date.setText(user.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,category,article,date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.tvfirstName);
            article = itemView.findViewById(R.id.tvarticle);
            category = itemView.findViewById(R.id.tvcategory);
            date = itemView.findViewById(R.id.tvdate);


        }
    }
}
