package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modification extends AppCompatActivity {
    EditText id,userId, title, body;
    Button btnaModif;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
    }
    private void init(){
        id = findViewById(R.id.id);
        title=findViewById(R.id.title);
        body=findViewById(R.id.body);
        btnaModif=findViewById(R.id.ajouter);
    }
    public void onclickModif(View view){
        init();
        databaseHelper = new DatabaseHelper(this);

        // Exemple d'utilisation des méthodes CRUD



        // Modifier un utilisateur par ID
        int oldId = 1; // Ancien ID de l'utilisateur à modifier
        String titleTxt = title.getText().toString();
        String bodyTxt = body.getText().toString();
        User newUser = new User( titleTxt, bodyTxt);
         // Nouvel objet User avec les nouvelles valeurs
        int rowsAffected = databaseHelper.updateUser(Integer.parseInt(id.getText().toString()), newUser);

//        System.out.println("Nombre de lignes modifiées: " + rowsAffected);




    }
}