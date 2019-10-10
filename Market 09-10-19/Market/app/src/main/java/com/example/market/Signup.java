package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.market.classes.connectionDB;

public class Signup extends AppCompatActivity {

    EditText EMAIL;
    EditText PASSWORD;
    EditText FIRSTNAME;
    EditText LASTNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Call id's
        EMAIL = findViewById(R.id.idEmail);
        FIRSTNAME = findViewById(R.id.idFname);
        LASTNAME = findViewById(R.id.idLname);
        PASSWORD = findViewById(R.id.idPasswd);
    }

    public void Register(View view){
        //1. Create Database manager
        connectionDB manager = new connectionDB(this,"data",null,1);
        //2. Let Database Read/Write
        SQLiteDatabase market = manager.getWritableDatabase();
        //3. Get values/text/numbers
        String Email = EMAIL.getText().toString();
        String Passwd = PASSWORD.getText().toString();
        String Lname = LASTNAME.getText().toString();
        String Fname = FIRSTNAME.getText().toString();

        //***Validate: Do not repeat email
        //Call validateEmail function/method
        //boolean status = validateEmail();

        //4. Validate empty data AND Create Content Values
        if(!Email.isEmpty() && !Passwd.isEmpty() && //si los datos no estan vacios
                !Lname.isEmpty() && !Fname.isEmpty()) {

            Cursor row = market.rawQuery("SELECT email" +
                    "FROM users WHERE email = '"+Email +"'"
                    ,null);
            //if(row.getCount()<1) //<1:no encontro nada
            if(!row.moveToFirst()){
                ContentValues DATA = new ContentValues();
                //5. Create data pack
                DATA.put("email", Email);
                DATA.put("password", Passwd);
                DATA.put("firstname", Fname);
                DATA.put("lastname", Lname);
                //6. Save data into market Database
                market.insert("users", null, DATA);
                Toast.makeText(this, "The user has been created !!!",
                        Toast.LENGTH_SHORT).show();
                //7. Close connection
                market.close();
            }else{
                Toast.makeText(this, "The user already exists.",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "You must complete all fields.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    /*
    public boolean validateEmail(View view){
        connectionDB manager = new connectionDB(this,"data",
                null,1);
        SQLiteDatabase market = manager.getWritableDatabase();
        String Email = EMAIL.getText().toString();

        Cursor row = market.rawQuery("SELECT email" +
                "FROM users WHERE email = "+Email,null);

        if(row.moveToFirst()){
            return true;
        }else{
            return false;
        }
    } */
}
