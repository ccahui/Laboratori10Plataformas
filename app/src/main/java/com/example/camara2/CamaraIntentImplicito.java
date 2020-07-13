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

public class CamaraIntentImplicito extends AppCompatActivity {

    private final int PICTURE_ACTIVITY_CODE = 1;
    private final String FILENAME = "sdcard/photo.jpg";
    private File mFile;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara_intent_implicito);
        setTitle("Camara Intent Implicito");

        solicitarPermisosDeCamara();

        Button btnTomarFoto = findViewById(R.id.btnTomarFoto);
        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFoto();
            }
        });
    }

    private void tomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mFile = new File(FILENAME);

        Uri outputFileUri = Uri.fromFile(mFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, PICTURE_ACTIVITY_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_ACTIVITY_CODE) {
            if (resultCode == RESULT_OK) {
                visualizarFotoTomada();
            }
        }
    }

    public void visualizarFotoTomada() {
        ImageView imageView = findViewById(R.id.imageViewFoto);
        // Dejar de Mostrar la foto anterior
        imageView.setImageURI(null);
        // Mostrar la ultima foto tomada
        Uri inputFileUri = Uri.fromFile(mFile);
        imageView.setImageURI(inputFileUri);
    }

    public void solicitarPermisosDeCamara() {
        if (ContextCompat.checkSelfPermission(CamaraIntentImplicito.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CamaraIntentImplicito.this,
                    new String[]{Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }
}