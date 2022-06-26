package fr.example.moveball.view.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

import fr.example.moveball.R;
import fr.example.moveball.model.Arrivee;
import fr.example.moveball.model.Ball;
import fr.example.moveball.model.Collisionneur;
import fr.example.moveball.model.Ground;
import fr.example.moveball.model.Structure;
import fr.example.moveball.model.Terrain;
import fr.example.moveball.model.Vide;
import fr.example.moveball.model.Wall;


public class ActivityJeu extends AppCompatActivity implements SensorEventListener {
    private Terrain terrain = new Terrain();
    private Ball ball;
    private GameView gameView;
    private List<Structure> structures;
    private float posX;
    private float posY;
    private DisplayMetrics ecran;
    private Collisionneur collisionneur;
    private int cptToGameOver = 0;
    private int cptToWin = 0;
    private int score=0;
    private TextView score_App;
    private int time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        posX=400;
        posY=365;
        ecran=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(ecran);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        ball = new Ball(posX,posY);
        score_App=findViewById(R.id.ScoreJeu);
        terrain = new Terrain();
        terrain.addArrivee(new Arrivee(250,1800,200,200));
        terrain.addVide(new Vide(250,1450,500,150));
        terrain.addWall(new Wall(50,100,1300,200));
        terrain.addWall(new Wall(50,2000,1300,200));
        terrain.addWall(new Wall(50,100,200,2000));
        terrain.addWall(new Wall(50,450,1000,100));
        terrain.addWall(new Wall(700, 800, 600, 50));
        terrain.addWall(new Wall(700, 800, 100, 500));
        terrain.addWall(new Wall(50, 900, 500, 50));
        terrain.addWall(new Wall(1000, 1000, 50, 600));
        terrain.addWall(new Wall(50, 1600,1000, 150));
        terrain.addGround(new Ground(150,150,1100,1900));

        structures = new ArrayList<Structure>();
        structures.addAll(terrain.getWalls());
        structures.addAll(terrain.getArrivees());
        structures.addAll(terrain.getGrounds());
        structures.addAll(terrain.getVides());

        gameView = findViewById(R.id.gameView);
        gameView.setThingsToDraw(terrain,ball);

        SensorManager m = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        m.registerListener(
                this,
                m.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_FASTEST
        );
        collisionneur = new Collisionneur(structures,ecran);
    }

    public void displayGame(){
        ball.setPosX(posX);
        ball.setPosY(posY);
        gameView.invalidate();
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x =event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        //Log.d("TEST", String.valueOf(structures.size()));
        y=y- SensorManager.GRAVITY_EARTH;
        time=time+1;
        if(collisionneur.canMove(posX-x/10,posY-z/10,ball)){
            posY=posY-z/10;
            posX=posX-x/10;
            displayGame();
        }

        if(time==500){
            score=score+1;
            score_App.setText(String.valueOf(score));
            time=0;
        }

        //GameWin
        if (ball.getColor() == Color.YELLOW) {
            cptToWin++;
            if (cptToWin == 5) {
            gameWon();
            }
        }

        //GameOver
        if (ball.getColor() == Color.GRAY) {
            cptToGameOver++;
            if (cptToGameOver == 20) {
                gameOver();
            }
        }

        gameView.invalidate();
    }

    void gameOver(){
        Intent monIntent = new Intent(this, ActivityGameOver.class);
        startActivity(monIntent);
        setContentView(R.layout.activity_game_over);
    }

    void gameWon(){
        Intent monIntent = new Intent(this, ActivityWin.class);
        startActivity(monIntent);
        setContentView(R.layout.activity_win);
    }
}
