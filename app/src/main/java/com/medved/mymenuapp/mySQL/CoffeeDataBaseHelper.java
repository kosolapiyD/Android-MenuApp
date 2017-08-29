package com.medved.mymenuapp.mySQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.medved.mymenuapp.R;

/**
 * Created by Dima on 29-Jun-17.
 */

public class CoffeeDataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_coffee";
    public static int DB_VERSION = 1;

    public CoffeeDataBaseHelper(Context context) {
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
            db.execSQL("CREATE TABLE COFFEE (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "PRICE INTEGER, "
                    + "IMAGE_RESOURCE_ID INTEGER, "
                    + "COFFEE_ID INTEGER, "
                    + "QUANTITY INTEGER);");
            insertCoffee(db, "Americano", "A shot or two of espresso with hot water added", 10, R.drawable.co_americano, 1, 1);
            insertCoffee(db, "Breve", "Espresso with steamed half and half", 9, R.drawable.co_breve, 2, 1);
            insertCoffee(db, "Café au Lait", "Half coffee with half steamed milk", 7, R.drawable.co_breve, 3, 1);
            insertCoffee(db, "Cappuccino", "Espresso with a little bit of steamed milk topped with a lot of foam", 7, R.drawable.co_cappuccino, 4, 1);
            insertCoffee(db, "Espresso", "Coffee brewed by forcing a small amount of nearly boiling water under pressure through finely ground beans.", 6, R.drawable.co_espresso, 5, 1);
            insertCoffee(db, "Latte", "Espresso with steamed milk and little to no foam", 5, R.drawable.co_latte, 6, 1);
            insertCoffee(db, "Macchiato", "Double shot of espresso with foam on top", 7, R.drawable.co_macchiato, 7, 1);
            insertCoffee(db, "Mocha", "Espresso with steamed milk and chocolate (you can add whipped cream as well!)", 8, R.drawable.co_macchiato, 8, 1);

        }
        if (oldVersion < 2) {
//         in case if DB_VERSION = 1 is already installed
//            db.execSQL("ALTER TABLE COFFEE ADD COLUMN ORDER NUMERIC;");
        }
    }

    private static void insertCoffee(SQLiteDatabase db, String name, String description, int price, int resourceId, int coffeeId, int qty) {
        ContentValues coffeeValues = new ContentValues();
        coffeeValues.put("NAME", name);
        coffeeValues.put("DESCRIPTION", description);
        coffeeValues.put("PRICE", price);
        coffeeValues.put("IMAGE_RESOURCE_ID", resourceId);
        coffeeValues.put("COFFEE_ID", coffeeId);
        coffeeValues.put("QUANTITY", qty);
        db.insert("COFFEE", null, coffeeValues);
    }
}
