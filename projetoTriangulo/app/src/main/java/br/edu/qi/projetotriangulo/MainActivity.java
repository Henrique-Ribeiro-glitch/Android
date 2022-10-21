package br.edu.qi.projetotriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    EditText editTextNumber2;
    EditText editTextNumber3;
    EditText editTextNumber4;
    EditText editTextNumber5;
    EditText editTextNumber6;
    TextView textViewResultado;
    Button buttonClassificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumberDecimal);
        editTextNumber2 = findViewById(R.id.editTextNumberDecimal2);
        editTextNumber3 = findViewById(R.id.editTextNumberDecimal3);
        editTextNumber4 = findViewById(R.id.editTextNumberDecimal4);
        editTextNumber5 = findViewById(R.id.editTextNumberDecimal5);
        editTextNumber6 = findViewById(R.id.editTextNumberDecimal6);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonClassificar = findViewById(R.id.buttonClassificar);
    }
    public void mostrarDados(View view) {
        Triangulo objetoTriangulo = new Triangulo();
        if (editTextNumber.getText().toString().isEmpty() ||
                editTextNumber2.getText().toString().isEmpty() ||
                editTextNumber3.getText().toString().isEmpty() ||
                editTextNumber4.getText().toString().isEmpty() ||
                editTextNumber5.getText().toString().isEmpty() ||
                editTextNumber6.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_SHORT).show();
        } else {
            objetoTriangulo.setLadoA(Double.parseDouble(editTextNumber.getText().toString()));
            objetoTriangulo.setLadoB(Double.parseDouble(editTextNumber2.getText().toString()));
            objetoTriangulo.setLadoC(Double.parseDouble(editTextNumber3.getText().toString()));
            objetoTriangulo.setAnguloAB(Double.parseDouble(editTextNumber4.getText().toString()));
            objetoTriangulo.setAnguloBC(Double.parseDouble(editTextNumber5.getText().toString()));
            objetoTriangulo.setAnguloCA(Double.parseDouble(editTextNumber6.getText().toString()));
            textViewResultado.setText(objetoTriangulo.toString());
        }
    }
}