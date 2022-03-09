package sv.edu.udb.desafio_practico_01_gh161659;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void OpenEjercicio3(View v)
    {
        Intent llamar = new Intent(this, Ejercicio3.class);
        startActivity(llamar);

    }

    public void closeMenu(View v)
    {
        finish();
    }

}