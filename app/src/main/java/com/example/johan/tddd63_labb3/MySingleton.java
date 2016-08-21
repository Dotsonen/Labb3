package com.example.johan.tddd63_labb3;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Johan on 2016-08-18.
 */
public class MySingleton {

    private static Context mContext;
    private static MySingleton mMySingleton;
    private RequestQueue mRequestQueue;

    private MySingleton(Context context){

        mContext = context;
        mRequestQueue = getRequestQueue();
    }



    public static synchronized MySingleton getInstance(Context context) {
        if (mMySingleton == null) {
            mMySingleton = new MySingleton(context);
        }
        return mMySingleton;
    }


    public RequestQueue getRequestQueue(){

        if(mRequestQueue == null){

            mRequestQueue =  Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
