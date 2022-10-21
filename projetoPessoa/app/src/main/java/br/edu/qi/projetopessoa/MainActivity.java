package br.edu.qi.projetopessoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumberDecimal;
    EditText editTextNumberSigned;
    EditText editTextNumberDecimal2;
    Button button;
    TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        editTextNumberSigned = findViewById(R.id.editTextNumberSigned);
        editTextNumberDecimal2 = findViewById(R.id.editTextNumberDecimal2);
        button = findViewById(R.id.button);
        textViewResultado = findViewById(R.id.textViewResultado);
    }
    public void mostrarDados(View view) {
        Pessoa objetoPessoa = new Pessoa();
        if (editTextNumberDecimal.getText().toString().isEmpty() ||
                editTextNumberSigned.getText().toString().isEmpty() ||
                editTextNumberDecimal2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_SHORT).show();
        } else {
            objetoPessoa.setAltura(Double.parseDouble(editTextNumberDecimal.getText().toString()));
            objetoPessoa.setSexo(Byte.parseByte((editTextNumberSigned.getText().toString())));
            objetoPessoa.setPesoAtual(Double.parseDouble(editTextNumberDecimal2.getText().toString()));
            textViewResultado.setText(objetoPessoa.toString());
        }
    }
}