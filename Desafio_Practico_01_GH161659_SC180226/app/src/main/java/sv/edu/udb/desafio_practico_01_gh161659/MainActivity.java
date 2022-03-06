package sv.edu.udb.desafio_practico_01_gh161659;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText newUser, newPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newUser = findViewById(R.id.txtNewUser);
        newPass = findViewById(R.id.txtNewPass);
    }

    public void openLogin(View v)
    {
        Intent llamar = new Intent(this, Login.class);
        startActivity(llamar);
    }
    public void NewAccount(View v){
        try
        {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"desafioPracticoDSM", null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String saveUser = newUser.getText().toString();
            String savePass = newPass.getText().toString();
            if(saveUser.length()!=0 && savePass.length()!=0) //verificamos que no haya  campos vacíos
            {
                Cursor isUniqueUser = bd.rawQuery("SELECT * FROM UserAccounts WHERE user = '"+saveUser+"'", null);
                if(!isUniqueUser.moveToFirst()) //verificamos que el usuario no exista en la BD
                {
                    ContentValues newData = new ContentValues();
                    newData.put("user", saveUser);
                    newData.put("password", savePass);
                    bd.insert("UserAccounts", null, newData);
                    bd.close();
                    newUser.setText("");
                    newPass.setText("");
                    Toast.makeText(this, "¡El usuario fue creado con Éxito!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Ese usuario ya existe, ingrese uno diferente", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "No deje campos vacios", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Toast.makeText(this, "Ha ocurrido un Error", Toast.LENGTH_SHORT).show();
        }

    }
}