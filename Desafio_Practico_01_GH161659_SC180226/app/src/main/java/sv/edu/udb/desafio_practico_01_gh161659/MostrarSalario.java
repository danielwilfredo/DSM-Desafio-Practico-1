package sv.edu.udb.desafio_practico_01_gh161659;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.annotation.Retention;

public class MostrarSalario extends AppCompatActivity {

    private Integer Horas1,Horas2,Horas3;
    private String Cargo1,Cargo2,Cargo3;
    private String Nombre1,Apellido1,Nombre2,Apellido2,Nombre3,Apellido3;
    private Double SalarioB1,SalarioB2,SalarioB3;
    private Double AFP1,AFP2,AFP3,ISSS1,ISSS2,ISSS3,Renta1,Renta2,Renta3;
    private Double SalarioL1,SalarioL2,SalarioL3;
    String C1="Gerente";
    String C2="Asistente";
    String C3="Secretaria";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_salario);

        TextView TxtNombre1 = (TextView) findViewById(R.id.ResultadoNombre1);
        TextView TxtSalarioBruto1 = (TextView) findViewById(R.id.ResultadoSalarioBruto1);
        TextView TxtAFP1 = (TextView) findViewById(R.id.ResultadoAFP1);
        TextView TxtISSS1 = (TextView) findViewById(R.id.ResultadoISSS1);
        TextView TxtRenta1 = (TextView) findViewById(R.id.ResultadoRenta1);
        TextView TxtSalarioLiquido1 = (TextView) findViewById(R.id.ResultadoSueldoLiquid1);
        ImageView ImagenMas1 = (ImageView) findViewById(R.id.imagenMas_1);
        ImageView ImagenMenos1 = (ImageView) findViewById(R.id.imagenMenos_1);
        ImageView ImagenTrecien1 = (ImageView) findViewById(R.id.imagenTres_1);


        TextView TxtNombre2 = (TextView) findViewById(R.id.ResultadoNombre2);
        TextView TxtSalarioBruto2 = (TextView) findViewById(R.id.ResultadoSalarioBruto2);
        TextView TxtAFP2 = (TextView) findViewById(R.id.ResultadoAFP2);
        TextView TxtISSS2 = (TextView) findViewById(R.id.ResultadoISSS2);
        TextView TxtRenta2 = (TextView) findViewById(R.id.ResultadoRenta2);
        TextView TxtSalarioLiquido2 = (TextView) findViewById(R.id.ResultadoSueldoLiquid2);
        ImageView ImagenMas2 = (ImageView) findViewById(R.id.imagenMas_2);
        ImageView ImagenMenos2 = (ImageView) findViewById(R.id.imagenMenos_2);
        ImageView ImagenTrecien2 = (ImageView) findViewById(R.id.imagenTres_2);

        TextView TxtNombre3 = (TextView) findViewById(R.id.ResultadoNombre3);
        TextView TxtSalarioBruto3 = (TextView) findViewById(R.id.ResultadoSalarioBruto3);
        TextView TxtAFP3 = (TextView) findViewById(R.id.ResultadoAFP3);
        TextView TxtISSS3 = (TextView) findViewById(R.id.ResultadoISSS3);
        TextView TxtRenta3 = (TextView) findViewById(R.id.ResultadoRenta3);
        TextView TxtSalarioLiquido3 = (TextView) findViewById(R.id.ResultadoSueldoLiquid3);
        ImageView ImagenMas3 = (ImageView) findViewById(R.id.imagenMas_3);
        ImageView ImagenMenos3 = (ImageView) findViewById(R.id.imagenMenos_3);
        ImageView ImagenTrecien3 = (ImageView) findViewById(R.id.imagenTres_3);

        ImageView ImagenSinBono = (ImageView) findViewById(R.id.imageSinBono);
        Button BtnRegresarSalario = (Button) findViewById(R.id.btn_RegresarSalario);

        Bundle salarios = this.getIntent().getExtras();

        Nombre1=salarios.getString("NOMBRE1");
        Nombre2=salarios.getString("NOMBRE2");
        Nombre3=salarios.getString("NOMBRE3");
        Apellido1=salarios.getString("APELLIDO1");
        Apellido2=salarios.getString("APELLIDO2");
        Apellido3=salarios.getString("APELLIDO3");
        Cargo1=salarios.getString("COMBO1");
        Cargo2=salarios.getString("COMBO2");
        Cargo3=salarios.getString("COMBO3");
        Horas1=salarios.getInt("HORAS1");
        Horas2=salarios.getInt("HORAS2");
        Horas3=salarios.getInt("HORAS3");

        TxtNombre1.setText(Nombre1+" "+Apellido1+" - "+Cargo1);
        TxtNombre1.setText(Nombre2+" "+Apellido2+" - "+Cargo2);
        TxtNombre1.setText(Nombre3+" "+Apellido3+" - "+Cargo3);

        SalarioB1=GetSalarioBruto(Horas1);
        SalarioB2=GetSalarioBruto(Horas2);
        SalarioB3=GetSalarioBruto(Horas3);

        AFP1=GetAFP(SalarioB1);
        AFP2=GetAFP(SalarioB2);
        AFP3=GetAFP(SalarioB3);

        ISSS1=GetISSS(SalarioB1);
        ISSS2=GetISSS(SalarioB2);
        ISSS3=GetISSS(SalarioB3);

        Renta1=GetRenta(SalarioB1);
        Renta2=GetRenta(SalarioB2);
        Renta3=GetRenta(SalarioB3);

        TxtSalarioBruto1.setText("$"+(Math.round((SalarioB1*100d))/100d));
        TxtSalarioBruto2.setText("$"+(Math.round((SalarioB2*100d))/100d));
        TxtSalarioBruto3.setText("$"+(Math.round((SalarioB3*100d))/100d));

        TxtAFP1.setText("$"+(Math.round((AFP1*100d))/100d));
        TxtAFP2.setText("$"+(Math.round((AFP2*100d))/100d));
        TxtAFP3.setText("$"+(Math.round((AFP3*100d))/100d));

        TxtISSS1.setText("$"+(Math.round((ISSS1*100d))/100d));
        TxtISSS2.setText("$"+(Math.round((ISSS2*100d))/100d));
        TxtISSS3.setText("$"+(Math.round((ISSS3*100d))/100d));

        TxtRenta1.setText("$"+(Math.round((Renta1*100d))/100d));
        TxtRenta2.setText("$"+(Math.round((Renta2*100d))/100d));
        TxtRenta3.setText("$"+(Math.round((Renta3*100d))/100d));

        SalarioL1=SalarioB1-AFP1-ISSS1-Renta1;
        SalarioL2=SalarioB2-AFP2-ISSS2-Renta2;
        SalarioL3=SalarioB3-AFP3-ISSS3-Renta3;

        if (Cargo1.equals(C1) && Cargo2.equals(C2) && Cargo3.equals(C3)){
            Toast.makeText(MostrarSalario.this, "NO HAY BONO", Toast.LENGTH_LONG).show();
            ImagenSinBono.setVisibility(View.VISIBLE);
        }
        else{
            SalarioL1=GetBono(SalarioL1,Cargo1);
            SalarioL2=GetBono(SalarioL2,Cargo2);
            SalarioL3=GetBono(SalarioL3,Cargo3);
            ImagenSinBono.setVisibility(View.INVISIBLE);
        }
        TxtSalarioLiquido1.setText("$"+(Math.round((SalarioL1*100d))/100d));
        TxtSalarioLiquido2.setText("$"+(Math.round((SalarioL2*100d))/100d));
        TxtSalarioLiquido3.setText("$"+(Math.round((SalarioL3*100d))/100d));


        if (SalarioL1>300){
            ImagenTrecien1.setVisibility(View.VISIBLE);
        }
        else {
            ImagenTrecien1.setVisibility(View.INVISIBLE);

        }
        if (SalarioL2>300){
            ImagenTrecien2.setVisibility(View.VISIBLE);

        }
        else {
                ImagenTrecien2.setVisibility(View.INVISIBLE);
        }
        if (SalarioL3>300){
            ImagenTrecien3.setVisibility(View.VISIBLE);

        }
        else {
            ImagenTrecien3.setVisibility(View.INVISIBLE);
        }



        if(SalarioL1<SalarioL2 && SalarioL1<SalarioL3){
            ImagenMenos1.setVisibility(View.VISIBLE);
            ImagenMenos2.setVisibility(View.INVISIBLE);
            ImagenMenos3.setVisibility(View.INVISIBLE);
            if (SalarioL2 > SalarioL3) {
                ImagenMas1.setVisibility(View.INVISIBLE);
                ImagenMas2.setVisibility(View.VISIBLE);
                ImagenMas3.setVisibility(View.INVISIBLE);

            }
            else
            {
                ImagenMas1.setVisibility(View.INVISIBLE);
                ImagenMas2.setVisibility(View.INVISIBLE);
                ImagenMas3.setVisibility(View.VISIBLE);
            }
        }
        else if (SalarioL2<SalarioL1 && SalarioL2<SalarioL3){
            ImagenMenos1.setVisibility(View.INVISIBLE);
            ImagenMenos2.setVisibility(View.VISIBLE);
            ImagenMenos3.setVisibility(View.INVISIBLE);
            if (SalarioL1 > SalarioL3) {
                ImagenMas1.setVisibility(View.VISIBLE);
                ImagenMas2.setVisibility(View.INVISIBLE);
                ImagenMas3.setVisibility(View.INVISIBLE);

            }
            else
            {
                ImagenMas1.setVisibility(View.INVISIBLE);
                ImagenMas2.setVisibility(View.INVISIBLE);
                ImagenMas3.setVisibility(View.VISIBLE);
            }
        }
        else if (SalarioL3<SalarioL1 && SalarioL3<SalarioL1){
            ImagenMenos1.setVisibility(View.INVISIBLE);
            ImagenMenos2.setVisibility(View.INVISIBLE);
            ImagenMenos3.setVisibility(View.VISIBLE);
            if (SalarioL2 > SalarioL1) {
                ImagenMas1.setVisibility(View.INVISIBLE);
                ImagenMas2.setVisibility(View.VISIBLE);
                ImagenMas3.setVisibility(View.INVISIBLE);

            }
            else
            {
                ImagenMas1.setVisibility(View.VISIBLE);
                ImagenMas2.setVisibility(View.INVISIBLE);
                ImagenMas3.setVisibility(View.INVISIBLE);
            }
        }
        else{

        }


        BtnRegresarSalario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MostrarSalario.this,CalculoPago.class);
                startActivity(intent);
            }
        });


    }

    public Double GetSalarioBruto(int horas){
        Double Salario;
        if (horas<=160){
            Salario = horas*(9.75);
            return Salario;
        }
        else if (horas > 160){
            Integer NuevasHoras=Math.abs(horas-160);
            Salario=160*(9.75)+NuevasHoras*(11.50);
            return Salario;
        }
        else{
            return 0.00;
        }

    }
    public Double GetAFP(Double SueldoBase){
        Double AFP=SueldoBase*0.0525;
        return AFP;
    }
    public Double GetISSS(Double SueldoBase){
        Double ISSS = SueldoBase*0.0688;
        return ISSS;

    }
    public Double GetRenta(Double SueldoBase){
        Double Renta = SueldoBase*0.10;
        return Renta;
    }
    public Double GetBono(Double Salario,String Cargo){
        Double NuevoSalarioLiquid;
        if (Cargo.equals(C1)){
            NuevoSalarioLiquid=Salario+(Salario*0.10);
            return NuevoSalarioLiquid;
        }
        else if (Cargo.equals(C2)){
            NuevoSalarioLiquid=Salario+(Salario*0.05);
            return NuevoSalarioLiquid;
        }
        else if (Cargo.equals(C3)){
            NuevoSalarioLiquid=Salario+(Salario*0.03);
            return NuevoSalarioLiquid;
        }
        else{
            NuevoSalarioLiquid=Salario+(Salario*0.02);
            return NuevoSalarioLiquid;
        }

    }


}