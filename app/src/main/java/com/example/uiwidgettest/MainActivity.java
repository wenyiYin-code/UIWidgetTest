package com.example.uiwidgettest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.DialogPreference;
import android.preference.Preference;
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

    final int initialValue = 0;
    final int finalValue = 100;
    final int increment = 1;
    long delayMillis = 20;

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
                // 延时启动递增操作
                handler.postDelayed(incrementRunnable, delayMillis);
                imageView.setImageResource(R.drawable.img_1);
            }
            else if(inputText.equals("img_2")) {
                // 延时启动递增操作
                handler.postDelayed(incrementRunnable, delayMillis);
                imageView.setImageResource(R.drawable.img_2);
            }
            else{
                showAlertDialog();
            }
            Toast.makeText(MainActivity.this, inputText,
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 定义一个 Runnable 来递增变量
    Runnable incrementRunnable = new Runnable() {
        int value = initialValue;

        @Override
        public void run() {
            if (value <= finalValue) {
                //设置进度条为可见属性
                progressBar.setVisibility(View.VISIBLE);
                //设置进度条进度
                progressBar.setProgress(value);
                // 递增变量
                value += increment;
                // 再次延时
                handler.postDelayed(this, delayMillis);
            } else {
                // 变量达到最终值后，将控件设置为不可见
                progressBar.setVisibility(View.GONE);
                //重置value变量
                value = initialValue;
                // 取消未执行的Runnable，停止线程
                handler.removeCallbacks(this);
            }
            Log.d(TAG, "value：" + value);
        }

    };

    public void showAlertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder (MainActivity.this);
        dialog.setTitle("This is a error");
        dialog.setMessage("Something you input worn.");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });
        dialog.show();
    }

}