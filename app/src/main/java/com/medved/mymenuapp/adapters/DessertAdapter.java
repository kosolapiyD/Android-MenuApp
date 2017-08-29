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

import com.medved.mymenuapp.Dessert;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;

/**
 * Created by Dima on 29-Jun-17.
 */

public class DessertAdapter extends BaseAdapter {

    private Activity activity;
    private Dessert[] desserts;

    public DessertAdapter(Dessert[] desserts, Activity activity) {
        this.activity = activity;
        this.desserts = desserts;
    }

    @Override
    public int getCount() {
        return desserts.length;
    }

    @Override
    public Object getItem(int i) {
        return desserts[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View dessertView, ViewGroup viewGroup) {
        if (dessertView == null)
            dessertView = activity.getLayoutInflater().inflate(R.layout.list_item, null);
        //set the handler to save the checked value of the check box
        CheckBox listCheckBox = (CheckBox) dessertView.findViewById(R.id.itemCheckbox);
        listCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                desserts[i].setChecked(isChecked);
                if (isChecked) OrderActivity.addDessert(desserts[i]);
            }
        });
        ((CheckBox) dessertView.findViewById(R.id.itemCheckbox)).setChecked(desserts[i].isChecked());
        ((ImageView) dessertView.findViewById(R.id.itemImg)).setImageResource(desserts[i].getImageResourceId());
        ((TextView) dessertView.findViewById(R.id.itemName)).setText(desserts[i].getName());
        ((TextView) dessertView.findViewById(R.id.itemDescription)).setText(desserts[i].getDescription());
        ((TextView) dessertView.findViewById(R.id.itemPrice)).setText("Price - " + desserts[i].getPrice() + " $");
        dessertView.setBackgroundColor(Color.argb(200, 0, 0, 0));
        return dessertView;
    }
}
