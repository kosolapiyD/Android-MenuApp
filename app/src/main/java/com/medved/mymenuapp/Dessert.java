package com.medved.mymenuapp;

/**
 * Created by Dima on 27-Jun-17.
 */

public class Dessert implements InterfaceItem {

    private String name;
    private String description;
    private double price;
    private int imageResourceId;
    private boolean checked;
    private int dessertId;
    private int quantity;

    public Dessert(String name, String description, double price, int imageResourceId, int dessertId, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.dessertId = dessertId;
        this.quantity = quantity;
    }

//    public static Dessert[] desserts = {
//            new Dessert("Baked Churros","\"Oven baked Churros dusted with cinnamon sugar and served with a chocolate sauce\"",27,R.drawable.ds_baked_churros,1,1),
//            new Dessert("Fudge Brownies","\"Delicious belgian chocolate brownies with a decadent chocolate sauce, served hot\"",36,R.drawable.ds_belgian_choc_fudge_brownies,2,1),
//            new Dessert("Chocolate Mousse","\"Rich creamy belgian chocolate mousse with gooey, salted caramel sauce\"",40,R.drawable.ds_caramel_chocolate_mousse,3,1),
//            new Dessert("Chunky Cookie","\"Made with dark chocolate fudge cake mix chocolate full of nuts and mounds\"",32,R.drawable.ds_chunky_choc_cookie, 4,1),
//            new Dessert("Dessert Pack","\"12 mini dutch pancakes, 10 donut bites & 3 brownies with chocolate sauce\"",38,R.drawable.ds_dessert_pack, 5,1),
//            new Dessert("Mini Dutch Pancakes","\"Pack of mini dutch pancakes, dusted with icing sugar\"",27,R.drawable.ds_mini_dutch_pancakes, 6,1),
//    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getDessertId() {
        return dessertId;
    }

    public void setDessertId(int dessertId) {
        this.dessertId = dessertId;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public static Dessert[] getDesserts() {
//        return desserts;
//    }
}
