package fr.example.moveball.model;

import android.graphics.Color;

public class Wall extends Structure{
    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height, Color.BLACK);
    }
}
