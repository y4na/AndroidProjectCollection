package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1; Button btn2; Button btn3; Button btn4; Button btn5; Button btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayout);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class); //this Class & destination Class
                startActivity(intent1);

            }
        });

        btn2 = (Button) findViewById(R.id.btnButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ButtonExercise.class); //this Class & destination Class
                startActivity(intent2);

            }
        });

        btn3 = (Button) findViewById(R.id.btnCalculator);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, CalculatorExercise.class); //this Class & destination Class
                startActivity(intent3);

            }
        });
        btn4 = (Button) findViewById(R.id.btnMatch3);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, Match3.class); //this Class & destination Class
                startActivity(intent4);

            }
        });
        btn5 = (Button) findViewById(R.id.btnPassing);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, PassingIntentsExercise.class); //this Class & destination Class
                startActivity(intent5);

            }
        });

        btn6 = (Button) findViewById(R.id.btnMenus);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, MenuExercise.class); //this Class & destination Class
                startActivity(intent5);

            }
        });
    }
}