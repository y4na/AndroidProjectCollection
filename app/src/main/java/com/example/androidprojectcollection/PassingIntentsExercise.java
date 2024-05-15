package com.example.androidprojectcollection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class PassingIntentsExercise extends AppCompatActivity {

    Button btnSubmit, btnClear;
    EditText eFName, eLName, eBDate, eNum, eMail, eFName1, eLName1, eRelation, ePNum2, eCourse;
    RadioButton rMale, rFemale, rOthers, rFirst, rSecond, rThird, rFourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        btnSubmit = findViewById(R.id.btnPassingSubmit);
        btnClear = findViewById(R.id.btnPassingClear);
        eFName = findViewById(R.id.etxtFName);
        eLName = findViewById(R.id.etxtLName);
        rMale = findViewById(R.id.radMale);
        rFemale = findViewById(R.id.radFemale);
        rOthers = findViewById(R.id.radOthers);
        eBDate = findViewById(R.id.etxtBirthDate);
        eNum = findViewById(R.id.etxtPhone);
        eMail = findViewById(R.id.etxtEmail);
        eFName1 = findViewById(R.id.etxtFName1);
        eLName1 = findViewById(R.id.etxtLName2);
        eRelation = findViewById(R.id.etxtRelation);
        ePNum2 = findViewById(R.id.etxtPNum2);
        eCourse = findViewById(R.id.etxtCourse);
        rFirst = findViewById(R.id.radFirst);
        rSecond = findViewById(R.id.radSecond);
        rThird = findViewById(R.id.radThird);
        rFourth = findViewById(R.id.radFourth);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = eFName.getText().toString();
                String lname = eLName.getText().toString();
                String gender = "";
                if (rMale.isChecked()) {
                    gender = "Male";
                } else if (rFemale.isChecked()) {
                    gender = "Female";
                } else if (rOthers.isChecked()) {
                    gender = "Others";
                }

                String bDate = eBDate.getText().toString();
                String pNumber = eNum.getText().toString();
                String emailAdd = eMail.getText().toString();
                String fname1 = eFName1.getText().toString();
                String lname1 = eLName1.getText().toString();
                String relation = eRelation.getText().toString();
                String pNum2 = ePNum2.getText().toString();
                String course = eCourse.getText().toString();
                String yearLevel = "";
                if (rFirst.isChecked()) {
                    yearLevel = "First";
                } else if (rSecond.isChecked()) {
                    yearLevel = "Second";
                } else if (rThird.isChecked()) {
                    yearLevel = "Third";
                } else if (rFourth.isChecked()) {
                    yearLevel = "Fourth";
                }

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("fname_key", fname);
                intent.putExtra("lname_key", lname);
                intent.putExtra("gender_key", gender);
                intent.putExtra("bdate_key", bDate);
                intent.putExtra("pnum_key", pNumber);
                intent.putExtra("eadd_key", emailAdd);
                intent.putExtra("fname1_key", fname1);
                intent.putExtra("lname1_key", lname1);
                intent.putExtra("relation_key", relation);
                intent.putExtra("pnum2_key", pNum2);
                intent.putExtra("course_key", course);
                intent.putExtra("year_level_key", yearLevel);

                startActivity(intent);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eFName.setText("");
                eLName.setText("");
                rMale.setChecked(false);
                rFemale.setChecked(false);
                rOthers.setChecked(false);
                eBDate.setText("");
                eNum.setText("");
                eMail.setText("");
                eFName1.setText("");
                eLName1.setText("");
                eRelation.setText("");
                ePNum2.setText("");
                eCourse.setText("");
                rFirst.setChecked(false);
                rSecond.setChecked(false);
                rThird.setChecked(false);
                rFourth.setChecked(false);
            }
        });
    }
}
