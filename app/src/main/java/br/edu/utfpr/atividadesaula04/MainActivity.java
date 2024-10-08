package br.edu.utfpr.atividadesaula04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valorEtanol, valorGasolina, consumoEtanol, consumoGasolina;
    private Button calcular, sair;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciaComponentes();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaCamposVazios();
                calcularResultado();
            }
        });

        sair.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "Segure esse botao para sair do aplicativo", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }
        });
    }

    public void verificaCamposVazios() {
        if (valorEtanol.getText().toString().isEmpty()) {
            valorEtanol.setError("Esse campo e obrigatorio");
        } else if (valorGasolina.getText().toString().isEmpty()) {
            valorGasolina.setError("Esse campo e obrigatorio");
        } else if (consumoEtanol.getText().toString().isEmpty()) {
            consumoEtanol.setError("Esse campo e obrigatorio");
        } else if (consumoGasolina.getText().toString().isEmpty()) {
            consumoGasolina.setError("Esse campo e obrigatorio");
        }
    }

    private void calcularResultado() {
        double divideValorEtanol = Double.parseDouble(valorEtanol.getText().toString()) / Double.parseDouble(consumoEtanol.getText().toString());
        double divideValorGasolina = Double.parseDouble(valorGasolina.getText().toString()) / Double.parseDouble(consumoGasolina.getText().toString());

        double resultadoCalculo = divideValorEtanol / divideValorGasolina;

        if (resultadoCalculo < 0.7) {
            resultado.setText("ETANOL");
        } else {
            resultado.setText("GASOLINA");
        }
    }

    private void iniciaComponentes() {
        valorEtanol = findViewById(R.id.valorEtanol);
        valorGasolina = findViewById(R.id.valorGasolina);
        consumoEtanol = findViewById(R.id.consumoEtanol);
        consumoGasolina = findViewById(R.id.consumoGasolina);
        calcular = findViewById(R.id.calcular);
        sair = findViewById(R.id.sair);
        resultado = findViewById(R.id.resultado);
    }
}