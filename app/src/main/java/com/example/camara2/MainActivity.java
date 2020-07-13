package com.example.camara2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private final int PICTURE_ACTIVITY_CODE = 1;
    private final String FILENAME = "sdcard/photo.jpg";
    private File mFile;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCamara2 = findViewById(R.id.btnCamara2);
        Button btnCamaraImplicita = findViewById(R.id.btnCamaraIntentImplicito);

        btnCamara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camaraImplicita = new Intent(getApplicationContext(), Camara2.class);
                startActivity(camaraImplicita);
            }
        });

        btnCamaraImplicita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camaraImplicita = new Intent(getApplicationContext(), CamaraIntentImplicito.class);
                startActivity(camaraImplicita);
            }
        });
    }





}