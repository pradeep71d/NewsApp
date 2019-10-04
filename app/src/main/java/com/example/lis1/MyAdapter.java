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
        final DataClass dataClass = Al.get(position);
        holder.textView1.setText(dataClass.getName());
    //    holder.textView2.setText(dataClass.getUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, WebViewActivity.class);
                i.putExtra("key",dataClass.getUrl());
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return Al.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.t1);
            textView2 = itemView.findViewById(R.id.t2);
        }
    }
}