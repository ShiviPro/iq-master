package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Toolbar tb;
    private QuizListDBHandler allQuizzesDbHandler;
    private IntroQuizDBHandler introQuizDbHandler;
    private AllAboutAsiaQuizDBHandler allAboutAsiaQuizDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView prim_tv = (TextView)findViewById(R.id.textView3);
        TextView sec_tv = (TextView)findViewById(R.id.textView4);
        TextView ter_tv = (TextView)findViewById(R.id.textView5);

        allQuizzesDbHandler = new QuizListDBHandler(MainActivity.this);
        introQuizDbHandler = new IntroQuizDBHandler(MainActivity.this);
        allAboutAsiaQuizDBHandler = new AllAboutAsiaQuizDBHandler(MainActivity.this);

        Typeface primary_tf = ResourcesCompat.getFont(this, R.font.comfortaa_variable_font_wght);

        prim_tv.setTypeface(primary_tf);
        sec_tv.setTypeface(primary_tf);
        ter_tv.setTypeface(primary_tf);

        btn = (Button) findViewById(R.id.button);

        btn.setTypeface(primary_tf);

        btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent all_quizzes = new Intent(MainActivity.this, AllQuizzes.class);
               startActivity(all_quizzes);
           }
        });

        tb = (Toolbar) findViewById(R.id.home_screen_toolbar);
        setSupportActionBar(tb);

        allQuizzesDbHandler.addNewQuiz("Intro Quiz", 1, 5, 1);
        introQuizDbHandler.addNewQuestion("How old is the sun ?", "3.2 billion years;1.8 billion years;4.6 billion years;none of the above;", "4.6 billion years");
        introQuizDbHandler.addNewQuestion("What was the most used programming language in 2019 ?", "Java;C;Python;JavaScript;", "JavaScript");
        introQuizDbHandler.addNewQuestion("Who is the current president of Zimbabwe ?", "Nelson Chamisa;Emmerson Mnangagwa;Robert Mugabe;Jonathan Moyo;", "Emmerson Mnangagwa");
        introQuizDbHandler.addNewQuestion("What does CTF stand for in context to Cyber Security ?", "Capture The Flag;Caught The Frog;Crack The System;Catch The Ship;", "Capture The Flag");
        introQuizDbHandler.addNewQuestion("What year was JavaScript launched ?", "1997;1994;1995;1991;", "1995");

        allQuizzesDbHandler.addNewQuiz("All About Asia Quiz", 2, 15, 2);
        allAboutAsiaQuizDBHandler.addNewQuestion("When did Buddhism arrive in Japan?", "1 CE;200 BCE;400 CE;1200 CE;", "400 CE");
        allAboutAsiaQuizDBHandler.addNewQuestion("What country does the Mekong River not flow through?", "Vietnam;Mongolia;Laos;China;", "Mongolia");
        allAboutAsiaQuizDBHandler.addNewQuestion("Which of these cities lies on the Saigon River?", "Hong Kong;Hanoi;Ho Chi Minh City;Haiphong;", "Ho Chi Minh City");
        allAboutAsiaQuizDBHandler.addNewQuestion("In what country is Sichuan found?", "Bangladesh;Indonesia;China;Japan;", "China");
        allAboutAsiaQuizDBHandler.addNewQuestion("Which of these rivers does not flow through Bangladesh?", "Brahmaputra;Yangtze;Sangu;Ganges;", "Yangtze");
        allAboutAsiaQuizDBHandler.addNewQuestion("Which of these is not a Japanese city?", "Taipei;Tokyo;Osaka;Sapporo;", "Taipei");
        allAboutAsiaQuizDBHandler.addNewQuestion("What is the main color of China’s flag?", "green;blue;white;red;", "red");
        allAboutAsiaQuizDBHandler.addNewQuestion("What is the capital of Bangladesh?", "Deccan;Dhaka;Accra;Aden;", "Dhaka");
        allAboutAsiaQuizDBHandler.addNewQuestion("In what ocean does Indonesia lie?", "Atlantic;Pacific;Southern;Arctic;", "Pacific");
        allAboutAsiaQuizDBHandler.addNewQuestion("What body of water separates India from Sri Lanka?", "the Molucca Strait;the Torres Strait;the Palk Strait;the Strait of Hormuz;", "the Palk Strait");
        allAboutAsiaQuizDBHandler.addNewQuestion("Which of following bodies of water separates Asia from the African continent?", "Red Sea;Bering Strait;Suez Canal;Arabian Sea;", "Suez Canal");
        allAboutAsiaQuizDBHandler.addNewQuestion("'Spice Islands' is the alternative name for which of these islands of Indonesia ?", "Lembata;Peleng;Moluccas;Buru;", "Moluccas");
        allAboutAsiaQuizDBHandler.addNewQuestion("What is Dunhuang, a city in northwestern China, famous for?", "Forbidden City;Summer Palace;Temple Of Heaven;Mogao Caves;", "Mogao Caves");
        allAboutAsiaQuizDBHandler.addNewQuestion("When was the South Asian Association for Regional Co-operation (SAARC) founded?", "2011;1985;1958;2003;", "1985");
        allAboutAsiaQuizDBHandler.addNewQuestion("Which temple complex appears on the flag of Cambodia?", "Angkor Thom;Wat Phnom;Royal Palace;Angkor Wat;", "Angkor Wat");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.homepage_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.feedback: Intent feedbackIntent = new Intent(MainActivity.this, Feedback.class);
                                startActivity(feedbackIntent);
                                return true;
            default: return super.onOptionsItemSelected(item);

        }
    }
}