package fr.example.moveball.view;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.example.moveball.R;
import fr.example.moveball.view.game.ActivityJeu;


public class ActivitePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_principale);
        //Initialisation des boutons onClickListener
        Button boutonCommentJouer = findViewById(R.id.commentJouer);
        boutonCommentJouer.setOnClickListener(
            v -> changeActivityCommentJouer()
            );
        Button boutonJouer = findViewById(R.id.jouer);
        boutonJouer.setOnClickListener(
            v -> changeActivityJouer()
            );
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
    }
*/
    void changeActivityCommentJouer() {
        Intent monIntent = new Intent(this, ActivityCommentJouer.class);
        startActivity(monIntent);
        setContentView(R.layout.activity_comment_jouer);
    }

    void changeActivityJouer() {
        Intent monIntent = new Intent(this, ActivityJeu.class);
        startActivity(monIntent);
        setContentView(R.layout.activity_jeu);
    }

}
