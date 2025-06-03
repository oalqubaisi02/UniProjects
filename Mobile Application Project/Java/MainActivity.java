package com.example.project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AddBtn(View v){
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }
    public void CalculateBtn(View v){
        Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
        startActivity(intent);
    }
    public void DeleteBtn(View v){
        Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
        startActivity(intent);
    }
}