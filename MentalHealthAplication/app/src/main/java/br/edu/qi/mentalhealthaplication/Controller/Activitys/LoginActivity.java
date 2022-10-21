package br.edu.qi.mentalhealthaplication.Controller.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.edu.qi.mentalhealthaplication.Model.DAO.UserDataAccessObject;
import br.edu.qi.mentalhealthaplication.R;
import br.edu.qi.mentalhealthaplication.Model.User;

public class LoginActivity extends AppCompatActivity {
    private EditText editUser,editPassword;
    private Button buttonEnter;
    private TextView textRegister;
    private UserDataAccessObject objectUserDataAccessObject;
    private List<User> allUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        objectUserDataAccessObject = new UserDataAccessObject(LoginActivity.this);
        editUser = findViewById(R.id.editUserName);
        editPassword = findViewById(R.id.editPassword);
        textRegister = findViewById(R.id.textRegister);
        buttonEnter = findViewById(R.id.buttonEnter);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allUsers = objectUserDataAccessObject.listAllUsers();
                boolean validate = true;
                for(int index = 0; index < allUsers.size() && validate; index++){
                    if (allUsers.get(index).getName().equals(editUser.getText().toString()) &&
                            allUsers.get(index).getPassword().equals(editPassword.getText().
                                    toString())){
                        startActivity(new Intent(LoginActivity.this,MenuActivity.class));
                        validate = false;
                    }
                }
                if (validate){
                    Toast.makeText(LoginActivity.this,
                            "User name or password incorrect!",Toast.LENGTH_LONG).show();
                }
            }
        });

        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,UserRegisterActivity.class));
                finish();
            }
        });
    }
}