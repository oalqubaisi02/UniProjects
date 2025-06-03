package com.example.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    private CoursesDatabase database;
    private ListView listView;
    private long selectedCourseId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        database = new CoursesDatabase(this);
        listView = findViewById(R.id.listView);
        populateListView();
    }

    public void DeleteCourse(View v){
        try {
            if (selectedCourseId != -1) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.delete(CoursesDatabase.TABLE_NAME, CoursesDatabase.COLUMN_ID + "=?", new String[]{String.valueOf(selectedCourseId)});
                Toast.makeText(DeleteActivity.this, "Course deleted", Toast.LENGTH_SHORT).show();
                populateListView();
            } else {
                Toast.makeText(DeleteActivity.this, "Please select a course to delete", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e("DeleteActivity", "Error deleting course", e);
            Toast.makeText(DeleteActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
        }
    }

    private void populateListView() {
        try {
            SQLiteDatabase db = database.getReadableDatabase();
            Cursor cursor = db.query(
                    CoursesDatabase.TABLE_NAME, null, null, null,
                    null, null, null);
            CustomCursorAdapter adapter = new CustomCursorAdapter(this, cursor);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            Log.e("DeleteActivity", "Error populating list view", e);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            selectedCourseId = (long) view.getTag();
        }
    }
}