package br.edu.qi.projetovendedor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextValorVendido;
    EditText editTextMeta;
    Button buttonCalcularComissao;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        editTextValorVendido = findViewById(R.id.editTextValorVendido);
        editTextMeta = findViewById(R.id.editTextMeta);
        buttonCalcularComissao = findViewById(R.id.buttonCalcularComissao);
        textViewResultado = findViewById(R.id.textViewResultado);
    }

    public void mostrarDadosDoVendedor(View view) {
        Vendedor objetoVendedor = new Vendedor();
        if (editTextNome.getText().toString().isEmpty() || editTextValorVendido.getText().toString().isEmpty() || editTextMeta.getText().toString().isEmpty()) {
            Toast.makeText(this, "Complete os campos", Toast.LENGTH_SHORT).show();
        } else {
            objetoVendedor.setNome(editTextNome.getText().toString());
            objetoVendedor.setValorVendido(Float.parseFloat(editTextValorVendido.getText().toString()));
            objetoVendedor.setMeta(Float.parseFloat(editTextMeta.getText().toString()));
            textViewResultado.setText(objetoVendedor.toString());
        }
    }

}