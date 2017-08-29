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

import com.medved.mymenuapp.Beer;
import com.medved.mymenuapp.OrderActivity;
import com.medved.mymenuapp.R;

/**
 * Created by Dima on 27-Jun-17.
 */

public class BeerAdapter extends BaseAdapter {
    private Activity activity;
    private Beer[] beers;

//    private InterfaceItem[] beers;

    public BeerAdapter(Beer[] beers, Activity activity) {
        this.activity = activity;
        this.beers = beers;
    }

    @Override
    public int getCount() {
        return beers.length;
    }

    @Override
    public Object getItem(int i) {
        return beers[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View beerView, ViewGroup viewGroup) {
        if (beerView == null)
            beerView = activity.getLayoutInflater().inflate(R.layout.list_item, null);
        //set the handler to save the checked value of the check box
        CheckBox listCheckBox = (CheckBox) beerView.findViewById(R.id.itemCheckbox);
        listCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                beers[i].setChecked(isChecked);
                if (isChecked) OrderActivity.addBeer(beers[i]);
//                else OrderActivity.removeBeer(beers[i]);
            }
        });
        ((CheckBox) beerView.findViewById(R.id.itemCheckbox)).setChecked(beers[i].isChecked());
        ((ImageView) beerView.findViewById(R.id.itemImg)).setImageResource(beers[i].getImageResourceId());
        ((TextView) beerView.findViewById(R.id.itemName)).setText(beers[i].getName());
        ((TextView) beerView.findViewById(R.id.itemDescription)).setText(beers[i].getDescription());
        ((TextView) beerView.findViewById(R.id.itemPrice)).setText("Price - " + beers[i].getPrice() + " $");
        beerView.setBackgroundColor(Color.argb(200, 0, 0, 0));
        return beerView;
    }
}
