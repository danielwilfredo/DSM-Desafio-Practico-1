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


public class Login extends AppCompatActivity {

    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
    }
    public void openCreateAccount(View v)
    {
        finish();
    }
    public void Login(View v)
    {
        try
        {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"desafioPracticoDSM", null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String userCheck = user.getText().toString();
            String passwordCheck = pass.getText().toString();
            if(userCheck.length()!=0 && passwordCheck.length()!=0) //No campos vacíos
            {
                Cursor userExist = bd.rawQuery("SELECT * FROM UserAccounts WHERE user = '"+userCheck+"'", null);
                if(userExist.moveToFirst()) //Comprobando que no exista ese usuario en la BD
                {
                    bd.close();
                    if(passwordCheck.trim().equals(userExist.getString(1).trim())) //comprobando contraseñas
                    {
                        Toast.makeText(this, "¡Bienvenid@ "+userExist.getString(0)+"!", Toast.LENGTH_SHORT).show();
                        Intent llamar = new Intent(this,menu.class);
                        startActivity(llamar);
                        this.finish();
                    }
                    else
                    {
                        Toast.makeText(this, "¡Contraseña Incorrecta!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "Ese no usuario no existe, ingrese credenciales válidas o cree una cuenta", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "Ingrese todos sus datos de inicio de sesión", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}