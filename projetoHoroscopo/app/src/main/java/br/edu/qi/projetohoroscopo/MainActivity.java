package br.edu.qi.projetohoroscopo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome, editTextDia1, editTextMes1, editTextAno1, editTextDia2, editTextMes2, editTextAno2;
    Button buttonVerificar;
    TextView textViewResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextDia1 = findViewById(R.id.editTextDia1);
        editTextMes1 = findViewById(R.id.editTextMes1);
        editTextAno1 = findViewById(R.id.editTextAno1);
        editTextDia2 = findViewById(R.id.editTextDia2);
        editTextMes2 = findViewById(R.id.editTextMes2);
        editTextAno2 = findViewById(R.id.editTextAno2);
        buttonVerificar = findViewById(R.id.buttonVerificar);
        textViewResposta = findViewById(R.id.textViewResposta);
    }
    public void mostrarDadosDoVendedor(View view) {
        Horoscopo objetoHoroscopo = new Horoscopo();
        if (editTextNome.getText().toString().isEmpty() || editTextDia1.getText().toString().isEmpty() || editTextMes1.getText().toString().isEmpty()
                || editTextAno1.getText().toString().isEmpty() || editTextDia2.getText().toString().isEmpty() || editTextMes2.getText().toString().isEmpty()
                || editTextAno2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_SHORT).show();
        } else {
            objetoHoroscopo.setNome(editTextNome.getText().toString());
            objetoHoroscopo.setDiaDeNascimento(Byte.parseByte((editTextDia1.getText().toString())));
            objetoHoroscopo.setMesDeNascimento(Byte.parseByte((editTextMes1.getText().toString())));
            objetoHoroscopo.setAnoDeNascimento(Integer.parseInt((editTextAno1.getText().toString())));
            objetoHoroscopo.setDiaAtual(Byte.parseByte((editTextDia2.getText().toString())));
            objetoHoroscopo.setMesAtual(Byte.parseByte((editTextMes2.getText().toString())));
            objetoHoroscopo.setAnoAtual(Integer.parseInt((editTextAno2.getText().toString())));
            textViewResposta.setText(objetoHoroscopo.toString());
        }
        if (objetoHoroscopo.validarData() && objetoHoroscopo.validarDataAtual()){
            textViewResposta.setText(objetoHoroscopo.toString());
        }else{
            textViewResposta.setText("Data inválida!");
        }

    }
}