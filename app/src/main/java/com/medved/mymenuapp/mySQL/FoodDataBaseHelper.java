package com.medved.mymenuapp.mySQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.medved.mymenuapp.R;

/**
 * Created by Dima on 29-Jun-17.
 */

public class FoodDataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_food";
    public static int DB_VERSION = 1;

    public FoodDataBaseHelper(Context context) {
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
            db.execSQL("CREATE TABLE FOOD (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "PRICE INTEGER, "
                    + "IMAGE_RESOURCE_ID INTEGER, "
                    + "FOOD_ID INTEGER, "
                    + "QUANTITY INTEGER);");
            insertFood(db, "Bruschetta", "\"Toasted brown bread with cherry tomatoes & balsamic caramelized onions\"", 67, R.drawable.dsh_bruschetta, 1, 1);
            insertFood(db, "Butternut Squash Soup", "\"A rich blend of butternut squash broth with honey and yogurt\"", 78, R.drawable.dsh_butternut_squash_soup, 2, 1);
            insertFood(db, "Coconut Shrimp", "\"A quick shrimp stew cooked in a tomato coconut broth with lime and garlic Aioli\"", 80, R.drawable.dsh_coconut_shrimp, 3, 1);
            insertFood(db, "Millstone Fillet", "\"Grilled center cut fillet mignon served with port wine reduction sauce\"", 92, R.drawable.dsh_millstone_fillet, 4, 1);
            insertFood(db, "Phyllo Bouchée", "\"Puff pastry filled with brie and cranberry chutney\"", 78, R.drawable.dsh_phyllo_bouchee, 5, 1);
            insertFood(db, "Rack of Lamb", "\"French cut rack of lamb with Dijon mustard, rosemary, & served with Marsala sauce\"", 97, R.drawable.dsh_rack_of_lamb, 6, 1);
            insertFood(db, "Salmon Roll", "\"Smoked salmon with cream cheese in a cucumber cup\"", 85, R.drawable.dsh_salmon_roll, 7, 1);
            insertFood(db, "Sliced Duck Fillet", "\"Slow roasted duck with fragrantly sweet fig sauce\"", 89, R.drawable.dsh_sliced_duck_fillet, 8, 1);
            insertFood(db, "Upturned Fillet", "\"Long beef undercut with Bearnaise sauce served with chili pepper\"", 95, R.drawable.dsh_upturned_fillet, 9, 1);

        }
        if (oldVersion < 2) {
//             in case if DB_VERSION = 1 is already installed
        }
    }

    private static void insertFood(SQLiteDatabase db, String name, String description, int price, int imgResourceId, int foodId, int qty) {
        ContentValues foodValues = new ContentValues();
        foodValues.put("NAME", name);
        foodValues.put("DESCRIPTION", description);
        foodValues.put("PRICE", price);
        foodValues.put("IMAGE_RESOURCE_ID", imgResourceId);
        foodValues.put("FOOD_ID", foodId);
        foodValues.put("QUANTITY", qty);
        db.insert("FOOD", null, foodValues);
    }
}
