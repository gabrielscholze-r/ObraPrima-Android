package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.meuapp.data.Database;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Database.loadDatabase();

        setContentView(R.layout.activity_main);

    }
}
