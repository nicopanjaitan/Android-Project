package com.example.nicossubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_BATIK = "extra_batik";
    Toolbar toolbar;

    TextView name, description;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        showBatikData();
    }

    private void initView() {
        name = findViewById(R.id.tv_detail_name);
        description = findViewById(R.id.tv_detail_description);
        photo = findViewById(R.id.iv_detail_photo);

        toolbar = findViewById(R.id.toolbar_detail);
        toolbar.setTitle("Detail");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showBatikData() {
        Batik batik = getIntent().getParcelableExtra(EXTRA_BATIK);

        Glide.with(this).load(batik.getPhoto()).into(photo);
        name.setText(batik.getTitle());
        description.setText(batik.getDescription());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}