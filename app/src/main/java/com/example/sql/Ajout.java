package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ajout extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    EditText userId, title, body;
    Button btnajout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
    }
    private void init(){
        title=findViewById(R.id.title);
        body=findViewById(R.id.body);
        btnajout=findViewById(R.id.ajouter);
    }
    public void onclickAjout(View view){
        init();
        databaseHelper = new DatabaseHelper(this);

        // Exemple d'utilisation des méthodes CRUD

        // Ajouter un utilisateur
        String titleTxt = title.getText().toString();
        String bodyTxt = body.getText().toString();
        User newUser = new User( titleTxt, bodyTxt);
        long id1 = databaseHelper.insertUser(newUser);



    }
}