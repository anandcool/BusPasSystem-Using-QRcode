package com.example.anand.buspasssystem;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

public class GridAdapter extends BaseAdapter {
    private String text[];
    private String id[];
    private CheckBox checkBoxes[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, String[] text, String[] id){
        this.context = context;
        this.text = text;
        this.id = id;
        checkBoxes = new CheckBox[id.length];

    }
    @Override
    public int getCount() {
        return id.length;
    }

    @Override
    public Object getItem(int i) {
        return checkBoxes[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView = view;

        if(view == null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_layout,null);

        }

        checkBoxes[i] = (CheckBox) gridView.findViewById(R.id.mychkbox);

        //n=not available
        if (text[i].equals("n")) {
            checkBoxes[i].setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                checkBoxes[i].setButtonDrawable(ContextCompat.getDrawable(context,R.drawable.hseat_unavailable));
            }
            //seat.setButtonDrawable(R.drawable.seat_unavailable);
            checkBoxes[i].setHighlightColor(Color.GRAY);
        }

        return gridView;
    }
}
