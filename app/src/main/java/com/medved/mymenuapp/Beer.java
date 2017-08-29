package com.medved.mymenuapp;

/**
 * Created by Dima on 27-Jun-17.
 */

public class Beer implements InterfaceItem {

    private String name;
    private String description;
    private double price;
    private int imageResourceId;
    private boolean checked;
    private int beerId;
    private int quantity;

    public Beer(String name, String description, double price, int imageResourceId, int beerId, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.beerId = beerId;
        this.quantity = quantity;
    }

//    public static Beer[] beers = {
//            new Beer("Heritage Coffee \nBrown Beer", "Alaskan Brewing Co.\nEnglish-style Ale with Coffee", 10, R.drawable.br_heritage, 1, 1),
//            new Beer("Twenty Two Beer", "Avery Brewing Co.\nDry-hopped Wild Ale", 9, R.drawable.br_twenty_two, 2, 1),
//            new Beer("Calm Before the \nStorm Beer", "Ballast Point Brewing Co. \nCoffee Vanilla Cream Ale", 7, R.drawable.br_calm, 3, 1),
//            new Beer("Rye Like an \nEagle Beer", "Beachwood BBQ & Brewing \nRye Whiskey Barrel Brown", 7, R.drawable.br_rye, 4, 1),
//            new Beer("Lunch Break Beer", "Breakside Brewery\nSession IPA", 6, R.drawable.br_lunch, 5, 1),
//            new Beer("Sans Pagie Beer", "Bruery Terreux\nWild Specialty Beer", 5, R.drawable.br_sans, 6, 1),
//            new Beer("Senor Saison Beer", "Coronado Brewing Co.\nChili Saison", 7, R.drawable.br_senor, 7, 1),
//            new Beer("The Broken \nTruck Beer", "de Garde Brewing \nWild Specialty Beer", 8, R.drawable.br_the_broken, 8, 1),
//            new Beer("Black Butte-3 Beer", "Deschutes Brewery \nWhiskey Barrel Imperial Porter", 9, R.drawable.br_deschutes, 9, 1),
//            new Beer("Jolly Rodger Beer", "Drake’s Brewing Co. \nImperial Coffee Stout", 10, R.drawable.br_jolly, 10, 1),
//            new Beer("Carolina Custard Beer", "Fonta Flora\nWild Specialty Beer", 8, R.drawable.br_carolina, 11, 1),
//            new Beer("21st-Anniversary Beer", "Great Divide Brewery\nWild Specialty Beer", 7, R.drawable.br_anniversary, 12, 1),
//            new Beer("Braggot Rights Beer", "Harpoon Brewery\nBraggot", 7, R.drawable.br_braggot, 13, 1),
//            new Beer("Gin Barrel Aged \nJoon Beer", "MadTree Brewing Co.\nGin Barrel Kolsch with Spices", 6, R.drawable.br_gin, 14, 1),
//            new Beer("Steeped Emperors Beer", "Moody Tongue Brewing Co.\nTea-infused Saison", 6, R.drawable.br_steeped, 15, 1),
//            new Beer("Suburban Beverage Beer", "Perennial Artisan Ales\nFruited Gose", 6, R.drawable.br_suburban, 16, 1),
//            new Beer("Pilsner Beer", "pFriem Family Brewers\nGerman-style Pilsener", 9, R.drawable.br_pilsner, 17, 1),
//            new Beer("Summer S.M.A.S.H Beer", "Portland Brewing Co. \nAmerican Pale Ale", 9, R.drawable.br_summer, 18, 1),
//            new Beer("Supermassive Beer", "The Rare Barrel\nWild Specialty Beer", 8, R.drawable.br_supermassive, 19, 1),
//            new Beer("Mockingfish Beer", "Rising Tide Brewing Co.\nTequila Barrel Gose", 9, R.drawable.br_mockingfish, 20, 1),
//            new Beer("Hayseed Beer", "Smuttynose Brewing Co.\nGrisette", 7, R.drawable.br_hayseed, 21, 1)
//    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public static Beer[] getBeers() {
//        return beers;
//    }
}
