package sv.edu.udb.desafio_practico_01_gh161659;

import android.content.Intent;
import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class calculo_pago extends AppCompatActivity {

    private Spinner Combo1,Combo2,Combo3;
    private Button btnCalcular;
    private TextView TxtNombre1,TxtApellido1,TxtHoras1;
    private TextView TxtNombre2,TxtApellido2,TxtHoras2;
    private TextView TxtNombre3,TxtApellido3,TxtHoras3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_pago);


        btnCalcular=(Button) findViewById(R.id.btnCalcularSalario);
        Combo1 = (Spinner) findViewById(R.id.comboCargo1);
        Combo2 = (Spinner) findViewById(R.id.comboCargo2);
        Combo3 = (Spinner) findViewById(R.id.comboCargo3);

        TxtNombre1=(TextView)findViewById(R.id.txtNombre1);
        TxtApellido1=(TextView) findViewById(R.id.txtApellido1);
        TxtHoras1=(TextView) findViewById(R.id.txtHoras1);

        TxtNombre2=(TextView)findViewById(R.id.txtNombre2);
        TxtApellido2=(TextView) findViewById(R.id.txtApellido2);
        TxtHoras2=(TextView) findViewById(R.id.txtHoras2);

        TxtNombre3=(TextView)findViewById(R.id.txtNombre3);
        TxtApellido3=(TextView) findViewById(R.id.txtApellido3);
        TxtHoras3=(TextView) findViewById(R.id.txtHoras3);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TxtNombre1.setError(null);
                TxtNombre2.setError(null);
                TxtNombre3.setError(null);

                TxtApellido1.setError(null);
                TxtApellido2.setError(null);
                TxtApellido3.setError(null);

                TxtHoras1.setError(null);
                TxtHoras2.setError(null);
                TxtHoras3.setError(null);

                if ("".equals(TxtNombre1.getText().toString()))
                {
                    TxtNombre1.setError("Introducir un Nombre");
                    TxtNombre1.requestFocus();
                    return;
                }
                else  if ("".equals(TxtApellido1.getText().toString()))
                {
                    TxtApellido1.setError("Introducir un Apellido");
                    TxtApellido1.requestFocus();
                    return;
                }
                else if (Combo1.getSelectedItemPosition()==0) {
                    Toast.makeText(calculo_pago.this, "Seleccionar un Cargo en Primer Empleado", Toast.LENGTH_LONG).show();

                }
                else if ("".equals(TxtHoras1.getText().toString()))
                {
                    TxtHoras1.setError("Introducir Horas Trabajadas");
                    TxtHoras1.requestFocus();
                    return;
                }
                //---------------------------------------------------------------------------------------------------------------------------
                else if ("".equals(TxtNombre2.getText().toString()))
                {
                    TxtNombre2.setError("Introducir un Nombre");
                    TxtNombre2.requestFocus();
                    return;
                }
                else  if ("".equals(TxtApellido2.getText().toString()))
                {
                    TxtApellido2.setError("Introducir un Apellido");
                    TxtApellido2.requestFocus();
                    return;
                }
                else if (Combo2.getSelectedItemPosition()==0) {
                    Toast.makeText(calculo_pago.this, "Seleccionar un Cargo en Segundo Empleado", Toast.LENGTH_LONG).show();

                }
                else if ("".equals(TxtHoras2.getText().toString()))
                {
                    TxtHoras2.setError("Introducir Horas Trabajadas");
                    TxtHoras2.requestFocus();
                    return;
                }
                //---------------------------------------------------------------------------------------------------------------------------
                else if ("".equals(TxtNombre3.getText().toString()))
                {
                    TxtNombre3.setError("Introducir un Nombre");
                    TxtNombre3.requestFocus();
                    return;
                }
                else  if ("".equals(TxtApellido3.getText().toString()))
                {
                    TxtApellido3.setError("Introducir un Apellido");
                    TxtApellido3.requestFocus();
                    return;
                }
                else if (Combo3.getSelectedItemPosition()==0) {
                    Toast.makeText(calculo_pago.this, "Seleccionar un Cargo en Tercer Empleado", Toast.LENGTH_LONG).show();

                }
                else if ("".equals(TxtHoras3.getText().toString()))
                {
                    TxtHoras3.setError("Introducir Horas Trabajadas");
                    TxtHoras3.requestFocus();
                    return;
                }
                //---------------------------------------------------------------------------------------------------------------------------
                else{
                    Intent intent = new Intent(calculo_pago.this,mostrar_salario.class);
                    Bundle SalarioEmpleados = new Bundle();
                    SalarioEmpleados.putString("COMBO1",Combo1.getSelectedItem().toString());
                    SalarioEmpleados.putString("COMBO2",Combo2.getSelectedItem().toString());
                    SalarioEmpleados.putString("COMBO3",Combo3.getSelectedItem().toString());

                    SalarioEmpleados.putString("NOMBRE1",TxtNombre1.getText().toString());
                    SalarioEmpleados.putString("NOMBRE2",TxtNombre2.getText().toString());
                    SalarioEmpleados.putString("NOMBRE3",TxtNombre3.getText().toString());

                    SalarioEmpleados.putString("APELLIDO1",TxtApellido1.getText().toString());
                    SalarioEmpleados.putString("APELLIDO2",TxtApellido2.getText().toString());
                    SalarioEmpleados.putString("APELLIDO3",TxtApellido3.getText().toString());

                    SalarioEmpleados.putInt("HORAS1",Integer.parseInt(TxtHoras1.getText().toString()));
                    SalarioEmpleados.putInt("HORAS2",Integer.parseInt(TxtHoras2.getText().toString()));
                    SalarioEmpleados.putInt("HORAS3",Integer.parseInt(TxtHoras3.getText().toString()));

                    intent.putExtras(SalarioEmpleados);
                    startActivity(intent);
                }

            }
        });

    }
}