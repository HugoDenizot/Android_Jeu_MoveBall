package fr.example.moveball.view.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorManager;
import android.media.Image;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import fr.example.moveball.R;
import fr.example.moveball.model.Arrivee;
import fr.example.moveball.model.Ball;
import fr.example.moveball.model.Ground;
import fr.example.moveball.model.Terrain;
import fr.example.moveball.model.Vide;
import fr.example.moveball.model.Wall;

import static androidx.core.content.ContextCompat.getSystemService;

public class GameView extends View {
    private Paint paint;
    private List<Wall> walls = new ArrayList<>();
    private List<Ground> grounds = new ArrayList<>();
    private List<Arrivee> arrivees = new ArrayList<>();
    private List<Vide> vides = new ArrayList<>();
    private Ball ball = new Ball();
    private DrawingHelper drawingHelper = new DrawingHelper();
    private Terrain terrain;
    private Context context;
    private TextView score_App;

    public GameView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        drawingHelper = new DrawingHelper();
    }

    public void setThingsToDraw(Terrain terrain, Ball ball){
        setTerrain(terrain);
        setBall(ball);
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
        this.grounds = terrain.getGrounds();
        this.walls = terrain.getWalls();
        this.arrivees = terrain.getArrivees();
        this.vides = terrain.getVides();
    }

    public void setBall(Ball ball){
        this.ball = ball;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        for (Ground ground : grounds) {
            drawingHelper.drawStructure(canvas, ground, paint);
        }
        for (Wall wall : walls) {
            drawingHelper.drawStructure(canvas, wall, paint);
        }
        for (Arrivee arrivee : arrivees){
            drawingHelper.drawStructure(canvas, arrivee, paint);
        }
        for (Vide vide : vides){
            drawingHelper.drawStructure(canvas, vide, paint);
        }
        paint.setColor(ball.getColor());
        canvas.drawCircle(ball.getPosX(), ball.getPosY(), ball.getWidth(), paint);
    }
}

