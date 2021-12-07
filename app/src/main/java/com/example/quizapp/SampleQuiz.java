package com.example.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class SampleQuiz extends AppCompatActivity {
    private Toolbar tb;
    private TextView timer_tv;
    private ProgressBar timer;
    private int progress;

    private CountDownTimer timer_ref;
    private long timeLeftInMilliseconds;
    private boolean isTimerRunning;

    Typeface primary_tf;

    private TextView ques;
    private Button opt_a;
    private Button opt_b;
    private Button opt_c;
    private Button opt_d;
    private Button next_btn;

    private IntroQuizDBHandler introQuizDBHandler;
    private AllAboutAsiaQuizDBHandler allAboutAsiaQuizDBHandler;
    private ArrayList<QuizModal> questionsModalArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_sample);

        tb = (Toolbar) findViewById(R.id.sample_quiz_screen_toolbar);
        setSupportActionBar(tb);

        primary_tf = ResourcesCompat.getFont(this, R.font.comfortaa_variable_font_wght);

        Intent quiz_selected = getIntent();
        String quizName = quiz_selected.getStringExtra("quiz_name");

        timer_tv = (TextView) findViewById(R.id.text_view_progress);
        timeLeftInMilliseconds = 60_000;
        timer_tv.setText(String.valueOf("1:00"));

        timer = (ProgressBar) findViewById(R.id.progress_bar);
        int timeLeftInitially = (int)timeLeftInMilliseconds/1000;
        timer.setMax(timeLeftInitially);
        progress = timeLeftInitially;
        timer.setProgress(progress);

        ques = (TextView) findViewById(R.id.question);
        opt_a = (Button) findViewById(R.id.option_a);
        opt_b = (Button) findViewById(R.id.option_b);
        opt_c = (Button) findViewById(R.id.option_c);
        opt_d = (Button) findViewById(R.id.option_d);
        next_btn = (Button) findViewById(R.id.button2);

        switch(quizName) {
            case "Intro Quiz":  introQuizDBHandler = new IntroQuizDBHandler(SampleQuiz.this);
                                questionsModalArrayList = introQuizDBHandler.readQuestions();
                                break;
            case "All About Asia Quiz": allAboutAsiaQuizDBHandler = new AllAboutAsiaQuizDBHandler(SampleQuiz.this);
                                        questionsModalArrayList = allAboutAsiaQuizDBHandler.readQuestions();
                                        break;
        }

        final int[] questionIndex = {0};
        QuizModal questionData = questionsModalArrayList.get(questionIndex[0]);

        String question = questionData.getQuestionName();
        final String[] correctAnswer = {questionData.getCorrectAnswer()};
        ArrayList<String> options = new ArrayList<>();
        final int[] score = {0};
        int maxScore = questionsModalArrayList.size() * 1;

        String optionStr = questionData.getOptions();
        int startIndex = 0;
        int endIndex = 0;
        for(int index = 0; index < optionStr.length(); index++) {
            char currChar = optionStr.charAt(index);
            if(currChar == ';') {
                endIndex = index;
                options.add(optionStr.substring(startIndex, endIndex));
                startIndex = endIndex + 1;
            }
        }

        ques.setText(question);
        opt_a.setText(options.get(0));
        opt_b.setText(options.get(1));
        opt_c.setText(options.get(2));
        opt_d.setText(options.get(3));

        opt_a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt_a.setBackgroundColor(getResources().getColor(R.color.peri_winkle));
                opt_b.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_c.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_d.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
            }
        });
        opt_b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt_b.setBackgroundColor(getResources().getColor(R.color.peri_winkle));
                opt_a.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_c.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_d.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
            }
        });
        opt_c.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt_c.setBackgroundColor(getResources().getColor(R.color.peri_winkle));
                opt_a.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_b.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_d.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
            }
        });
        opt_d.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opt_d.setBackgroundColor(getResources().getColor(R.color.peri_winkle));
                opt_a.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_b.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                opt_c.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();

                int opt_a_color_id = ((ColorDrawable)opt_a.getBackground()).getColor();
                int opt_b_color_id = ((ColorDrawable)opt_b.getBackground()).getColor();
                int opt_c_color_id = ((ColorDrawable)opt_c.getBackground()).getColor();
                int opt_d_color_id = ((ColorDrawable)opt_d.getBackground()).getColor();


                String selectedOption = "";

                if(opt_a_color_id == getResources().getColor(R.color.peri_winkle)) {
                    selectedOption = opt_a.getText().toString();
                } else if(opt_b_color_id == getResources().getColor(R.color.peri_winkle)) {
                    selectedOption = opt_b.getText().toString();
                } else if(opt_c_color_id == getResources().getColor(R.color.peri_winkle)) {
                    selectedOption = opt_c.getText().toString();
                } else if(opt_d_color_id == getResources().getColor(R.color.peri_winkle)) {
                    selectedOption = opt_d.getText().toString();
                }

                if(selectedOption.equals(correctAnswer[0])) {
                    displayToast("☺️ Correct");
                    score[0] += 1;
                }
                else if(selectedOption.equals("")) {
                    displayToast("Correct Answer was " + correctAnswer[0]);
                }
                else displayToast("\uD83D\uDE22 Wrong\nCorrect Answer was " + correctAnswer[0]);

                if(questionIndex[0] +1 < questionsModalArrayList.size()) {
                    questionIndex[0] +=1;

                    QuizModal questionData = questionsModalArrayList.get(questionIndex[0]);

                    String question = questionData.getQuestionName();
                    correctAnswer[0] = questionData.getCorrectAnswer();
                    ArrayList<String> options = new ArrayList<>();

                    String optionStr = questionData.getOptions();
                    int startIndex = 0;
                    int endIndex = 0;
                    for(int index = 0; index < optionStr.length(); index++) {
                        char currChar = optionStr.charAt(index);
                        if(currChar == ';') {
                            endIndex = index;
                            options.add(optionStr.substring(startIndex, endIndex));
                            startIndex = endIndex + 1;
                        }
                    }

                    opt_a.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                    opt_b.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                    opt_c.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));
                    opt_d.setBackgroundColor(getResources().getColor(R.color.exodus_fruit));

                    ques.setText(question);
                    opt_a.setText(options.get(0));
                    opt_b.setText(options.get(1));
                    opt_c.setText(options.get(2));
                    opt_d.setText(options.get(3));

                    timerManager();
                }
                else {
                    setContentView(R.layout.quiz_results);
                    tb = (Toolbar) findViewById(R.id.quiz_result_toolbar);
                    setSupportActionBar(tb);

                    TextView scoreText = (TextView) findViewById(R.id.score_text_view);
                    scoreText.setText("You scored "+score[0]+"/"+maxScore+" points !");
                }
            }
        });
        timerManager();
    }

    private void timerManager() {
        if(!isTimerRunning) {
            startTimer();
        }
        else stopTimer();
    }

    private void startTimer() {
        timeLeftInMilliseconds = 60_000;
        timer_ref = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateProgress();
            }

            @Override
            public void onFinish() {
                next_btn.performClick();
            }
        }.start();
        isTimerRunning = true;
    }

    private void stopTimer() {
        timer_ref.cancel();
        isTimerRunning = false;
    }

    private void updateProgress() {
        int minutes = (int) timeLeftInMilliseconds / 60_000;
        int seconds = (int) (timeLeftInMilliseconds % 60_000) / 1000;

        progress = (int)timeLeftInMilliseconds/1000 ;
        timer.setProgress(progress);
        if(seconds<10) {
            timer_tv.setText(minutes+":0"+seconds);
        }
        else timer_tv.setText(minutes+":"+seconds);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feedback_sub_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.back_btn: stopTimer();
                                this.finish();
                                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayToast(String message) {

        View layout = getLayoutInflater().inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.custom_toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.custom_toast_layout_text_view);
        text.setText(message);
        text.setTypeface(primary_tf);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(layout);
        toast.show();
    }
}
