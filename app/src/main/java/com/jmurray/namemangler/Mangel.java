package com.jmurray.namemangler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Mangel extends AppCompatActivity {

    private  Name[]mNames = new Name[] {//i had to look this up in book
            new Name(R.string.mag_name, false),
            new Name(R.string.stu_name, false),
    };

    private int mCurrentIndex = 0;
    private TextView mNameTextView;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangel);

        mCurrentIndex = rand.nextInt((mNames.length)-0);
        while(mNames[mCurrentIndex].isNameUsed()){
            mCurrentIndex = rand.nextInt((mNames.length)-0);
        }

        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(mCurrentIndex), Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = getIntent();
        String msgOut = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mNameTextView = (TextView) findViewById(R.id.mangeledName);//looked this up too
        int name = mNames[mCurrentIndex].getNameId();
        mNames[mCurrentIndex].setNameUsed(true);
        mNameTextView.setText(name);
    }
}