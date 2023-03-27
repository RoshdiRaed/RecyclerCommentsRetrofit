package com.example.recyclercommentsretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    Context c;
    ArrayList <Comments> comments;

    public MyAdapter(Context c, ArrayList<Comments> comments) {
        this.c = c;
        this.comments = comments;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(c)
               .inflate(R.layout.comments_item,null,false);

       MyHolder mh = new MyHolder(v);

       return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {
        Comments comments1 = comments.get(position);

        holder.tv_id.setText(String.valueOf(comments1.getId()));
        holder.tv_email.setText(comments1.getEmail());
        holder.tv_body.setText(comments1.getBody());
        holder.tv_name.setText(comments1.getName());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView tv_id,tv_name,tv_email,tv_body;
        
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_body = itemView.findViewById(R.id.tv_body);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
