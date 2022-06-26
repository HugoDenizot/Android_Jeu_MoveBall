package fr.example.moveball.model;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Iterator;
import java.util.List;

public class Collisionneur {

    private List<Structure> lesStructures;
    private DisplayMetrics ecran;

    public Collisionneur(List lesStructures,DisplayMetrics ecran){
        this.lesStructures=lesStructures;
        this.ecran=ecran;
    }

    public boolean canMove(float futurX, float futurY, Ball laBoule){
        if(!isPresent(futurX, futurY, laBoule)){
            return false;
        }
        return futurX>0 && futurX<=ecran.widthPixels&&futurY>0&&futurY<=ecran.heightPixels;
    }

    public boolean isPresent(float x, float y, Ball laBoule) {
        //Test collisions murs
        Iterator<Structure> lIterateur = lesStructures.iterator();
        //Log.d("Test", String.valueOf(lIterateur));
        while (lIterateur.hasNext()) {
            Structure structure = lIterateur.next();
            Log.d("TestMur", String.valueOf(structure.getClass()));
            if (structure instanceof Wall && (structure.getX()+structure.getWidth() >= x-laBoule.getWidth() && structure.getY()+structure.getHeight() >= y-laBoule.getHeight() && structure.getX() <=x + laBoule.getWidth() && structure.getY() <= y + laBoule.getHeight())) {
                laBoule.setColor(Color.GREEN);
                return false;
            }
        }

        //Test ligne d'arrivée
        lIterateur = lesStructures.iterator();
        while (lIterateur.hasNext()) {
            Structure structure = lIterateur.next();
            if (structure instanceof Arrivee && (structure.getX() <= x && structure.getY() <= y && structure.getX() + structure.getWidth() >= x+(laBoule.getWidth() * 0.1) && structure.getY() + structure.getHeight() >= y+( laBoule.getHeight()*0.1))) {
                laBoule.setColor(Color.YELLOW);
                return true;
            }
        }

        //Test vide
        lIterateur = lesStructures.iterator();
        while (lIterateur.hasNext()) {
            Structure structure = lIterateur.next();
            if (structure instanceof Vide && (structure.getX() <= x && structure.getY() <= y && structure.getX() + structure.getWidth() >= x+(laBoule.getWidth() * 0.1) && structure.getY() + structure.getHeight() >= y+( laBoule.getHeight()*0.1))) {
                laBoule.setColor(Color.GRAY);
                return true;
            }
        }

        //Test collisions sol
        lIterateur = lesStructures.iterator();
        while (lIterateur.hasNext()) {
            Structure structure = lIterateur.next();
            if (structure instanceof Ground && (structure.getX() <= x && structure.getY() <= y && structure.getX() + structure.getWidth() >= x+(laBoule.getWidth() * 0.1) && structure.getY() + structure.getHeight() >= y+( laBoule.getHeight()*0.1))) {
                laBoule.setColor(Color.RED);
                return true;
            }
        }

        laBoule.setColor(Color.GRAY);
        return false;
    }
}
