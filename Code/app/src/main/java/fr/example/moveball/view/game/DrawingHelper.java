package fr.example.moveball.view.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import fr.example.moveball.R;
import fr.example.moveball.model.Ball;
import fr.example.moveball.model.Ground;
import fr.example.moveball.model.Structure;

public class DrawingHelper {

    public void drawStructure(Canvas canvas, Structure struct, Paint paint){
        paint.setColor(struct.getColor());
        int left = struct.getX();
        int top = struct.getY();
        int width = struct.getWidth() + left;
        int height = struct.getHeight() + top;
        canvas.drawRect(left,top,width,height,paint);
    }
}
