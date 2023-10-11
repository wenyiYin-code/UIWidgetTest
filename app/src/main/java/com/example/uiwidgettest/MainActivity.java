package com.example.uiwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ImageView imageView;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button) {
            String inputText = editText.getText().toString();
            Log.d(TAG, "inputText:" + inputText);
            if(inputText.equals("img_1")) {
                imageView.setImageResource(R.drawable.img_1);
            }
            if(inputText.equals("img_2")){
                imageView.setImageResource(R.drawable.img_2);
            }
            Toast.makeText(MainActivity.this, inputText,
                    Toast.LENGTH_SHORT).show();
        }
    }

}