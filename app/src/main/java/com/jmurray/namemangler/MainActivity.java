package com.jmurray.namemangler;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private String msgOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.mangel);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mEditText = (EditText) findViewById(R.id.name_input);
                msgOut = mEditText.getText().toString();

                if(msgOut.isEmpty()) {
                    Resources errorRes = getResources();
                    msgOut = errorRes.getString(R.string.input_error);

                    Toast toast = Toast.makeText(getApplicationContext(), msgOut, Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent intent = new Intent(this, Mangel.class);
                    intent.putExtra(EXTRA_MESSAGE, msgOut);
                    startActivity(intent);
                }
            }
        });
    }
}