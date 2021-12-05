package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizListDBHandler extends SQLiteOpenHelper {

    // Defining basic DB info
    private static final String DB_NAME = "quizzesDB";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "all_quizzes";

    // Defining basic column info
    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String POINTS_PER_QUES_COL = "points_per_question";

    private static final String NUMBER_OF_QUES_COL = "number_of_questions";

    private static final String MINUTES_PER_QUES_COL = "minutes_per_question";

    // Constructor for our database handler.
    public QuizListDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Method for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating an SQLite Query with auto-incrementing Primary Key
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT UNIQUE,"
                + POINTS_PER_QUES_COL + " INTEGER,"
                + NUMBER_OF_QUES_COL + " INTEGER,"
                + MINUTES_PER_QUES_COL + " INTEGER)";

        // Executing the SQL Query we just made
        db.execSQL(query);
    }

    // Method to add new quizzes to our sqlite database.
    public void addNewQuiz(String quizName, int pointsPerQuestion, int numberOfQuestions, int minutesPerQuestion) {

        // Creating a variable to write into the database
        SQLiteDatabase db = this.getWritableDatabase();

        // Values variable which will help us in creating key-value pairs in the format - (column, row_value).
        ContentValues values = new ContentValues();

        // Initialising a row from user inputs.
        values.put(NAME_COL, quizName);
        values.put(POINTS_PER_QUES_COL, pointsPerQuestion);
        values.put(NUMBER_OF_QUES_COL, numberOfQuestions);
        values.put(MINUTES_PER_QUES_COL, minutesPerQuestion);

        // Inserting the quiz row into our all quizzes table
        db.insert(TABLE_NAME, null, values);

        // CLosing the existing connection to our DB
        db.close();
    }

    // Method for reading all the courses.
    public ArrayList<AllQuizzesModal> readQuizzes() {
        SQLiteDatabase db = this.getReadableDatabase();

        // Creating a cursor with query to read data from database.
        Cursor cursorQuizzes = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // Creating a new array list which will contain all quizzes.
        ArrayList<AllQuizzesModal> quizzesModalArrayList = new ArrayList<>();

        // Moving our cursor to first position.
        if (cursorQuizzes.moveToFirst()) {
            do {
                // Adding the quiz data from cursor to our array list.
                quizzesModalArrayList.add(new AllQuizzesModal(cursorQuizzes.getString(1),
                        cursorQuizzes.getInt(2),
                        cursorQuizzes.getInt(3),
                        cursorQuizzes.getInt(4)));
            } while (cursorQuizzes.moveToNext());
            // Updating our cursor to move to the next row.
        }
        // Closing our cursor
        cursorQuizzes.close();
        // Returning our array list.
        return quizzesModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Method to check if the table exists already.
        // If it does, then it's deleted, and the new table replaces it.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}