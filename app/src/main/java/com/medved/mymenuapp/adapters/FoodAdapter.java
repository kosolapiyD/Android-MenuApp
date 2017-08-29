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

import com.medved.mymenuapp.Food;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;

/**
 * Created by Dima on 29-Jun-17.
 */

public class FoodAdapter extends BaseAdapter {

    private Activity activity;
    private Food[] foods;

    public FoodAdapter(Food[] foods, Activity activity) {
        this.activity = activity;
        this.foods = foods;
    }

    @Override
    public int getCount() {
        return foods.length;
    }

    @Override
    public Object getItem(int i) {
        return foods[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View foodView, ViewGroup viewGroup) {
        if (foodView == null)
            foodView = activity.getLayoutInflater().inflate(R.layout.list_item, null);
        //set the handler to save the checked value of the check box
        CheckBox listCheckBox = (CheckBox) foodView.findViewById(R.id.itemCheckbox);
        listCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                foods[i].setChecked(isChecked);
                if (isChecked) OrderActivity.addFood(foods[i]);
//                Toast.makeText(activity,"Added " + foods[i].getName() + " food",Toast.LENGTH_SHORT ).show();
//                else OrderActivity.removeFood(foods[i]);
            }
        });
        ((ImageView) foodView.findViewById(R.id.itemImg)).setImageResource(foods[i].getImageResourceId());
        ((TextView) foodView.findViewById(R.id.itemName)).setText(foods[i].getName());
        ((TextView) foodView.findViewById(R.id.itemDescription)).setText(foods[i].getDescription());
        ((TextView) foodView.findViewById(R.id.itemPrice)).setText("Price -  " + foods[i].getPrice() + " $");
        ((CheckBox) foodView.findViewById(R.id.itemCheckbox)).setChecked(foods[i].isChecked());
        foodView.setBackgroundColor(Color.argb(200, 0, 0, 0));
        return foodView;

    }
}
