package com.example.johan.tddd63_labb3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static MyAdapter myAdapter;
    public static ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        PopUp popUp = (PopUp) findViewById(R.id.popUp);


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

        String[] test = {"Hej", "YE"};

        arrayAdapter.add("Hej");

        listView.setAdapter(arrayAdapter);



    }

    public static ArrayAdapter getMyAdapter(){
        return arrayAdapter;
    }
}
