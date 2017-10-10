package com.jmurray.namemangler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Mangel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangel);

        Intent intent = getIntent();
        String msgOut = intent.getSringExtra(MainActivity.EXTRA_MESSAGE);

        Toast toast = Toast.makeText(getApplicationContext(), msgOut, Toast.LENGTH_SHORT);
        toast.show();
    }
}
