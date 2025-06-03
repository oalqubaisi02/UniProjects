package com.example.project;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText courseNameEditText, creditEditText, pointEditText;
    private CoursesDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        courseNameEditText = findViewById(R.id.nameText);
        creditEditText = findViewById(R.id.hourText);
        pointEditText = findViewById(R.id.gradeText);
        database = new CoursesDatabase(this);
    }
    public void AddCourse(View v){
        addCourse();
    }
    private void addCourse() {
        String courseName = courseNameEditText.getText().toString();
        String creditStr = creditEditText.getText().toString();
        String pointStr = pointEditText.getText().toString();

        if (courseName.isEmpty() || creditStr.isEmpty() || pointStr.isEmpty()) {
            Toast.makeText(AddActivity.this, "Error: Empty Fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int credit = Integer.parseInt(creditStr);
        double point = Double.parseDouble(pointStr);
        double qualityPoint = credit * point;

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CoursesDatabase.COLUMN_COURSE_NAME, courseName);
        values.put(CoursesDatabase.COLUMN_CREDIT, credit);
        values.put(CoursesDatabase.COLUMN_QUALITY_POINT, qualityPoint);

        long newRowId = db.insert(CoursesDatabase.TABLE_NAME, null, values);
        if (newRowId == -1) {
            Toast.makeText(AddActivity.this, "Error with saving course", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddActivity.this, "Course added", Toast.LENGTH_SHORT).show();
        }

        courseNameEditText.setText("");
        creditEditText.setText("");
        pointEditText.setText("");
    }
}