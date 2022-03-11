package sv.edu.udb.desafio_practico_01_gh161659;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ecuacion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);
        final EditText txt_a = (EditText) findViewById(R.id.editTexta);
        final EditText txt_b = (EditText) findViewById(R.id.editTextb);
        final EditText txt_c = (EditText) findViewById(R.id.editTextc);

        final Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_a.setError(null);
                txt_b.setError(null);
                txt_c.setError(null);
                String Validar_a = txt_a.getText().toString();
                String Validar_b = txt_b.getText().toString();
                String Validar_c = txt_c.getText().toString();
                if ("".equals(Validar_a)){
                    txt_a.setError("Introduce un número");
                    txt_a.requestFocus();
                    return;
                }
                else if ("".equals(Validar_b))
                {
                    txt_b.setError("Introduce un número");
                    txt_b.requestFocus();
                    return;
                }
                else if ("".equals(Validar_c)){
                    txt_c.setError("Introduce un número");
                    txt_c.requestFocus();
                    return;
                }
                Integer ValidarNumero = Integer.parseInt(Validar_a);
                if (ValidarNumero==0){
                    txt_a.setError("El Numero no puede ser Cero");
                    txt_a.requestFocus();
                    return;
                }
                else{
                    Intent intent = new Intent(Ecuacion.this,MostrarEcuacion.class);
                    Bundle ecuaciones= new Bundle();
                    ecuaciones.putString("A",txt_a.getText().toString());
                    ecuaciones.putString("B",txt_b.getText().toString());
                    ecuaciones.putString("C",txt_c.getText().toString());
                    intent.putExtras(ecuaciones);
                    startActivity(intent);
                }


            }
        });


    }
}