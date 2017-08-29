package com.medved.mymenuapp.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.medved.mymenuapp.Coffee;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;

/**
 * Created by Dima on 29-Jun-17.
 */

public class CoffeeAdapter extends BaseAdapter {
    private Activity activity;
    private Coffee[] coffee;

    public CoffeeAdapter(Coffee[] coffee, Activity activity) {
        this.activity = activity;
        this.coffee = coffee;
    }

    @Override
    public int getCount() {
        return coffee.length;
    }

    @Override
    public Object getItem(int i) {
        return coffee[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View coffeeView, ViewGroup viewGroup) {
        if (coffeeView == null)
            coffeeView = activity.getLayoutInflater().inflate(R.layout.list_item, null);
        //set the handler to save the checked value of the check box
        CheckBox listCheckBox = (CheckBox) coffeeView.findViewById(R.id.itemCheckbox);
        listCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                coffee[i].setChecked(isChecked);
                if (isChecked) OrderActivity.addCoffee(coffee[i]);
//                Toast.makeText(activity,"Added " + coffee[i].getName() + " coffee",Toast.LENGTH_SHORT ).show();
//                else OrderActivity.removeCoffee(coffee[i]);
            }
        });
        ((CheckBox) coffeeView.findViewById(R.id.itemCheckbox)).setChecked(coffee[i].isChecked());
        ((ImageView) coffeeView.findViewById(R.id.itemImg)).setImageResource(coffee[i].getImageResourceId());
        ((TextView) coffeeView.findViewById(R.id.itemName)).setText(coffee[i].getName());
        ((TextView) coffeeView.findViewById(R.id.itemDescription)).setText(coffee[i].getDescription());
        ((TextView) coffeeView.findViewById(R.id.itemPrice)).setText("Price - " + coffee[i].getPrice() + " $");
        coffeeView.setBackgroundColor(Color.argb(200, 0, 0, 0));
        return coffeeView;
    }
}

