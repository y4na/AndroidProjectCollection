package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tFname, tLname, tGender, tBdate, tPnum, tEmail, tFname1, tLname1, tRelation, tPnum2, tCourse, tYearLevel;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_passing_intents_exercise2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tFname = findViewById(R.id.txtPI2Fname);
        tLname = findViewById(R.id.txtPI2Lname);
        tGender = findViewById(R.id.txtPI2Gender);
        tBdate = findViewById(R.id.txtPI2BDate);
        tPnum = findViewById(R.id.txtPI2Number);
        tEmail = findViewById(R.id.txtPI2Email);
        tFname1 = findViewById(R.id.txtPI2Fname1);
        tLname1 = findViewById(R.id.txtPI2Lname1);
        tRelation = findViewById(R.id.txtPI2Relation);
        tPnum2 = findViewById(R.id.txtPI2PNum2);
        tCourse = findViewById(R.id.txtPI2Course);
        tYearLevel = findViewById(R.id.txtPI2YearLevel);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String bdate = intent.getStringExtra("bdate_key");
        String pnum = intent.getStringExtra("pnum_key");
        String email = intent.getStringExtra("eadd_key");
        String fname1 = intent.getStringExtra("fname1_key");
        String lname1 = intent.getStringExtra("lname1_key");
        String relation = intent.getStringExtra("relation_key");
        String pnum2 = intent.getStringExtra("pnum2_key");
        String course = intent.getStringExtra("course_key");
        String yearLevel = intent.getStringExtra("year_level_key");

        tFname.setText(fname);
        tLname.setText(lname);
        tGender.setText(gender);
        tBdate.setText(bdate);
        tPnum.setText(pnum);
        tEmail.setText(email);
        tFname1.setText(fname1);
        tLname1.setText(lname1);
        tRelation.setText(relation);
        tPnum2.setText(pnum2);
        tCourse.setText(course);
        tYearLevel.setText(yearLevel);

        btnReturn = findViewById(R.id.btnPI2Return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(PassingIntentsExercise2.this, PassingIntentsExercise.class); //this Class & destination Class
                startActivity(intent5);

            }
        });

    }
}
