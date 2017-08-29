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

import com.medved.mymenuapp.Coffee;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;
import com.medved.mymenuapp.TopLevelActivity;
import com.medved.mymenuapp.adapters.CoffeeAdapter;
import com.medved.mymenuapp.mySQL.CoffeeDataBaseHelper;

public class CoffeeListActivity extends Activity {

    private ListView coffeeList;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_list);
        coffeeList = (ListView) findViewById(R.id.coffeeList_id);
        setTitle(getString(R.string.coffee_list_title));

        coffeeList.setAdapter(new CoffeeAdapter(getCoffeeFromDB(), this));
//        coffeeList.setAdapter(new CoffeeAdapter(Coffee.getCoffee(),this));
    }

    public Coffee[] getCoffeeFromDB() {

        SQLiteOpenHelper coffeeDatabaseHelper = new CoffeeDataBaseHelper(this);
        db = coffeeDatabaseHelper.getReadableDatabase();

        cursor = db.query("COFFEE", null, null, null, null, null, null);

        Coffee[] coffee = new Coffee[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext(), i++) { //move through ech of the records (Axis Y)

            //(Axis X)
            String name = cursor.getString(1);//get coffee name
            String description = cursor.getString(2);// get coffee description
            double price = cursor.getDouble(3);//get price
            int res = cursor.getInt(4);//get resource of image
            int coffeeId = cursor.getInt(5);
            int qty = cursor.getInt(6);
            Coffee current = new Coffee(name, description, price, res, coffeeId, qty); //create new list_item instance

            coffee[i] = current; //place new list_item in the array
        }
        return coffee;
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
        menu.findItem(R.id.action_coffee).setVisible(false);
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
            case R.id.action_dessert:
                Intent d = new Intent(this, DessertListActivity.class);
                startActivity(d);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
