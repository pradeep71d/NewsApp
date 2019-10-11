package com.example.lis1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Context context;
    int res;
    ArrayList<DataClass> Al;

    public MyAdapter(Context context, int res, ArrayList<DataClass> al) {
        this.context = context;
        this.res = res;
        Al = al;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(res, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {

        holder.textView1.setText(Al.get(position).getName());
//holder.textView1.setText(dataClass.getUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);//this is method to pass data from adapter to another activity
                intent.putExtra("key1", Al.get(position).getUrl());//here we are putting data in key and value pair
                context.startActivity(intent);//Al.get(position).getUrl() is string value
            }
        });
    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView1;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.t1);
            // textView2 = itemView.findViewById(R.id.t2);
        }
    }
}
