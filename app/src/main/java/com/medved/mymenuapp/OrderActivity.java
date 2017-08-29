package com.medved.mymenuapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.medved.mymenuapp.lists.BeerListActivity;
import com.medved.mymenuapp.lists.CoffeeListActivity;
import com.medved.mymenuapp.lists.DessertListActivity;
import com.medved.mymenuapp.lists.FoodListActivity;

public class OrderActivity extends Activity {

    ScrollView orderActivityScrollView;
    LinearLayout orderList;
    TextView totalPriceTV;
    RelativeLayout orderItemLayout;
    RelativeLayout orderActivityLayout;
    Button removeOrderItemBtn;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle(getString(R.string.order_activity_title));

        orderActivityScrollView = (ScrollView) findViewById(R.id.orderActivityScrollView);
        orderActivityScrollView.setBackgroundColor(Color.argb(950, 0, 0, 0));

        orderList = (LinearLayout) findViewById(R.id.orderList);
        totalPriceTV = (TextView) findViewById(R.id.totalPrice);
        orderItemLayout = (RelativeLayout) findViewById(R.id.orderItemLayout);
        orderActivityLayout = (RelativeLayout) findViewById(R.id.orderActivityLayout);
        confirmBtn = (Button) findViewById(R.id.confirmBtn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showOrders();

    }

    public static void addBeer(Beer beer) {
        TopLevelActivity.beers.add(beer);
    }

    public static void addFood(Food food) {
        TopLevelActivity.foods.add(food);
    }

    public static void addCoffee(Coffee coffee) {
        TopLevelActivity.coffee.add(coffee);
    }

    public static void addDessert(Dessert dessert) {
        TopLevelActivity.dessert.add(dessert);
    }

    public static void removeBeer(Beer beer) {
        TopLevelActivity.beers.remove(beer);
    }

    public static void removeFood(Food food) {
        TopLevelActivity.foods.remove(food);
    }

    public static void removeCoffee(Coffee coffee) {
        TopLevelActivity.coffee.remove(coffee);
    }

    public static void removeDessert(Dessert dessert) {
        TopLevelActivity.dessert.remove(dessert);
    }

