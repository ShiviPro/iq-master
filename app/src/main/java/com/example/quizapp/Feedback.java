package com.example.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

public class Feedback extends AppCompatActivity {
    Button submit_btn;
    Typeface primary_tf;
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        TextView prim_tv = (TextView)findViewById(R.id.textView6);
        TextView sec_tv = (TextView)findViewById(R.id.textView7);
        EditText prim_et = (EditText) findViewById(R.id.editText1);
        submit_btn = (Button) findViewById(R.id.submit_feedback_btn);

        primary_tf = ResourcesCompat.getFont(this, R.font.comfortaa_variable_font_wght);

        prim_tv.setTypeface(primary_tf);
        sec_tv.setTypeface(primary_tf);
        prim_et.setTypeface(primary_tf);

        submit_btn.setTypeface(primary_tf);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("Feedback submitted");
               Feedback.this.finish();
            }
        });

        tb = (Toolbar) findViewById(R.id.feedback_screen_toolbar);
        setSupportActionBar(tb);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feedback_sub_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {

            case R.id.back_btn: this.finish();
                                return true;

            default:    return super.onOptionsItemSelected(item);

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
