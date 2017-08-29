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

import com.medved.mymenuapp.Food;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;
import com.medved.mymenuapp.TopLevelActivity;
import com.medved.mymenuapp.adapters.FoodAdapter;
import com.medved.mymenuapp.mySQL.FoodDataBaseHelper;

public class FoodListActivity extends Activity {

    private ListView foodList;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        foodList = (ListView) findViewById(R.id.foodList_id);
        setTitle(getString(R.string.food_list_title));

//        foodList.setAdapter(new FoodAdapter(Food.getFoods(), this));
        foodList.setAdapter(new FoodAdapter(getFoodFromDB(), this));

    }

    public Food[] getFoodFromDB() {

        SQLiteOpenHelper foodDataBaseHelper = new FoodDataBaseHelper(this);
        db = foodDataBaseHelper.getReadableDatabase();

        cursor = db.query("FOOD", null, null, null, null, null, null);

        Food[] foods = new Food[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext(), i++) { //move through ech of the records (Axis Y)
            //(Axis X)
            String name = cursor.getString(1);// get food name
            String description = cursor.getString(2);// get food description
            double price = cursor.getDouble(3);// get price
            int resImg = cursor.getInt(4);// get resource of image
            int foodId = cursor.getInt(5);// get food id
            int qty = cursor.getInt(6); //
            Food current = new Food(name, description, price, resImg, foodId, qty); //create new list_item instance

            foods[i] = current; //place new list_item in the array
        }
        return foods;
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
        menu.findItem(R.id.action_food).setVisible(false);
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
            case R.id.action_beer:
                Intent b = new Intent(this, BeerListActivity.class);
                startActivity(b);
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
