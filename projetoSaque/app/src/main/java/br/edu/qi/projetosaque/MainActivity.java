package br.edu.qi.projetosaque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textViewResultado;
    TextView textViewCaixa;
    EditText editTextValor;
    Button buttonCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResultado = findViewById(R.id.textViewResultado);
        textViewCaixa = findViewById(R.id.textViewCaixa);
        editTextValor = findViewById(R.id.editTextValor);
        buttonCalcular = findViewById(R.id.buttonCalcular);
    }
    public void mostrarDadosDoSaque(View view) {
        Saque objetoSaque = new Saque();
        if (editTextValor.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_SHORT).show();
        } else {
            objetoSaque.setValor(Integer.parseInt(editTextValor.getText().toString()));
            textViewResultado.setText(objetoSaque.toString());
        }
    }
}