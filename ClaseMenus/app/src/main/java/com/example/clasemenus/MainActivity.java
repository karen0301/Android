package com.example.clasemenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contact = findViewById(R.id.Id_contact); /*traer o llamar el id contacto*/
        registerForContextMenu(contact); /*Asigna el id contacto, cuando haga un touch sostenido abra el menú*/
    }
    //Show menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Options:");/*agrega un tìtulo al menu de opciones o acciones*/
        getMenuInflater().inflate(R.menu.opciones1, menu);
    }


    //Actions: menu options (acciones de las opciones de menus) MENU CONTEXTUAL


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {/*cuando precione un item*/


        switch (item.getItemId()){/*llama los items del menu*/
            case R.id.opt_1 :
                Toast.makeText(this, "Edit contact", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opt_2 :
                Toast.makeText(this, "Delete contact", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opt_3 :
                Toast.makeText(this, "Call contact", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opt_4 :
                Toast.makeText(this, "Share contact", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);

        }

    }
}
