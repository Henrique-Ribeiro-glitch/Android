package br.edu.qi.mentalhealthaplication.Controller.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.edu.qi.mentalhealthaplication.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().hide();


    }
}