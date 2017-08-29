package com.medved.mymenuapp;

/**
 * Created by Dima on 27-Jun-17.
 */

public class Food implements InterfaceItem {

    private String name;
    private String description;
    private double price;
    private int imageResourceId;
    private boolean checked;
    private int foodId;
    private int quantity;

    public Food(String name, String description, double price, int imageResourceId, int foodId, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.foodId = foodId;
        this.quantity = quantity;
    }

//    public static Food[] foods = {
//            new Food("Bruschetta", "\"Toasted brown bread with cherry tomatoes & balsamic caramelized onions\"", 67, R.drawable.dsh_bruschetta, 1, 1),
//            new Food("Butternut Squash Soup", "\"A rich blend of butternut squash broth with honey and yogurt\"", 78, R.drawable.dsh_butternut_squash_soup, 2, 1),
//            new Food("Coconut Shrimp", "\"A quick shrimp stew cooked in a tomato coconut broth with lime and garlic Aioli\"", 80, R.drawable.dsh_coconut_shrimp, 3, 1),
//            new Food("Millstone Fillet", "\"Grilled center cut fillet mignon served with port wine reduction sauce\"", 92, R.drawable.dsh_millstone_fillet, 4, 1),
//            new Food("Phyllo Bouchée", "\"Puff pastry filled with brie and cranberry chutney\"", 78, R.drawable.dsh_phyllo_bouchee, 5, 1),
//            new Food("Rack of Lamb", "\"French cut rack of lamb with Dijon mustard, rosemary, & served with Marsala sauce\"", 97, R.drawable.dsh_rack_of_lamb, 6, 1),
//            new Food("Salmon Roll", "\"Smoked salmon with cream cheese in a cucumber cup\"", 85, R.drawable.dsh_salmon_roll, 7, 1),
//            new Food("Sliced Duck Fillet", "\"Slow roasted duck with fragrantly sweet fig sauce\"", 89, R.drawable.dsh_sliced_duck_fillet, 8, 1),
//            new Food("Upturned Fillet", "\"Long beef undercut with Bearnaise sauce served with chili pepper\"", 95, R.drawable.dsh_upturned_fillet, 9, 1),
//    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


//    public static Food[] getFoods() {
//        return foods;
//    }
}
