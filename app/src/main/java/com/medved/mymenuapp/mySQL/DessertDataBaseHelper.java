package com.medved.mymenuapp.mySQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.medved.mymenuapp.R;

/**
 * Created by Dima on 29-Jun-17.
 */

public class DessertDataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_dessert";
    public static int DB_VERSION = 1;

    public DessertDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE DESSERT (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "PRICE INTEGER, "
                    + "IMAGE_RESOURCE_ID INTEGER, "
                    + "DESSERT_ID INTEGER, "
                    + "QUANTITY INTEGER);");
            insertDessert(db, "Baked Churros", "\"Oven baked Churros dusted with cinnamon and served with a chocolate sauce\"", 27, R.drawable.ds_baked_churros, 1, 1);
            insertDessert(db, "Fudge Brownies", "\"Delicious belgian chocolate brownies with a decadent chocolate sauce\"", 36, R.drawable.ds_belgian_choc_fudge_brownies, 2, 1);
            insertDessert(db, "Chocolate Mousse", "\"Rich creamy belgian chocolate mousse with gooey, salted caramel sauce\"", 40, R.drawable.ds_caramel_chocolate_mousse, 3, 1);
            insertDessert(db, "Chunky Cookie", "\"Made with dark chocolate fudge cake mix chocolate full of nuts and mounds\"", 32, R.drawable.ds_chunky_choc_cookie, 4, 1);
            insertDessert(db, "Dessert Pack", "\"12 mini dutch pancakes, 10 donut bites & 3 brownies with chocolate\"", 38, R.drawable.ds_dessert_pack, 5, 1);
            insertDessert(db, "Mini Dutch Pancakes", "\"Pack of mini dutch pancakes, dusted with icing sugar\"", 27, R.drawable.ds_mini_dutch_pancakes, 6, 1);
        }

        if (oldVersion < 2) {
            // in case if DB_VERSION = 1 is already installed
//            db.execSQL("ALTER TABLE DESSERT ADD COLUMN ORDER NUMERIC;");
        }
    }

    private static void insertDessert(SQLiteDatabase db, String name, String description, int price, int resourceId, int dessertId, int qty) {
        ContentValues dessertValues = new ContentValues();
        dessertValues.put("NAME", name);
        dessertValues.put("DESCRIPTION", description);
        dessertValues.put("PRICE", price);
        dessertValues.put("IMAGE_RESOURCE_ID", resourceId);
        dessertValues.put("DESSERT_ID", dessertId);
        dessertValues.put("QUANTITY", qty);
        db.insert("DESSERT", null, dessertValues);
    }
}
