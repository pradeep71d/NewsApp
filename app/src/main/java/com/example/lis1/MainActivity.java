package com.example.lis1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DataClass> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        arrayList.add(new DataClass("Hindu", "https://www.thehindu.com"));
        arrayList.add(new DataClass("Dainik Jagaran", "https://www.jagran.com/"));
        arrayList.add(new DataClass("TimesOfIndia", "https://timesofindia.indiatimes.com"));
        arrayList.add(new DataClass("NewYorkTimes", "https://www.nytimes.com"));
        arrayList.add(new DataClass("ZeeNews", "https://www.zeenews.com"));
        arrayList.add(new DataClass("News Nation", "https://www.newsnation.com"));
        arrayList.add(new DataClass("NDTV", "https://www.ndtv.com"));
        arrayList.add(new DataClass("Sports News", "https://www.sportsnews.com"));
        arrayList.add(new DataClass("Indian Express", "https://www.indianExpress.com"));
        arrayList.add(new DataClass("Punjab Kesari", "https://www.punjabkesari.com"));
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, R.layout.itemlist, arrayList);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
