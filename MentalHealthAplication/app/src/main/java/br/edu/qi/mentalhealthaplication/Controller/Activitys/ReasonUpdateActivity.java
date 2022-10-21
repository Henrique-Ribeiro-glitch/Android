package br.edu.qi.mentalhealthaplication.Controller.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.qi.mentalhealthaplication.Model.DAO.ReasonDataAccessObject;
import br.edu.qi.mentalhealthaplication.Model.Reason;
import br.edu.qi.mentalhealthaplication.R;

public class ReasonUpdateActivity extends AppCompatActivity {
    private EditText editTitle, editText;
    private Button buttonUpdate;
    private ReasonDataAccessObject objectReasonDataAccessObject;
    private Reason reasonObject = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason_update);
        getSupportActionBar().hide();
        objectReasonDataAccessObject = new ReasonDataAccessObject(getApplicationContext());
        editTitle = findViewById(R.id.editTitleReason);
        editText = findViewById(R.id.editTextReason);
        buttonUpdate = findViewById(R.id.buttonUpdateReason);

        Intent intent = getIntent();

        if (intent.hasExtra("reason")){
            reasonObject = (Reason) intent.getSerializableExtra("reason");
            editTitle.setText(reasonObject.getTitle());
            editText.setText(reasonObject.getText());
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reasonObject.setTitle(editTitle.getText().toString());
                reasonObject.setText(editText.getText().toString());
                objectReasonDataAccessObject.updateReason(reasonObject);
                cleanFields();
                startActivity(new Intent(ReasonUpdateActivity.this,
                        ReasonListActivity.class));finish();
            }
        });
    }
    public void cleanFields(){
        editTitle.setText("");
        editText.setText("");
        editTitle.requestFocus();
    }
}