package br.edu.qi.projetoNadador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextIdade;
    Button buttonClassificar;
    TextView TextViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        buttonClassificar = findViewById(R.id.buttonClassificar);
        TextViewResultado = findViewById(R.id.textViewResultado);
    }

    public void mostrarDadosDoNadador(View view) {
        Nadador objetoNadador = new Nadador();
        if (editTextNome.getText().toString().isEmpty() || editTextIdade.getText().toString().isEmpty()){
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_LONG).show();
        }else {
            objetoNadador.setNome(editTextNome.getText().toString());
            objetoNadador.setIdade(Byte.parseByte(editTextIdade.getText().toString()));
            TextViewResultado.setText(objetoNadador.toString());
        }

    }
}