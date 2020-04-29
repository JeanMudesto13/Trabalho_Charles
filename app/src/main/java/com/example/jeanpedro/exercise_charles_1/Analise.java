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

    static final int REQUEST_IMAGE_CAPTURE = 1;
    TextView txtNomeIdade;
    TextView edMeme;

    ArrayList<String> photos = new ArrayList<String>();
    ImageView ivPhoto ;
    ImageView ivPhotoMeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise);

        edMeme = findViewById(R.id.edMeme);
        txtNomeIdade = findViewById(R.id.txtNomeIdade);
        ivPhoto = findViewById(R.id.ivPhoto);
        ivPhotoMeme = findViewById(R.id.ivPhotoMeme);

        photos.add("memeone");
        photos.add("memetwo");
        photos.add("memethree");
        photos.add("memeFour");

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");

        txtNomeIdade.setText(name + ": " + age);


        edMeme.setText("");


    }
    public void sortearPhoto(){

        Random rdn = new Random();
        int max = 4;
        int sorteio = rdn.nextInt(max);

        this.photos(sorteio);
        edMeme.setText("Este é o meme que se parece com você:" );


    }

    public void onPhotoClick(View view) {
        Intent capPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(capPhoto, 1);

    }

    public void photos(int sortear){
        switch (sortear) {
            case 0:
                ivPhotoMeme.setImageDrawable(getResources().getDrawable(R.drawable.memeone));
            break;
            case 1:
                ivPhotoMeme.setImageDrawable(getResources().getDrawable(R.drawable.memetwo));
            break;
            case 2:
                ivPhotoMeme.setImageDrawable(getResources().getDrawable(R.drawable.memethree));
                break;
            case 3:
                ivPhotoMeme.setImageDrawable(getResources().getDrawable(R.drawable.memefour));
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap img = (Bitmap) data.getExtras().get("data");
            ivPhoto.setImageBitmap(img);
            this.sortearPhoto();
        }

    }

}