package com.jmurray.namemangler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mangel extends AppCompatActivity {

    private TextView mNameTextView;
    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangel);
        mNameTextView = (TextView) findViewById(R.id.mangeledName);//looked this up too
        Name name = new Name();
        Intent intent = getIntent();

        if(savedInstanceState != null) {
            mNameTextView.setText(savedInstanceState.getString(EXTRA_NAME));
        }
        else {
            mNameTextView.setText(name.getMangled(intent.getStringExtra(MainActivity.EXTRA_MESSAGE)));
        }

        final Button reMangel = (Button) findViewById(R.id.re_mangel);
        reMangel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Name name = new Name();
                Intent intent = getIntent();
                mNameTextView.setText(name.getMangled(intent.getStringExtra(MainActivity.EXTRA_MESSAGE)));
            }
        });

        final Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();//go back to main activity
            }
        });
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String nameEntered = mNameTextView.getText().toString();
        savedInstanceState.putString(EXTRA_NAME, nameEntered);
    }
}