package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements Runnable {

    Button mButton;
    ProgressBar mProgressBar;
    int mProgress = 50;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        mProgressBar = findViewById(R.id.progress_circular);
        mButton = findViewById(R.id.button_do);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress = 50;
                mHandler.postDelayed(MainActivity.this, 20);
            }
        });
    }

    @Override
    public void run() {
        mProgress--;
        mProgressBar.setProgress(mProgress);
        if (mProgress>0) {
            mHandler.postDelayed(this, 20);
        }
    }
}
