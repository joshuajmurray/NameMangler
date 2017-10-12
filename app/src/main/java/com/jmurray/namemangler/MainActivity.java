package com.jmurray.namemangler;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private String msgOut;
    public static final String EXTRA_MESSAGE = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.name_input);

        if(savedInstanceState != null) {
            mEditText.setText(savedInstanceState.getString(EXTRA_MESSAGE));

            Toast toast = Toast.makeText(getApplicationContext(), "retrieved: " + savedInstanceState.getString(EXTRA_MESSAGE), Toast.LENGTH_SHORT);
            toast.show();
        }

        final Button button = (Button) findViewById(R.id.mangel);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                msgOut = mEditText.getText().toString();

                if(msgOut.isEmpty()) {
                    Resources errorRes = getResources();
                    Toast toast = Toast.makeText(getApplicationContext(), errorRes.getString(R.string.input_error), Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Mangel.class);
                    intent.putExtra(EXTRA_MESSAGE, msgOut);
                    startActivity(intent);
                }
            }
        });
    }

//    protected void onResume(){
//        super.onResume();
//        mEditText = (EditText) findViewById(R.id.name_input);
//        mEditText.setText("");//this feels a little cheap to me since the back button triggers this too..
//    }//this also causes a bug with rotation and passing the saved state..

    public void onSaveInstanceState(Bundle savedInstanceState) {//had to look this up in the book
        super.onSaveInstanceState(savedInstanceState);
        mEditText = (EditText) findViewById(R.id.name_input);
        String nameEntered = mEditText.getText().toString();
        savedInstanceState.putString(EXTRA_MESSAGE, nameEntered);
    }
}