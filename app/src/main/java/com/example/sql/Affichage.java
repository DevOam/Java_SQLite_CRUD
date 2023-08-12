package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Affichage extends AppCompatActivity {
    TextView id, title, body;
    EditText idEntree;
    Button afch;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        init();






    }
    private  void init(){
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        id=findViewById(R.id.id);
        afch=findViewById(R.id.afficher);
        idEntree=findViewById(R.id.idEntrer);
    }
    @SuppressLint("SetTextI18n")
    public void onclickAfficher(View view){

       init();

        databaseHelper = new DatabaseHelper(this);

        // Exemple d'utilisation des méthodes CRUD



        // Récupérer un utilisateur par ID
        User retrievedUser = databaseHelper.getUserById(Integer.parseInt(idEntree.getText().toString()));
        if (retrievedUser != null) {
            // Afficher les détails de l'utilisateur récupéré
//            System.out.println("ID: " + retrievedUser.getId());
//            System.out.println();
//            System.out.println();

            title.setText("Titre: " + retrievedUser.getTitle());
            body.setText("Contenu: " + retrievedUser.getBody());
        }

    }
}