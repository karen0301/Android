package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.market.classes.connectionDB;

public class signup extends AppCompatActivity {

    //AGREGAR LOS ELEMENTOS
    EditText EMAIL;
    EditText PASSWORD;
    EditText FIRSTNAME;
    EditText LASTNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //LLAMAR LOS ID'S cal id's
        EMAIL = findViewById(R.id.idEmail);
        //FIRSTNAME = findViewById(R.id.idFname);
        //LASTNAME = findViewById(R.id.idLname;
        //PASSWORD = findViewById(R.idPasswd);
    }

    public void Register(View view){
        //1. Crear el director de la base de datos, create database manager
        connectionDB manager = new connectionDB(this, "data", null, 1);
        //2. Permitir el read/writte de la base de datos, let Database Read/Write
        SQLiteDatabase market = manager.getReadableDatabase(); // que mi base de datos se pueda leer o escribir sobre ella
        //3. Get values/text/numbers
        String Email = EMAIL.getText().toString();//que de email que ya esta escrito obtenga el texto que reescribi
        String Passwd = "1234";
        String Lname = "McDonald";
        String Fname = "Peter";
        //4. Crear el contenedor de valores
        ContentValues DATA = new ContentValues(); //crea el contenedor
        // 5. Crear el paquete de datos, create data pack
        DATA.put("email", Email);
        DATA.put("password", Passwd);
        DATA.put("firstname", Fname);
        DATA.put("lastname", Lname);
        //6. Save data into market db, guardar los datos
        market.insert("users", null, DATA);
        Toast.makeText(this, "The user has been created!", Toast.LENGTH_LONG).show();
        //7. Close connection
        market.close();

    }
}
