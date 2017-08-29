package com.medved.mymenuapp.mySQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.medved.mymenuapp.R;

/**
 * Created by Dima on 27-Jun-17.
 */

public class BeerDataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_beer";
    public static int DB_VERSION = 1;

    public BeerDataBaseHelper(Context context) {
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
            db.execSQL("CREATE TABLE BEER (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "PRICE INTEGER, "
                    + "IMAGE_RESOURCE_ID INTEGER, "
                    + "BEER_ID INTEGER, "
                    + "QUANTITY INTEGER);");
            insertBeer(db, "Heritage Coffee \nBrown Beer", "Alaskan Brewing Co.\nEnglish-style Ale with Coffee", 10, R.drawable.br_heritage, 1, 1);
            insertBeer(db, "Twenty Two Beer", "Avery Brewing Co.\nDry-hopped Wild Ale", 9, R.drawable.br_twenty_two, 2, 1);
            insertBeer(db, "Calm Before the \nStorm Beer", "Ballast Point Brewing Co. \nCoffee Vanilla Cream Ale", 7, R.drawable.br_calm, 3, 1);
            insertBeer(db, "Rye Like an \nEagle Beer", "Beachwood BBQ & Brewing \nRye Whiskey Barrel Brown", 7, R.drawable.br_rye, 4, 1);
            insertBeer(db, "Lunch Break Beer", "Breakside Brewery\nSession IPA", 6, R.drawable.br_lunch, 5, 1);
            insertBeer(db, "Sans Pagie Beer", "Bruery Terreux\nWild Specialty Beer", 5, R.drawable.br_sans, 6, 1);
            insertBeer(db, "Senor Saison Beer", "Coronado Brewing Co.\nChili Saison", 7, R.drawable.br_senor, 7, 1);
            insertBeer(db, "The Broken \nTruck Beer", "de Garde Brewing \nWild Specialty Beer", 8, R.drawable.br_the_broken, 8, 1);
            insertBeer(db, "Black Butte-3 Beer", "Deschutes Brewery \nWhiskey Barrel Imperial Porter", 9, R.drawable.br_deschutes, 9, 1);
            insertBeer(db, "Jolly Rodger Beer", "Drake’s Brewing Co. \nImperial Coffee Stout", 10, R.drawable.br_jolly, 10, 1);
            insertBeer(db, "Carolina Custard Beer", "Fonta Flora\nWild Specialty Beer", 8, R.drawable.br_carolina, 11, 1);
            insertBeer(db, "21st-Anniversary Beer", "Great Divide Brewery\nWild Specialty Beer", 7, R.drawable.br_anniversary, 12, 1);
            insertBeer(db, "Braggot Rights Beer", "Harpoon Brewery\nBraggot", 7, R.drawable.br_braggot, 13, 1);
            insertBeer(db, "Gin Barrel Aged \nJoon Beer", "MadTree Brewing Co.\nGin Barrel Kolsch with Spices", 6, R.drawable.br_gin, 14, 1);
            insertBeer(db, "Steeped Emperors Beer", "Moody Tongue Brewing Co.\nTea-infused Saison", 6, R.drawable.br_steeped, 15, 1);
            insertBeer(db, "Suburban Beverage Beer", "Perennial Artisan Ales\nFruited Gose", 6, R.drawable.br_suburban, 16, 1);
            insertBeer(db, "Pilsner Beer", "pFriem Family Brewers\nGerman-style Pilsener", 9, R.drawable.br_pilsner, 17, 1);
            insertBeer(db, "Summer S.M.A.S.H Beer", "Portland Brewing Co. \nAmerican Pale Ale", 9, R.drawable.br_summer, 18, 1);
            insertBeer(db, "Supermassive Beer", "The Rare Barrel\nWild Specialty Beer", 8, R.drawable.br_supermassive, 19, 1);
            insertBeer(db, "Mockingfish Beer", "Rising Tide Brewing Co.\nTequila Barrel Gose", 9, R.drawable.br_mockingfish, 20, 1);
            insertBeer(db, "Hayseed Beer", "Smuttynose Brewing Co.\nGrisette", 7, R.drawable.br_hayseed, 21, 1);
        }
        if (oldVersion < 2) {
//         in case if DB_VERSION = 1 is already installed
            //        db.execSQL("ALTER TABLE BEER ADD COLUMN ORDER NUMERIC;");
        }
    }

    private static void insertBeer(SQLiteDatabase db, String name, String description, int price, int resourceId, int beerId, int qty) {
        ContentValues beerValues = new ContentValues();
        beerValues.put("NAME", name);
        beerValues.put("DESCRIPTION", description);
        beerValues.put("PRICE", price);
        beerValues.put("IMAGE_RESOURCE_ID", resourceId);
        beerValues.put("BEER_ID", beerId);
        beerValues.put("QUANTITY", qty);
        db.insert("BEER", null, beerValues);
    }
}
