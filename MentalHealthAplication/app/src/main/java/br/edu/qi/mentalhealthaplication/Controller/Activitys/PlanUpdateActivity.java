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

public class PlanUpdateActivity extends AppCompatActivity {
    private EditText editTitle, editText;
    private Button buttonUpdate;
    private PlanDataAccessObject objectPlanDataAccessObject;
    private Plan planObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_update);
        getSupportActionBar().hide();
        objectPlanDataAccessObject = new PlanDataAccessObject(getApplicationContext());
        editTitle = findViewById(R.id.editTitlePlan);
        editText = findViewById(R.id.editTextPlan);
        buttonUpdate = findViewById(R.id.buttonUpdateReason);
        Intent intent = getIntent();
        planObject = (Plan) intent.getSerializableExtra("plan");
        editTitle.setText(planObject.getTitle());
        editText.setText(planObject.getText());

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                planObject.setTitle(editTitle.getText().toString());
                planObject.setText(editText.getText().toString());
                objectPlanDataAccessObject.updatePlan(planObject);
                cleanFields();
                startActivity(new Intent(PlanUpdateActivity.this,
                        PlanListActivity.class));
                finish();
            }
        });
    }
    public void cleanFields(){
        editTitle.setText("");
        editText.setText("");
        editTitle.requestFocus();
    }
}