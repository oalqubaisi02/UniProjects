package com.example.project;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {

    public CustomCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.course_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView courseNameTextView = view.findViewById(R.id.courseNameTextView);
        RadioButton radioButton = view.findViewById(R.id.radioButton);

        String courseName = cursor.getString(cursor.getColumnIndexOrThrow(CoursesDatabase.COLUMN_COURSE_NAME));
        long courseId = cursor.getLong(cursor.getColumnIndexOrThrow(CoursesDatabase.COLUMN_ID));

        courseNameTextView.setText(courseName);
        radioButton.setTag(courseId);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DeleteActivity) context).onRadioButtonClicked(v);
            }
        });
    }
}