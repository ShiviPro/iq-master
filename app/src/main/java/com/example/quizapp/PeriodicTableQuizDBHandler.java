package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quizapp.QuizModal;

import java.util.ArrayList;

public class PeriodicTableQuizDBHandler extends SQLiteOpenHelper {

    // Defining basic DB info
    private static final String DB_NAME = "periodicTableQuizDB";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "periodic_table_quiz";

    // Defining basic column info
    private static final String ID_COL = "id";

    private static final String QUES_COL = "question";

    private static final String OPTIONS_COL = "options";

    private static final String CORRECT_ANSWER_COL = "correct_answer";


    // Constructor for our database handler.
    public PeriodicTableQuizDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Method for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating an SQLite Query with auto-incrementing Primary Key
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUES_COL + " TEXT UNIQUE,"
                + OPTIONS_COL + " TEXT,"
                + CORRECT_ANSWER_COL + " TEXT)";

        // Executing the SQL Query we just made
        db.execSQL(query);
    }

    // Method to add new questions to our database.
    public void addNewQuestion(String questionName, String options, String correctAnswer) {

        // Creating a variable to write into the database
        SQLiteDatabase db = this.getWritableDatabase();

        // Values variable which will help us in creating key-value pairs in the format - (column, row_value).
        ContentValues values = new ContentValues();

        // Initialising a row from user inputs.
        values.put(QUES_COL, questionName);
        values.put(OPTIONS_COL, options);
        values.put(CORRECT_ANSWER_COL, correctAnswer);

        // Inserting the question row into our quiz table
        db.insert(TABLE_NAME, null, values);

        // CLosing the existing connection to our DB
        db.close();
    }

    // Creating a new method for reading all the courses.
    public ArrayList<QuizModal> readQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Creating a cursor with query to read data from database.
        Cursor cursorQuestions = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // Creating a new array list which will contain all Questions.
        ArrayList<QuizModal> questionsModalArrayList = new ArrayList<>();

        // Moving our cursor to first position.
        if (cursorQuestions.moveToFirst()) {
            do {
                // Adding the data from cursor to our array list.
                questionsModalArrayList.add(new QuizModal(cursorQuestions.getString(1),
                        cursorQuestions.getString(2),
                        cursorQuestions.getString(3)));
            } while (cursorQuestions.moveToNext());
            // Moving our cursor to next row.
        }
        // Closing cursor
        cursorQuestions.close();
        // Returning our array list.
        return questionsModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Method to check if the table exists already.
        // If it does, then it's deleted, and the new table replaces it.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}