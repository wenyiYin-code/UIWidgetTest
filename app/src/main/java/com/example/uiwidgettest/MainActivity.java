package com.example.uiwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Handler handler = new Handler();
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button) {
            String inputText = editText.getText().toString();
            Log.d(TAG, "inputText:" + inputText);
            if(inputText.equals("img_1")) {
                progressBar.setVisibility(View.VISIBLE);
                hideProgressBar();
                imageView.setImageResource(R.drawable.img_1);
            }
            if(inputText.equals("img_2")) {
                progressBar.setVisibility(View.VISIBLE);
                hideProgressBar();
                imageView.setImageResource(R.drawable.img_2);
            }
            Toast.makeText(MainActivity.this, inputText,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void hideProgressBar(){
        long delayMillis = 2000; // 2秒
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, delayMillis);
    }

}