    private void showOrders() {
//        orderList.removeAllViews();//reset history

        for (final Beer b : TopLevelActivity.beers) {
            final RelativeLayout ordersLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.order_item, null);
            ((TextView) ordersLayout.findViewById(R.id.orderItemName)).setText(b.getName());
            ((TextView) ordersLayout.findViewById(R.id.orderItemPrice)).setText("single price  -  " + b.getPrice());
            ordersLayout.findViewById(R.id.countMinusBtn).setOnClickListener(new MinusPlusListener(-1, b.getPrice(), ordersLayout, b));
            ordersLayout.findViewById(R.id.countPlusBtn).setOnClickListener(new MinusPlusListener(1, b.getPrice(), ordersLayout, b));
            removeOrderItemBtn = (Button) ordersLayout.findViewById(R.id.removeOrderItemBtn);
            removeOrderItemBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeBeer(b);
                    orderList.removeView(ordersLayout);
                    updateTotal();
                }
            });
            orderList.addView(ordersLayout);
            updatePrice(b.getQuantity(), b.getPrice(), ordersLayout);
        }
        for (final Food f : TopLevelActivity.foods) {
            final RelativeLayout ordersLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.order_item, null);
            ((TextView) ordersLayout.findViewById(R.id.orderItemName)).setText(f.getName());
            ((TextView) ordersLayout.findViewById(R.id.orderItemPrice)).setText("single price  -  " + f.getPrice());
            ordersLayout.findViewById(R.id.countMinusBtn).setOnClickListener(new MinusPlusListener(-1, f.getPrice(), ordersLayout, f));
            ordersLayout.findViewById(R.id.countPlusBtn).setOnClickListener(new MinusPlusListener(1, f.getPrice(), ordersLayout, f));
            removeOrderItemBtn = (Button) ordersLayout.findViewById(R.id.removeOrderItemBtn);
            removeOrderItemBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeFood(f);
                    orderList.removeView(ordersLayout);
                    updateTotal();
                }
            });
            orderList.addView(ordersLayout);
            updatePrice(f.getQuantity(), f.getPrice(), ordersLayout);
        }
        for (final Coffee c : TopLevelActivity.coffee) {
            final RelativeLayout ordersLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.order_item, null);
            ((TextView) ordersLayout.findViewById(R.id.orderItemName)).setText(c.getName());
            ((TextView) ordersLayout.findViewById(R.id.orderItemPrice)).setText("single price  -  " + c.getPrice());
            ordersLayout.findViewById(R.id.countMinusBtn).setOnClickListener(new MinusPlusListener(-1, c.getPrice(), ordersLayout, c));
            ordersLayout.findViewById(R.id.countPlusBtn).setOnClickListener(new MinusPlusListener(1, c.getPrice(), ordersLayout, c));
            removeOrderItemBtn = (Button) ordersLayout.findViewById(R.id.removeOrderItemBtn);
            removeOrderItemBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeCoffee(c);
                    orderList.removeView(ordersLayout);
                    updateTotal();
                }
            });
            orderList.addView(ordersLayout);
            updatePrice(c.getQuantity(), c.getPrice(), ordersLayout);
        }
        for (final Dessert d : TopLevelActivity.dessert) {
            final RelativeLayout ordersLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.order_item, null);
            ((TextView) ordersLayout.findViewById(R.id.orderItemName)).setText(d.getName());
            ((TextView) ordersLayout.findViewById(R.id.orderItemPrice)).setText("single price  -  " + d.getPrice());
            ordersLayout.findViewById(R.id.countMinusBtn).setOnClickListener(new MinusPlusListener(-1, d.getPrice(), ordersLayout, d));
            ordersLayout.findViewById(R.id.countPlusBtn).setOnClickListener(new MinusPlusListener(1, d.getPrice(), ordersLayout, d));
            removeOrderItemBtn = (Button) ordersLayout.findViewById(R.id.removeOrderItemBtn);
            removeOrderItemBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeDessert(d);
                    orderList.removeView(ordersLayout);
                    updateTotal();
                }
            });
            orderList.addView(ordersLayout);
            updatePrice(d.getQuantity(), d.getPrice(), ordersLayout);
        }
    }

    private void updatePrice(int count, double price, View ordersLayout) {
        ((TextView) ordersLayout.findViewById(R.id.orderSumTV)).setText("" + (price * count));
        ((TextView) ordersLayout.findViewById(R.id.counterTV)).setText("" + count);
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;
        for (int i = 0; i < orderList.getChildCount(); i++) {
            String sumStr = ((TextView) orderList.getChildAt(i).findViewById(R.id.orderSumTV)).getText().toString();
            total += Double.parseDouble(sumStr);//parse sumStr to double and add to total
        }
        totalPriceTV.setText("" + total);//update total price
    }

    private class MinusPlusListener implements View.OnClickListener {
        private int change;// -1 OR 1
        private double price;// price to calc
        private View ordersLayout;
        private InterfaceItem interfaceItem;

        MinusPlusListener(int change, double price, View ordersLayout, InterfaceItem iItem) {
            this.ordersLayout = ordersLayout;
            this.change = change;
            this.price = price;
            this.interfaceItem = iItem;
        }

        @Override
        public void onClick(View view) {
            TextView counterTV = (TextView) ordersLayout.findViewById(R.id.counterTV);
            int count = Integer.parseInt(counterTV.getText().toString()) + change;
            if (count > 0) {
                counterTV.setText("" + (count));
                interfaceItem.setQuantity(count);
                updatePrice(interfaceItem.getQuantity(), price, ordersLayout);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
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

    public void confirmBtn(final View view) {

        // setting simple dialog
        View orderDialog = getLayoutInflater().inflate(R.layout.order_dialog, null);
        TextView dialogTotalPriceTV = (TextView) orderDialog.findViewById(R.id.dialogTotalPriceTV);

        CharSequence total = totalPriceTV.getText();
        dialogTotalPriceTV.setText("Your total order price is: \n" + total);

        final EditText dialogCustomerNameTV = (EditText) orderDialog.findViewById(R.id.dialogCustomerNameTV);

        Button dialogSendBtn = (Button) orderDialog.findViewById(R.id.dialogSendBtn);
        Button dialogBackBtn = (Button) orderDialog.findViewById(R.id.dialogReturnBtn);

        // adding a simple spinner to choose table number
        final Spinner dialogSpinner = (Spinner) orderDialog.findViewById(R.id.dialogSpinner);
        String[] table = getResources().getStringArray(R.array.table);
        dialogSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, table));

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(orderDialog);
        dialog.setCanceledOnTouchOutside(false);

        // custom Button instead dialog PositiveButton
        dialogSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String customerName = String.valueOf(dialogCustomerNameTV.getText());
                int sp = dialogSpinner.getSelectedItemPosition();
                if (customerName.equals("") || (sp == 0)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Name and chose a table", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thank you " + customerName +
                            "\nYour table number is " + sp +
                            "\nthe waiter is on the way", Toast.LENGTH_LONG).show();
                    orderList.removeAllViews();
                    confirmBtn.setEnabled(false);
                    confirmBtn.setBackgroundColor(Color.parseColor("#A0C140"));
                    confirmBtn.setText("Sent!");

                    dialog.dismiss();
                }
            }
        });

        // custom Button instead dialog Negative Button
        dialogBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
