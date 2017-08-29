package com.medved.mymenuapp.lists;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.medved.mymenuapp.Dessert;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;
import com.medved.mymenuapp.TopLevelActivity;
import com.medved.mymenuapp.adapters.DessertAdapter;
import com.medved.mymenuapp.mySQL.DessertDataBaseHelper;

public class DessertListActivity extends Activity {

    private ListView dessertList;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_list);
        dessertList = (ListView) findViewById(R.id.dessertList_id);
        setTitle(getString(R.string.desserts_list_title));

//        dessertList.setAdapter(new DessertAdapter(Dessert.getDesserts(), this));
        dessertList.setAdapter(new DessertAdapter(getDessertFromDB(), this));
    }

    public Dessert[] getDessertFromDB() {

        SQLiteOpenHelper dessertDatabaseHelper = new DessertDataBaseHelper(this);
        db = dessertDatabaseHelper.getReadableDatabase();

        cursor = db.query("DESSERT", null, null, null, null, null, null);

        Dessert[] desserts = new Dessert[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext(), i++) { //move through ech of the records (Axis Y)

            //(Axis X)
            String name = cursor.getString(1);//get dessert name
            String description = cursor.getString(2);//get dessert description
            double price = cursor.getDouble(3);//get price
            int res = cursor.getInt(4);//get resource of image
            int dessertId = cursor.getInt(5);
            int qty = cursor.getInt(6);
            Dessert current = new Dessert(name, description, price, res, dessertId, qty); //create new list_item instance

            desserts[i] = current; //place new list_item in the array
        }
        return desserts;
    }

    @Override
    protected void onDestroy() {
        cursor.close();
        db.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_dessert).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent order = new Intent(this, OrderActivity.class);
                startActivity(order);
                return true;
            case R.id.action_home:
                Intent home = new Intent(this, TopLevelActivity.class);
                startActivity(home);
                return true;
            case R.id.action_food:
                Intent f = new Intent(this, FoodListActivity.class);
                startActivity(f);
                return true;
            case R.id.action_beer:
                Intent b = new Intent(this, BeerListActivity.class);
                startActivity(b);
                return true;
            case R.id.action_coffee:
                Intent c = new Intent(this, CoffeeListActivity.class);
                startActivity(c);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
