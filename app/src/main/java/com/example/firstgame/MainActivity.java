package com.example.firstgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button start;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startGame);
        start.setOnClickListener(v -> {
            intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });
    }
}
