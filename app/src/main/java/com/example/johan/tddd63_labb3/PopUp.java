package com.example.johan.tddd63_labb3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Johan on 2016-08-17.
 */
public class PopUp extends View {

    Paint paint, paint2;
    private ArrayList<String> nameList = new ArrayList<>();

    public PopUp(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.RED);

        paint2 = new Paint();
        paint2.setColor(Color.BLACK);

    }


    @Override
    public void onDraw (Canvas canvas){

        Toast.makeText(getContext(), "hej", Toast.LENGTH_SHORT).show();

        canvas.drawRect(0,0,getWidth(),getHeight(),paint2);

        float test = getHeight();

        paint.setTextSize(test);

        if(nameList.size() != 0){
            System.out.println("Det ska ju funka");
        }

        if(!isNameListEmpty()) {
            Toast.makeText(getContext(), "Skirv", Toast.LENGTH_SHORT).show();
            canvas.drawText(nameList.get(0), 0, getHeight(), paint);

        }


    }

    @Override
    public void onMeasure(int width, int height){

        setMeasuredDimension(width, height);
    }

    public void setArrList(ArrayList<String> arg){

        nameList = arg;

        System.out.println("HALLÅ " + nameList.get(0));

        this.invalidate();
    }

    public boolean isNameListEmpty(){
        if(nameList.size() == 0){
            System.out.println("True");
            return true;
        }
        System.out.println("False");

        return false;

    }
}
