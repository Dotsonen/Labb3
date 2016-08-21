package com.example.johan.tddd63_labb3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Johan on 2016-08-18.
 */
public class MyAdapter extends BaseExpandableListAdapter {


    String[] data;
    Context context;

    public MyAdapter(String[] data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return data.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return data[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layoutInflater.inflate(R.layout.row, viewGroup, false);

        }

 //       TextView tv = (TextView) view.findViewById(R.id.nameView);
  //      tv.setText("Hej");




        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
