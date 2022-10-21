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

public class ReasonRegistrationActivity extends AppCompatActivity {
    private EditText editTitle, editText;
    private Button buttonRegister;
    private ReasonDataAccessObject objectReasonDataAccessObject;
    private Reason reasonObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_reasons);
        getSupportActionBar().hide();
        objectReasonDataAccessObject = new ReasonDataAccessObject(getApplicationContext());
        editTitle = findViewById(R.id.editTitleReason);
        editText = findViewById(R.id.editTextReason);
        buttonRegister = findViewById(R.id.buttonRegisterReason);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reasonObject = new Reason();
                reasonObject.setTitle(editTitle.getText().toString());
                reasonObject.setText(editText.getText().toString());
                objectReasonDataAccessObject.registerReason(reasonObject);
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