package sv.edu.udb.desafio_practico_01_gh161659;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarEcuacion extends AppCompatActivity {

    Double a, b, c;
    Double x1;
    Double x2;
    Double discriminante;
    Double raiz;
    Double parteReal, parteImaginaria;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ecuacion);

        TextView txtSalidaPrimero = (TextView) findViewById(R.id.txtPrimera);
        TextView txtSalidaSegundo = (TextView) findViewById(R.id.txtSegunda);
        TextView txtOcultar=(TextView) findViewById(R.id.textView6);

        Button btnRegresar = (Button) findViewById(R.id.btnRegresar);

        Bundle ecuaciones = this.getIntent().getExtras();

        a = Double.parseDouble(ecuaciones.getString("A"));
        b = Double.parseDouble(ecuaciones.getString("B"));
        c = Double.parseDouble(ecuaciones.getString("C"));

         discriminante = Math.pow(b, 2) - 4 * a * c;
        if (discriminante >= 0) {
            if (discriminante == 0) {
                x1 = -b / (2 * a);
                txtSalidaPrimero.setText("La Raíz es Unica: " +x1.toString());
                txtSalidaSegundo.setText("");
                txtOcultar.setText("");
            } else {
                x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                txtSalidaPrimero.setText(x1.toString());
                txtSalidaSegundo.setText(x2.toString());
            }
        } else {
            discriminante = Math.abs(discriminante);
            parteReal = -b / (2 * a);
            parteImaginaria = Math.sqrt(discriminante) / (2 * a);
            txtSalidaPrimero.setText(parteReal+" + "+ parteImaginaria);
            txtSalidaSegundo.setText(parteReal+" - "+ parteImaginaria);
        }



        //Evento Boton Regresar

btnRegresar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Intent intent= new Intent(MostrarEcuacion.this,Ecuacion.class);
    }
});













    }
}