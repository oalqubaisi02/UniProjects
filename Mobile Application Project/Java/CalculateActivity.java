package com.example.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {

    private EditText currentCgpaEditText, finishedCreditEditText;
    private TextView newCgpaTextView, semesterGpaTextView;
    private CoursesDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        currentCgpaEditText = findViewById(R.id.CGPAText);
        finishedCreditEditText = findViewById(R.id.finishedCrText);
        newCgpaTextView = findViewById(R.id.newCGPA);
        semesterGpaTextView = findViewById(R.id.newGPA);
        database = new CoursesDatabase(this);
    }

    public void CalculateGPA(View v){
        calculateGpaCgpa();
    }
    private void calculateGpaCgpa() {
        String currentCgpaStr = currentCgpaEditText.getText().toString();
        String finishedCreditStr = finishedCreditEditText.getText().toString();
        if (currentCgpaStr.isEmpty() || finishedCreditStr.isEmpty()) {
            Toast.makeText(CalculateActivity.this, "Error: Empty fields", Toast.LENGTH_SHORT).show();
            return;
        }
        double currentCgpa = Double.parseDouble(currentCgpaStr);
        int finishedCredit = Integer.parseInt(finishedCreditStr);
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.query(
                CoursesDatabase.TABLE_NAME, null, null, null,
                null, null, null);
        int totalCredits = 0;
        double totalQualityPoints = 0;
        while (cursor.moveToNext()) {
            int credit = cursor.getInt(cursor.getColumnIndexOrThrow(CoursesDatabase.COLUMN_CREDIT));
            double qualityPoint = cursor.getDouble(cursor.getColumnIndexOrThrow(CoursesDatabase.COLUMN_QUALITY_POINT));
            totalCredits += credit;
            totalQualityPoints += qualityPoint;
        }
        cursor.close();

        double semesterGpa = totalQualityPoints / totalCredits;
        double newCgpa = ((currentCgpa * finishedCredit) + totalQualityPoints) / (finishedCredit + totalCredits);

        semesterGpaTextView.setText(String.format("%.3f", semesterGpa));
        newCgpaTextView.setText(String.format("%.3f", newCgpa));
    }
}