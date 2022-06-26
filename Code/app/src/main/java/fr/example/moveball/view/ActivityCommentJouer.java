package fr.example.moveball.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.example.moveball.R;
import fr.example.moveball.view.game.ActivityJeu;

public class ActivityCommentJouer extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_jouer);

        Button boutonCommentJouer = findViewById(R.id.acceuil);
        boutonCommentJouer.setOnClickListener(
            v -> accueil()
            );

        Button boutton = findViewById(R.id.jeu);
        boutton.setOnClickListener(
                v -> jouer()
        );
    }

    public void accueil() {
        Intent monIntent = new Intent(this, ActivitePrincipale.class);
        startActivity(monIntent);
        setContentView(R.layout.activite_principale);
    }
    public void jouer() {
        Intent monIntent = new Intent(this, ActivityJeu.class);
        startActivity(monIntent);
        setContentView(R.layout.activity_jeu);
    }
}
