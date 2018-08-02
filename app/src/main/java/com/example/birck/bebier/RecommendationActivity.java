package com.example.birck.bebier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.birck.bebier.models.Beer;
import com.example.birck.bebier.utils.JSONReader;

import java.util.ArrayList;

public class RecommendationActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("data");
        fillToolbar(JSONReader.getBeerData(this, myList.get(0)));
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recommendedBeers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myList.remove(0);
        adapter = new MyRecyclerViewAdapter(this, myList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, SearchActivity.class));
    }
    private void fillToolbar(Beer beer){
//        Toolbar toolbar = findViewById(R.id.toolbar2);
        TextView beerName = findViewById(R.id.beerNameTV);
        TextView abv = findViewById(R.id.abvTV);
        TextView beerStyle = findViewById(R.id.beerStyleTV);
        TextView ibu = findViewById(R.id.ibuTV);
        TextView estCal = findViewById(R.id.estCalTV);
        ImageView img = findViewById(R.id.imageView);
        beerName.setText(beer.getName());
        abv.setText(beer.getAbv());
        beerStyle.setText(beer.getBeer_style());
        ibu.setText(beer.getIbu());
        estCal.setText(beer.getEst_cal());
        Glide.with(this)
                .load(beer.getPhoto_url())
                .apply(RequestOptions.circleCropTransform())
                .into(img);
    }
}

