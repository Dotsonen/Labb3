package com.example.johan.tddd63_labb3;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Johan on 2016-08-17.
 */
public class InteractiveSearcher extends LinearLayout {

    private EditText searchBox;
    private ExpandableListView expandableListView;

    public String baseURL = " http://flask-afteach.rhcloud.com/getnames";
    public String finalURL;
    private int request_id = 0;

    private JSONObject jsonObject;

    private JSONArray nameList;

    private final int numberOfAlternetives = 7;

    private String[] finalNameList = new String[numberOfAlternetives];

    private ArrayList<String> finalArrayList = new ArrayList<>();

    private PopUp popUp;



    public InteractiveSearcher(final Context context, AttributeSet attributeSet) {
        super(context);

        ((Activity)context).getLayoutInflater().inflate(R.layout.interactive_searcher_layout,this);

        searchBox = (EditText) findViewById(R.id.editText);

        popUp = new PopUp(context, attributeSet);

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                MainActivity.getMyAdapter().clear();

                finalURL = baseURL + "/" + request_id + "/" + editable.toString();

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, finalURL, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                jsonObject = response;

                                try {
                                    nameList = response.getJSONArray("result");

                                    for(int i = 0; i < Math.min(numberOfAlternetives, nameList.length()); i++){
                                        finalArrayList.add(i, nameList.getString(i));
                                        System.out.println(nameList.getString(i));

                                        MainActivity.getMyAdapter().add(nameList.getString(i));
                                    }

                                    popUp.setArrList(finalArrayList);
                                   // Toast.makeText(context, finalNameList[0], Toast.LENGTH_SHORT).show();


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        });

                MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);


            }
        });


    }
}
