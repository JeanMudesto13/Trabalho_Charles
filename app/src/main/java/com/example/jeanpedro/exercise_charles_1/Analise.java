package com.example.jeanpedro.exercise_charles_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Analise extends AppCompatActivity {

    TextView txtNomeIdade;
    ImageView ivPhoto   ;

    ArrayList<String> photos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise);

        txtNomeIdade = findViewById(R.id.txtNomeIdade);
        ivPhoto = findViewById(R.id.ivPhoto);

        photos.add("memeone");
        photos.add("memetwo");
        photos.add("memethree");
        photos.add("memeFour");

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");

        txtNomeIdade.setText(name + ": " + age);
    }

    public void onPhotoClick(View view) {
        Intent capPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(capPhoto, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1 && resultCode == RESULT_OK) {
            Bitmap img = (Bitmap) data.getExtras().get("data");
            ivPhoto.setImageBitmap(img);
        }

    }

    public void sortearPhoto(){
        Random rdn = new Random();
        int min = 1;
        int max = 4;
        int sorteio = rdn.nextInt(max - min) + min;
        photos.get(sorteio);

    }

}