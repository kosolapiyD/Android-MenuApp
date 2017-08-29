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

import com.medved.mymenuapp.Beer;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;
import com.medved.mymenuapp.TopLevelActivity;
import com.medved.mymenuapp.adapters.BeerAdapter;
import com.medved.mymenuapp.mySQL.BeerDataBaseHelper;

public class BeerListActivity extends Activity {

    private ListView beerList;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_list);
        beerList = (ListView) findViewById(R.id.beerList_id);
        setTitle(getString(R.string.beer_list_title));

        //beerList.setAdapter(new BeerAdapter(Beer.getBeers(), this));
        beerList.setAdapter(new BeerAdapter(getBeerFromDB(), this));
    }

    public Beer[] getBeerFromDB() {

        SQLiteOpenHelper beerDatabaseHelper = new BeerDataBaseHelper(this);
        db = beerDatabaseHelper.getReadableDatabase();

        cursor = db.query("BEER", null, null, null, null, null, null);

        Beer[] beers = new Beer[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext(), i++) { //move through ech of the records (Axis Y)

            //(Axis X)
            String name = cursor.getString(1);//get beer name
            String description = cursor.getString(2);//get beer description
            double price = cursor.getDouble(3);//get price
            int res = cursor.getInt(4);//get resource of image
            int beerId = cursor.getInt(5);
            int qty = cursor.getInt(6);
            Beer current = new Beer(name, description, price, res, beerId, qty); //create new list_item instance

            beers[i] = current; //place new list_item in the array
        }
        return beers;
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
        menu.findItem(R.id.action_beer).setVisible(false);
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
            case R.id.action_coffee:
                Intent c = new Intent(this, CoffeeListActivity.class);
                startActivity(c);
                return true;
            case R.id.action_dessert:
                Intent d = new Intent(this, DessertListActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
