package sv.edu.udb.desafio_practico_01_gh161659;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio3 extends AppCompatActivity {

    private EditText txtEnterVoto;
    private TextView txtC1, txtC2, txtC3, txtC4;
    private TextView txtC1P, txtC2P, txtC3P, txtC4P, txtGanador, txtTotalVotos, txtNulos;
    int c1=0, c2=0, c3=0, c4=0 ,goodVote=0, nullVote=0, totalVote=0, vote=0; //variables a utilizar para contavilizar los votos
    double percent1, percent2, percent3, percent4, percentNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        txtEnterVoto=(EditText) findViewById(R.id.txtEnterVoto);
        txtC1=(TextView) findViewById(R.id.txtC1);
        txtC2=(TextView) findViewById(R.id.txtC2);
        txtC3=(TextView) findViewById(R.id.txtC3);
        txtC4=(TextView) findViewById(R.id.txtC4);
        txtC1P=(TextView) findViewById(R.id.txtC1P);
        txtC2P=(TextView) findViewById(R.id.txtC2P);
        txtC3P=(TextView) findViewById(R.id.txtC3P);
        txtC4P=(TextView) findViewById(R.id.txtC4P);
        txtGanador =(TextView) findViewById(R.id.txtGanador);
        txtTotalVotos =(TextView) findViewById(R.id.txtTotalVotos);
        txtNulos =(TextView) findViewById(R.id.txtNulos);


    }


    public void Votar(View v)
    {

        String winner="";
        String enterVotos=txtEnterVoto.getText().toString();
        vote =Integer.parseInt(enterVotos);


            if (vote ==1)
            {
                c1++;
                Toast.makeText(this, "¡Voto realizado correctamente!" , Toast.LENGTH_SHORT).show();
                txtEnterVoto.setText("");
            }
            else if (vote ==2)
            {

                c2++;
                Toast.makeText(this, "¡Voto realizado correctamente!" , Toast.LENGTH_SHORT).show();
                txtEnterVoto.setText("");
            }
            else if (vote ==3)
            {

                c3++;
                Toast.makeText(this, "¡Voto realizado correctamente!" , Toast.LENGTH_SHORT).show();
                txtEnterVoto.setText("");
            }
            else if (vote ==4)
            {

                c4++;
                Toast.makeText(this, "¡Voto realizado correctamente!" , Toast.LENGTH_SHORT).show();
                txtEnterVoto.setText("");
                }
            else if (vote ==0)
            {

                totalVote=c1+c2+c3+c4;
                percent1 =(c1*100)/totalVote;
                percent2=(c2*100)/totalVote;
                percent3=(c3*100)/totalVote;
                percent4=(c4*100)/totalVote;
                percentNull=(nullVote*100)/totalVote;
                //candidato 1
                txtC1.setText(c1 + " votos");
                txtC2.setText(c2 + " votos");
                txtC3.setText( c3 + " votos");
                txtC4.setText(c4 + " votos");
                txtTotalVotos.setText(totalVote + " Votos");
                txtNulos.setText(nullVote + " Votos");
                txtC1P.setText(Math.round(percent1) + "%");
                txtC2P.setText(Math.round(percent2) + "%");
                txtC3P.setText( Math.round(percent3) + "%");
                txtC4P.setText(Math.round(percent4) + "%");
                txtEnterVoto.setText("");

                if (c1 > c2 && c1 > c3 && c1 >c4)
                {
                    txtGanador.setText("Gano C1");
                }
                else if (c2 > c1 && c2 > c3 && c2 >c4)
                {
                    txtGanador.setText("Gano C2");

                }
                else if (c3 > c2 && c3 > c1 && c3 >c4)
                {
                    txtGanador.setText("Gano C3");
                }
                else if (c4 > c2 && c4 > c3 && c4 >c1)
                {
                    txtGanador.setText("Gano C4");
                }
                else{
                    txtGanador.setText("No hubo ganador");
                }



                //Toast.makeText(this, "¡entra if 0!" , Toast.LENGTH_SHORT).show();
            }
            else
            {
                nullVote++;
                txtEnterVoto.setText("");
                Toast.makeText(this, "¡Voto no realizado correctamente!" , Toast.LENGTH_SHORT).show();
            }
         }
         public void Reiniciar(View v)
         {
             //reiniciamos los valores a 0
             c1=0;
             c2=0;
         c3=0;
         c4=0;
         goodVote=0;
         nullVote=0;
         totalVote=0;
         vote=0; //variables a utilizar para contavilizar los votos

             txtC1.setText("");
             txtC2.setText("");
             txtC3.setText("");
             txtC4.setText("");
             txtC1P.setText("");
             txtC2P.setText( "");
             txtC3P.setText( "");
             txtC4P.setText("");
             txtEnterVoto.setText("");
             txtNulos.setText("");
             txtGanador.setText("");
             txtTotalVotos.setText("");
         }
}