package com.example.nicossubmission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBatik;
    private ArrayList<Batik> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Indonesian Batik");

        rvBatik = findViewById(R.id.rv_mainActivity_batik);
        rvBatik.setHasFixedSize(true);

        list.addAll(BatikData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvBatik.setLayoutManager(new LinearLayoutManager(this));
        ListBatikAdapter listBatikAdapter = new ListBatikAdapter(list);
        rvBatik.setAdapter(listBatikAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent j = new Intent(this, About.class);
        startActivity(j);
        return super.onOptionsItemSelected(item);
    }
}