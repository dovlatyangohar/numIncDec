package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewCount;
    private int mCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewCount = findViewById(R.id.tv_counter);

        Button buttonDecrement = findViewById(R.id.decrement_btn);
        Button buttonIncrement = findViewById(R.id.increment_btn);

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count");
            mTextViewCount.setText(String.valueOf(mCount));
        }
    }

    private void decrement() {
        mCount--;
        mTextViewCount.setText(String.valueOf(mCount));
    }

    private void increment() {
        mCount++;
        mTextViewCount.setText(String.valueOf(mCount));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", mCount);
    }
}
