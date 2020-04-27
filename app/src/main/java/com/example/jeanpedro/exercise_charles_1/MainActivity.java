package com.example.jeanpedro.exercise_charles_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName;
    EditText edAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
    }

    public void onClick(View view) {
        String name = edName.getText().toString();
        String age = edAge.getText().toString();

        Intent chamarAnalise = new Intent(getApplicationContext(), Analise.class);

        chamarAnalise.putExtra( "name", name);
        chamarAnalise.putExtra( "age", age);
        startActivity(chamarAnalise);
    }

    public void salvar (String name,String age){
        SharedPreferences sp = getSharedPreferences("dados tela principal", MODE_PRIVATE);
        SharedPreferences.Editor editor =sp.edit();

        editor.putString("name", name);
        editor.putString("age", age);

        editor.apply();
    }

    public void carregar(){
        SharedPreferences sp = getSharedPreferences("dados tela principal", MODE_PRIVATE);
        String name = sp.getString("name","");
        String age = sp.getString("age","");

        edName.setText(name);
        edAge.setText(age);

    }
}
