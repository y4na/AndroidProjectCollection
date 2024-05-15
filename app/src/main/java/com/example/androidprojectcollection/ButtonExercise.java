package com.example.androidprojectcollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonExercise extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_testing);


        Button btnDisappear;
        btnDisappear = (Button) findViewById(R.id.disBtn);
        btnDisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDisappear.setVisibility(View.INVISIBLE);
                finish();
            }
        });
        Button btnChangeButtonBG;
        final int[] btnColor = new int[]{
                Color.parseColor("#b8a64f"),
                Color.parseColor("#584fb8"),
                Color.parseColor("#844fb8"),
                Color.parseColor("#aa4fb8"),
                Color.parseColor("#b84f69"),
        };
        btnChangeButtonBG = (Button) findViewById(R.id.buttonBGbtn);
        btnChangeButtonBG.setOnClickListener(new View.OnClickListener() {
            int clicks = 0;
            @Override
            public void onClick(View view) {
                btnChangeButtonBG.setBackgroundColor(btnColor[clicks % btnColor.length]);
                clicks++;
            }
        });
        Button btnChange;
        btnChange = (Button) findViewById(R.id.changeBGbtn);
        final View layout = findViewById(R.id.layout);
        final int[] bgColor = new int[]{
                Color.parseColor("#201F24"),
                Color.parseColor("#1d1d52"),
                Color.parseColor("#612033"),
                Color.parseColor("#615620"),
                Color.parseColor("#1F074A"),
        };
        btnChange.setOnClickListener(new View.OnClickListener() {
            int clicks = 0;
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(bgColor[clicks % bgColor.length]);
                clicks++;
            }
        });
        Button btnToast;
        btnToast = (Button) findViewById(R.id.toastBtn);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonExercise.this, "Toasted Bread",
                        Toast.LENGTH_LONG).show();
            }
        });
        Button btnClose;
        btnClose = (Button) findViewById(R.id.closeBtn);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ButtonExercise.this, activity_return_button.class); //this Class & destination Class
                startActivity(intent);
            }
        });
    }

}
