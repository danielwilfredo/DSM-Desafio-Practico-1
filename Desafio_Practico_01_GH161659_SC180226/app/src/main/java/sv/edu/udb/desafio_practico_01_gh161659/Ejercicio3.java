package sv.edu.udb.desafio_practico_01_gh161659;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ejercicio3 extends AppCompatActivity {

    private EditText txtEnterVoto;
    int c1=0, c2=0, c3=0, c4=0 ,goodVoto=0, nullVoto=0, totalVotos=0, voto=0; //variables a utilizar para contavilizar los votos
    double porcent1, porcent2, porcent3, porcent4, porcentNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        txtEnterVoto=(EditText) findViewById(R.id.txtEnterVoto);
    }


    public void Votar(View v)
    {

        String winner="";
        String enterVotos=txtEnterVoto.getText().toString();
        voto=Integer.parseInt(enterVotos);


            txtEnterVoto.setText("");

            if (voto==1)
            {
                txtEnterVoto.setText("");
                c1++;
                Toast.makeText(this, "hace el cliccc" + c1 + " voto" , Toast.LENGTH_SHORT).show();
            }
            else if (voto==2)
            {
                txtEnterVoto.setText("");
                c2++;
            }
            else if (voto==3)
            {
                txtEnterVoto.setText("");
                c3++;
            }
            else if (voto==4)
            {
                txtEnterVoto.setText("");
                c4++;
                }
            else
            {
                nullVoto++;
                txtEnterVoto.setText("");
            }
            if (voto==0)
            {
                totalVotos=c1+c2+c3+c4+nullVoto;

                porcent1=(c1*100)/totalVotos;
                porcent2=(c2*100)/totalVotos;
                porcent3=(c3*100)/totalVotos;
                porcent4=(c4*100)/totalVotos;
                porcentNull=(nullVoto*100)/totalVotos;
            }


         }
}