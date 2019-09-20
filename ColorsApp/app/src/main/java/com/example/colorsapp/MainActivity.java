package com.example.colorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    //1. Inicializar componentes -> Null
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColors = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Get components ids - capturar los id's
        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        vieColors = findViewById(R.id.vieColors);

        //habilitar el componente view para que cuando mantenga el touch presionado funcione como menu contextual
        //3. Enable View component as ContextMenu
        registerForContextMenu(vieColors);

        //4.Get seekbar progress value - Obtener el valor del progreso de los seekbar
        //dentro de los () de listener estamos invocando la implementacion

        //CAPTUE LA INFORMACION DEL ELEMENTO
        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        //5. Change colors - cambiar colores
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int colorHex = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(colorHex);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
