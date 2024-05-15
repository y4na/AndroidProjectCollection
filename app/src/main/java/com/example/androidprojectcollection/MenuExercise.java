package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransforming);
        btnChanger.setBackground(getResources().getDrawable(R.drawable.me_roundbtn));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mItemChange:
                return true;
            case R.id.mItemReset:
                resetButton();
                return true;
            case R.id.mItemExit:
                finish();
                return true;
            case R.id.btnChangeBG:
                btnChanger.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.btnChangeColor:
                btnChanger.setTextColor(Color.BLACK);
                return true;
            case R.id.btnChangeText:
                btnChanger.setText("HELLO");
                return true;
            case R.id.btnDisappearText:
                btnChanger.setText("");
                return true;
            case R.id.btnDisappear:
                btnChanger.setVisibility(View.GONE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void resetButton() {
        btnChanger.setBackground(getResources().getDrawable(R.drawable.me_roundbtn));
        btnChanger.setText("BUTTON");
        btnChanger.setVisibility(Button.VISIBLE);
    }
}