package com.medved.mymenuapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.medved.mymenuapp.lists.BeerListActivity;
import com.medved.mymenuapp.lists.CoffeeListActivity;
import com.medved.mymenuapp.lists.DessertListActivity;
import com.medved.mymenuapp.lists.FoodListActivity;

import java.util.HashSet;
import java.util.Set;

public class TopLevelActivity extends Activity implements View.OnClickListener {

    static Set<Beer> beers;
    static Set<Food> foods;
    static Set<Coffee> coffee;
    static Set<Dessert> dessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        // identifying the buttons
        findViewById(R.id.btnFood).setOnClickListener(this);
        findViewById(R.id.btnBeers).setOnClickListener(this);
        findViewById(R.id.btnCoffee).setOnClickListener(this);
        findViewById(R.id.btnDesserts).setOnClickListener(this);

        initSets();
    }

    void initSets()
    //initialization of the sets
    {
        if (beers == null) beers = new HashSet();
        if (foods == null) foods = new HashSet();
        if (coffee == null) coffee = new HashSet();
        if (dessert == null) dessert = new HashSet();
    }

    @Override
    public void onClick(View v) {// start the buttons
        switch (v.getId()) {
            case R.id.btnFood:
                Intent f = new Intent(this, FoodListActivity.class);
                startActivity(f);
                break;
            case R.id.btnBeers:
                Intent b = new Intent(this, BeerListActivity.class);
                startActivity(b);
                break;
            case R.id.btnCoffee:
                Intent c = new Intent(this, CoffeeListActivity.class);
                startActivity(c);
                break;
            case R.id.btnDesserts:
                Intent d = new Intent(this, DessertListActivity.class);
                startActivity(d);
                break;
        }
    }
}
