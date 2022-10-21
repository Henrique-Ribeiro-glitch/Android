package br.edu.qi.projetonotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editNome;
    EditText editNota1;
    EditText editNota2;
    Button buttonCalcularMedia;
    TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNome = findViewById(R.id.editNome);
        editNota1 = findViewById(R.id.editNota1);
        editNota2 = findViewById(R.id.editNota2);
        buttonCalcularMedia = findViewById(R.id.buttonVerDados);
        textViewResultado = findViewById(R.id.textViewResultado);
    }
    public void mostrarDadosDoAluno(View view) {
        Aluno objetoAluno = new Aluno();
        if (editNome.getText().toString().isEmpty() && editNota1.getText().toString().isEmpty() && editNota2.getText().toString().isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Complete os campos e não feche o app";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {
            objetoAluno.setNome(editNome.getText().toString());
            objetoAluno.setNota1(Double.parseDouble(editNota1.getText().toString()));
            objetoAluno.setNota2(Double.parseDouble(editNota2.getText().toString()));
            textViewResultado.setText(objetoAluno.toString());
        }

    }
}