package br.edu.qi.mentalhealthaplication.Controller.Activitys;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.qi.mentalhealthaplication.Model.DAO.PlanDataAccessObject;
import br.edu.qi.mentalhealthaplication.Model.Plan;
import br.edu.qi.mentalhealthaplication.R;

public class PlanRegistrationActivity extends AppCompatActivity {
    private EditText editTitle, editText;
    private Button buttonRegister;
    private PlanDataAccessObject objectPlanDataAccessObject;
    private Plan planObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_plan);
        getSupportActionBar().hide();
        objectPlanDataAccessObject = new PlanDataAccessObject(getApplicationContext());
        editTitle = findViewById(R.id.editTitlePlan);
        editText = findViewById(R.id.editTextPlan);
        buttonRegister = findViewById(R.id.buttonRegisterReason);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                planObject = new Plan();
                planObject.setTitle(editTitle.getText().toString());
                planObject.setText(editText.getText().toString());
                objectPlanDataAccessObject.registerPlan(planObject);
                cleanFields();
            }
        });
    }
    public void cleanFields(){
        editTitle.setText("");
        editText.setText("");
        editTitle.requestFocus();
    }
}