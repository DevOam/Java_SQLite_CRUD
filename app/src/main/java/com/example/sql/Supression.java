package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Supression extends AppCompatActivity {
    EditText id;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supression);
    }
    private void init(){
        id = findViewById(R.id.id);
    }
    public void onclickSupprim(View view){
        init();
        databaseHelper = new DatabaseHelper(this);

        // Exemple d'utilisation des méthodes CRUD



        // Supprimer un utilisateur par ID
        int idToDelete = Integer.parseInt(id.getText().toString()); // ID de l'utilisateur à supprimer
        int rowsDeleted = databaseHelper.deleteUser(idToDelete);
        System.out.println("Nombre de lignes supprimées: " + rowsDeleted);


    }
}