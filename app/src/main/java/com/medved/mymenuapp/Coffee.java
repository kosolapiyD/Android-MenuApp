package com.medved.mymenuapp;

/**
 * Created by Dima on 27-Jun-17.
 */

public class Coffee implements InterfaceItem {

    private String name;
    private String description;
    private double price;
    private int imageResourceId;
    private boolean checked;
    private int coffeeId;
    private int quantity;

    public Coffee(String name, String description, double price, int imageResourceId, int coffeeId, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.coffeeId = coffeeId;
        this.quantity = quantity;
    }

//    public static Coffee[] coffee = {
//            new Coffee("Americano", "\"A shot or two of espresso with hot water added\"", 10, R.drawable.co_americano, 1, 1),
//            new Coffee("Breve", "\"Espresso with steamed half and half\"", 9, R.drawable.co_breve, 2, 1),
//            new Coffee("Café au Lait", "\"Half coffee with half steamed milk\"", 7, R.drawable.co_breve, 3, 1),
//            new Coffee("Cappuccino", "\"Espresso with a little bit of steamed milk topped with a lot of foam\"", 7, R.drawable.co_cappuccino, 4, 1),
//            new Coffee("Espresso", "\"Coffee brewed by forcing a small amount of nearly boiling water under pressure through finely ground beans\"", 6, R.drawable.co_espresso, 5, 1),
//            new Coffee("Latte", "\"Espresso with steamed milk and little to no foam\"", 5, R.drawable.co_latte, 6, 1),
//            new Coffee("Macchiato", "\"Double shot of espresso with foam on top\"", 7, R.drawable.co_macchiato, 7, 1),
//            new Coffee("Mocha", "Espresso with steamed milk and chocolate (you can add whipped cream as well!)", 8, R.drawable.co_macchiato, 8, 1),
//    };

    public String getName() {
        return name;
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

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public static Coffee[] getCoffee() {
//        return coffee;
//    }
}
