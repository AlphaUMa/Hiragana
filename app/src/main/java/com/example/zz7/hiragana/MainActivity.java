package com.example.zz7.hiragana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent k = new Intent(MainActivity.this, PracticeActivity.class);
                startActivity(k);

            }
        });

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, TestActivity.class);
                startActivity(k);
            }
        });

    }
}
