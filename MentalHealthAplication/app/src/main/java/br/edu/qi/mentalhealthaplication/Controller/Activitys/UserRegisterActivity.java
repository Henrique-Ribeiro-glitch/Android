package br.edu.qi.mentalhealthaplication.Controller.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.qi.mentalhealthaplication.Model.DAO.UserDataAccessObject;
import br.edu.qi.mentalhealthaplication.R;
import br.edu.qi.mentalhealthaplication.Model.User;

public class UserRegisterActivity extends AppCompatActivity {
    private TextView textOut;
    private EditText editName, editPassword;
    private Button buttonRegister;
    private UserDataAccessObject objectUserDataAccessObject;
    private User objectUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        getSupportActionBar().hide();
        objectUserDataAccessObject = new UserDataAccessObject(getApplicationContext());
        editName = findViewById(R.id.editUserName);
        editPassword = findViewById(R.id.editPassword);
        buttonRegister = findViewById(R.id.buttonRegisterReason);
        textOut = findViewById(R.id.textViewOut);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectUser = new User();
                objectUser.setName(editName.getText().toString());
                objectUser.setPassword(editPassword.getText().toString());
                objectUserDataAccessObject.userRegister(objectUser);
                clearFields();
                startActivity(new Intent(UserRegisterActivity.this,MenuActivity.class));
                finish();
            }
        });

        textOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserRegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void clearFields(){
        editName.setText("");
        editPassword.setText("");
        editName.requestFocus();
    }
}