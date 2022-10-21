package br.edu.qi.mentalhealthaplication.Controller.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.qi.mentalhealthaplication.R;

public class MenuActivity extends AppCompatActivity {
    private Button buttonTest, buttonRegisterReasons, buttonListReasons, buttonRegisterPlan,
            buttonListPlan, buttonHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
        buttonTest = findViewById(R.id.buttonTest);
        buttonRegisterReasons = findViewById(R.id.buttonRegisterReasons);
        buttonListReasons = findViewById(R.id.buttonListReasons);
        buttonRegisterPlan = findViewById(R.id.buttonRegisterPlans);
        buttonListPlan = findViewById(R.id.buttonListPlan);
        buttonHelp = findViewById(R.id.buttonHelp);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,TestActivity.class));
            }
        });

        buttonRegisterReasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ReasonRegistrationActivity.class));
            }
        });

        buttonListReasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ReasonListActivity.class));
            }
        });

        buttonRegisterPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, PlanRegistrationActivity.class));
            }
        });

        buttonListPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, PlanListActivity.class));
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,HelpActivity.class));
            }
        });
    }
}