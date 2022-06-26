package fr.example.moveball.view.game;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.example.moveball.R;
import fr.example.moveball.view.ActivitePrincipale;

public class ActivityWin extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Button acceuil = findViewById(R.id.acceuil_win);
        acceuil.setOnClickListener(
                v -> accueil()
        );

        Button reJouer = findViewById(R.id.jeu_win);
        reJouer.setOnClickListener(
                v -> jouer()
        );
    }

    private void accueil() {
        Intent monIntent = new Intent(this, ActivitePrincipale.class);
        startActivity(monIntent);
        setContentView(R.layout.activite_principale);
    }

    private void jouer() {
        Intent monIntent = new Intent(this, ActivityJeu.class);
        startActivity(monIntent);
        setContentView(R.layout.activity_jeu);
    }
}
