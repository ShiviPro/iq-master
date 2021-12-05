package com.example.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class AllQuizzes extends AppCompatActivity {
    Toolbar tb;
    Typeface primary_tf;
    private ArrayList<AllQuizzesModal> quizzesModalArrayList;
    private QuizListDBHandler allQuizzesDBHandler;
    private QuizRVAdapter quizRVAdapter;
    private RecyclerView quizzesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.all_quizzes);
        super.onCreate(savedInstanceState);

        tb = (Toolbar) findViewById(R.id.all_quizzes_screen_toolbar);
        setSupportActionBar(tb);

        primary_tf = ResourcesCompat.getFont(this, R.font.comfortaa_variable_font_wght);
        TextView tv = (TextView) findViewById(R.id.textView8);
        tv.setTypeface(primary_tf);

        quizzesModalArrayList = new ArrayList<>();
        allQuizzesDBHandler = new QuizListDBHandler(AllQuizzes.this);

        // getting our course array
        // list from db handler class.
        quizzesModalArrayList = allQuizzesDBHandler.readQuizzes();

        // Passing our array to our adapter class.
        quizRVAdapter = new QuizRVAdapter(quizzesModalArrayList, AllQuizzes.this);
        quizzesRV = findViewById(R.id.rv_quizzes);

        // Setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllQuizzes.this, RecyclerView.VERTICAL, false);
        quizzesRV.setLayoutManager(linearLayoutManager);

        // Attaching our adapter to recycler view.
        quizzesRV.setAdapter(quizRVAdapter);

        ItemClickSupport.addTo(quizzesRV).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Intent quiz = new Intent(AllQuizzes.this, SampleQuiz.class);
                        quiz.putExtra("quiz_name", quizzesModalArrayList.get(position).getQuizName());
                        startActivity(quiz);
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feedback_sub_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.back_btn: AllQuizzes.this.finish();
                                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
