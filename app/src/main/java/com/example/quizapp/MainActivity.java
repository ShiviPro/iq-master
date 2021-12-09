package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
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
    private UltimateArtQuizDBHandler ultimateArtQuizDBHandler;
    private WiningAndDiningQuizDBHandler winingAndDiningQuizDBHandler;
    private PredatoryBirdsQuizDBHandler predatoryBirdsQuizDBHandler;
    private PeriodicTableQuizDBHandler periodicTableQuizDBHandler;
    private MapQuizDBHandler mapQuizDBHandler;
    private HistoryOfWarQuizDBHandler historyOfWarQuizDBHandler;
    private MoonsQuizDBHandler moonsQuizDBHandler;

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
        ultimateArtQuizDBHandler = new UltimateArtQuizDBHandler(MainActivity.this);
        winingAndDiningQuizDBHandler = new WiningAndDiningQuizDBHandler(MainActivity.this);
        predatoryBirdsQuizDBHandler = new PredatoryBirdsQuizDBHandler(MainActivity.this);
        periodicTableQuizDBHandler = new PeriodicTableQuizDBHandler(MainActivity.this);
        mapQuizDBHandler = new MapQuizDBHandler(MainActivity.this);
        historyOfWarQuizDBHandler = new HistoryOfWarQuizDBHandler(MainActivity.this);
        moonsQuizDBHandler = new MoonsQuizDBHandler(MainActivity.this);
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

        allQuizzesDbHandler.addNewQuiz("Ultimate Art Quiz", 2, 10, 2);
        ultimateArtQuizDBHandler.addNewQuestion("Which of these is a paint made from pigments and plastic?", "acetone;acrylic;tempera;gesso;", "acrylic");
        ultimateArtQuizDBHandler.addNewQuestion("Early photographers made their images on which of these materials?", "paper;glass;stone;plastic;", "glass");
        ultimateArtQuizDBHandler.addNewQuestion("To which artistic movement does Paul Gauguin’s The Yellow Christ belong?", "Impressionism;Cloisonnism;Bauhaus;Fauvism;", "Cloisonnism");
        ultimateArtQuizDBHandler.addNewQuestion("What does the Venus of Brassempouy represent?", "a human figure;an angel;a woman's head;an old man;", "a woman's head");
        ultimateArtQuizDBHandler.addNewQuestion("Which architect founded the Bauhaus school of design?", "Frank Gehry;Frank Lloyd Wright;Walter Groplus;I.M. Pei;", "Walter Groplus");
        ultimateArtQuizDBHandler.addNewQuestion("Who designed the Vietnam Veterans Memorial?", "Henri Matisse;Frank Gehry;Maya Lin;Frank Lloyd Wright;", "Maya Lin");
        ultimateArtQuizDBHandler.addNewQuestion("What did I.M. Pei design outside the Louvre, in Paris?", "ziggurat;pyramid;obelisk;sacrophagus;", "pyramid");
        ultimateArtQuizDBHandler.addNewQuestion("Which one of these is not a well-known Indian sculptor?", "Ramkinkar Baij;Henry Moore;Kumaradeva;Krishna Reddy;", "Henry Moore");
        ultimateArtQuizDBHandler.addNewQuestion("What animal often symbolizes peace in art?", "dog;deer;duck;dove;", "dove");
        ultimateArtQuizDBHandler.addNewQuestion("What was the subject of the earliest known paintings?", "flowers;landscapes;animals;sports;", "animals");


        allQuizzesDbHandler.addNewQuiz("Wining & Dining Quiz", 2, 9, 1);
        winingAndDiningQuizDBHandler.addNewQuestion("What varietal fragrance is found in some Cabernet wines?", "bell pepper;squash;arugula;lemon;", "bell pepper");
        winingAndDiningQuizDBHandler.addNewQuestion("Which is not a step in wine tasting?", "noting viscosity;visual assessment;deep smelling;tasting;", "noting viscosity");
        winingAndDiningQuizDBHandler.addNewQuestion("What quality are the majority of French wines?", "villages;grand cru;supérieure;vins ordinaries;", "vins ordinaries");
        winingAndDiningQuizDBHandler.addNewQuestion("Which district is not included in the Burgundy region?", "Chablis;Champagne;Côte d’Or;Mâcon;", "Champagne");
        winingAndDiningQuizDBHandler.addNewQuestion("What kind of wine does the Rhône region mostly produce?", "red;white;rose;sparkling;", "red");
        winingAndDiningQuizDBHandler.addNewQuestion("What kind of wines contain over 14 percent alcohol?", "Sherry wines;Fortified wines;Champagne;Sparkling wines;", "Fortified wines");
        winingAndDiningQuizDBHandler.addNewQuestion("What French delicacy consists of the liver of a goose or duck that has been fattened by a process of force-feeding?", "escargots;foie gras;sweetbread;confit de canard;", "foie gras");
        winingAndDiningQuizDBHandler.addNewQuestion("Which dish is the meat of calves slaughtered between 3 and 14 weeks of age?", "sweetbread;foie gras;venison;veal;", "veal");
        winingAndDiningQuizDBHandler.addNewQuestion("Which is savoury or sweet dish with the consistency of a dense foam, composed of a puréed chief ingredient mixed with stiffly beaten egg whites, whipped cream, or both?", "mousse;whipped cream;custard;meringue;", "mousse");


        allQuizzesDbHandler.addNewQuiz("Predatory Birds Quiz", 2, 6, 1);
        predatoryBirdsQuizDBHandler.addNewQuestion("Which bird has been known to kill human beings with slashing blows of its feet, as the innermost of its three toes bears a long daggerlike nail?", "Cassowary;Ostrich;Emu;Lammergeier;", "Cassowary");
        predatoryBirdsQuizDBHandler.addNewQuestion("Which flightless bird once proved a danger to American country singer Johnny Cash?", "Ostrich;Emu;Moa;Kiwi;", "Ostrich");
        predatoryBirdsQuizDBHandler.addNewQuestion("Which bird dines on bone marrow from carrion, which it accesses by dropping its prey from great heights to crack open the bones?", "Great Horned Owl;Barred Owl;Moa;Lammergeier;", "Lammergeier");
        predatoryBirdsQuizDBHandler.addNewQuestion("Which bird attacked a jogger in Salem, Oregon, in 2015, striking the scalp repeatedly before the jogger escaped?", "Great Horned Owl;Barred Owl;Magpie;Bearded Vulture;", "Great Horned Owl");
        predatoryBirdsQuizDBHandler.addNewQuestion("What bird was invoked in a murder case when the defense argued that it was the bird, rather than the defendant, attacked the victim?", "Great Horned Owl;Bearded Vulture;Red-Shouldered Hawk;Barred Owl;", "Barred Owl");
        predatoryBirdsQuizDBHandler.addNewQuestion("Which bird can run at nearly 50 km (30 miles) per hour and is capable of eviscerating animals (or, more rarely, humans) under the right conditions?", "Great Northern Loon;Ostrich;Emu;Spur-winged Goose;", "Emu");

        allQuizzesDbHandler.addNewQuiz("The Periodic Table Quiz", 2, 15, 1);
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol B?", "Boron;Barium;Bromine;Beryllium;", "Boron");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Se?", "Selenium;Seaborgium;Scandium;Silver;", "Selenium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol I?", "Iridium;Iron;Iodine;Indium;", "Iodine");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol S?", "Strontium;Seaborgium;Sulfur;Scandium;", "Sulfur");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Rg?", "Argon;Radium;Roentgenium;Rubidium;", "Roentgenium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Cs?", "Curium;Ceasium;Cerium;Cadmium;", "Ceasium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Fl?", "Flerovium;Francium;Fluorine;Fermium;", "Flerovium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol P?", "Palladium;Platinum;Polonium;Phosphorus;", "Phosphorus");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Mt?", "Manganese;Meitnerium;Magnesium;Mendelevium;", "Meitnerium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Ga?", "Gallium;Germanium;Gold;Gadolinium;", "Gallium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Rb?", "Rhodium;Rhenium;Rutherfordium;Rubidium;", "Rubidium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Sn?", "Tin;Thorium;Titanium;Tellurium;", "Tin");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Ce?", "Chlorine;Cerium;Cesium;Curium;", "Cerium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol Lr?", "Lawrencium;Livermorium;Lutetium;Lanthanum;", "Lawrencium");
        periodicTableQuizDBHandler.addNewQuestion("What is the chemical element for the symbol At?", "Astatine;Argon;Arsenic;Actinium;", "Astatine");

        allQuizzesDbHandler.addNewQuiz("The Map Quiz", 2, 15, 2);
        mapQuizDBHandler.addNewQuestion("Which of these is the largest landlocked country in the world?", "Central African Republic;Paraguay;Kazakhstan;Bolivia;", "Kazakhstan");
        mapQuizDBHandler.addNewQuestion("What country has the largest Muslim population?", "Indonesia;Libya;Iraq;Nigeria;", "Indonesia");
        mapQuizDBHandler.addNewQuestion("What European country is divided into departments?", "France;Switzerland;Germany;Sweden;", "France");
        mapQuizDBHandler.addNewQuestion("Which of these countries is said to be shaped like an elephant’s head?", "Thailand;Zaire;France;Australia;", "Thailand");
        mapQuizDBHandler.addNewQuestion("In what country might one hear the song 'Waltzing Matilda ' frequently played?", "Brazil;Australia;Paraguay;Congo;", "Australia");
        mapQuizDBHandler.addNewQuestion("What is the name of the long, narrow country on South America’s Pacific coast?", "Argentina;Ecuador;Chile;Peru;", "Chile");
        mapQuizDBHandler.addNewQuestion("Which of these countries is considered the world’s oldest republic?", "Andorra;Monaco;San Marino;Iceland;", "San Marino");
        mapQuizDBHandler.addNewQuestion("Which is the world’s smallest fully independent nation?", "Vatican City;Togo;Vanuatu;Kiribati;", "Vatican City");
        mapQuizDBHandler.addNewQuestion("Which country participated at the Olympic Games in 1924 for the first time and won the gold medal in football (soccer)?", "Israel;Croatia;Uruguay;Liberia;", "Uruguay");
        mapQuizDBHandler.addNewQuestion("Which country was called “the pearl of Africa” by Sir Winston Churchill?", "Mozambique;Netherlands;Uganda;Mauritius;", "Uganda");
        mapQuizDBHandler.addNewQuestion("Which country in eastern Europe was formerly known as White Russia?", "North Macedonia;Saint Lucia;Belarus;Moldova;", "Belarus");
        mapQuizDBHandler.addNewQuestion("Which country did the communist movement, Khmer Rouge, rule?", "Maldives;Sudan;Bulgaria;Cambodia;", "Cambodia");
        mapQuizDBHandler.addNewQuestion("In which country are the aflāj, an ancient system of water channels that have been designated a UNESCO World Heritage site, found?", "Angola;Jordan;Kuwait;Oman;", "Oman");
        mapQuizDBHandler.addNewQuestion("Which country was formerly known as French Somaliland and the French Territory of the Afars and Issas?", "Mauritania;Botswana;Djibouti;Malta;", "Djibouti");
        mapQuizDBHandler.addNewQuestion("Which African country is known as the 'land of a thousand hills' ?", "Rwanda;Georgia;Czech Republic;Mall;", "Rwanda");

        allQuizzesDbHandler.addNewQuiz("History Of War", 2, 10, 2);
        historyOfWarQuizDBHandler.addNewQuestion("In what country did the Battle of Waterloo take place?", "Belgium;Germany;France;the Netherlands;", "Belgium");
        historyOfWarQuizDBHandler.addNewQuestion("Which treaty ended the War of 1812?", "Treaty of Versailles;Maastricht Party;Treaty of Ghent;Treaty of Brest-Litovsk;", "Treaty of Ghent");
        historyOfWarQuizDBHandler.addNewQuestion("What was the world’s first nuclear-powered aircraft carrier?", "Forrestal;Invincible;Enterprise;Yamato;", "Enterprise");
        historyOfWarQuizDBHandler.addNewQuestion("Which of these was not a battle fought in World War II?", "Okinawa;Gettysburg;Anzio;two Jima;", "Gettysburg");
        historyOfWarQuizDBHandler.addNewQuestion("The D-Day invasion of June 6, 1944, took place in:", "Belgium;Ireland;France;Canada;", "France");
        historyOfWarQuizDBHandler.addNewQuestion("Which river did George Washington’s troops cross to engage in the Battle of Trenton?", "Delaware;Potomac;Hudson;Mississippi;", "Delaware");
        historyOfWarQuizDBHandler.addNewQuestion("Which leader was overthrown by the U.S. invasion of Iraq in 2003?", "Indira Gandhi;Saddam Hussain;Abdei Gamel Nasser;King Saud;", "Saddam Hussain");
        historyOfWarQuizDBHandler.addNewQuestion("Where did the abortive 1961 invasion of Cuba take place?", "Havana Bay;Bay of Biscay;Bay of Pigs;Guantanamo Bay;", "Bay of Pigs");
        historyOfWarQuizDBHandler.addNewQuestion("In what year was the Battle of Hastings fought?", "1061;1011;1055;1066;", "1066");
        historyOfWarQuizDBHandler.addNewQuestion("Which of these is another name for World War I?", "Yugoslav Wars;Austro-Prussian Wars;Great War;Revolution of 1917;", "Great War");

        allQuizzesDbHandler.addNewQuiz("Moons Quiz", 2, 7, 2);
        moonsQuizDBHandler.addNewQuestion("Triton is the moon of which planet ?", "Mercury;Earth;Mars;Neptune;", "Neptune");
        moonsQuizDBHandler.addNewQuestion("Phobos is the moon of which planet ?", "Mars;Jupiter;Mercury;Venus;", "Mars");
        moonsQuizDBHandler.addNewQuestion("Nereid is the moon of which planet ?", "Mars;Venus;Neptune;Mercury;", "Neptune");
        moonsQuizDBHandler.addNewQuestion("Amalthea is the moon of which planet ?", "Uranus;Jupiter;Mars;Venus;", "Jupiter");
        moonsQuizDBHandler.addNewQuestion("Phoebe is the moon of which planet ?", "Neptune;Uranus;Saturn;Earth;", "Saturn");
        moonsQuizDBHandler.addNewQuestion("Deimos is the moon of which planet ?", "Jupiter;Uranus;Mars;Venus;", "Mars");
        moonsQuizDBHandler.addNewQuestion("Cordelia is the moon of which planet ?", "Mars;Uranus;Mercury;Jupiter;", "Uranus");

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