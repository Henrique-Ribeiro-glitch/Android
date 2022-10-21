package br.edu.qi.projetoconceitos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextMedia;
    Button buttonVerificar;
    TextView TextViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        editTextMedia= findViewById(R.id.editTextMedia);
        buttonVerificar = findViewById(R.id.buttonVerificar);
        TextViewResultado = findViewById(R.id.textViewResultado);
    }

    public void mostrarDadosDoAluno(View view) {
        Aluno objetoAluno = new Aluno();
        if (editTextNome.getText().toString().isEmpty() || editTextMedia.getText().toString().isEmpty()){
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_LONG).show();
        }else {
            objetoAluno.setNome(editTextNome.getText().toString());
            objetoAluno.setMedia(Double.parseDouble(editTextMedia.getText().toString()));
            TextViewResultado.setText(objetoAluno.toString());
        }
    }

}