package fr.example.moveball.model;

import android.graphics.Color;

public class Ball {
    private float posX;
    private float posY;
    private int height;
    private int width;
    private int color;


    public Ball() {
    }

    public Ball(float posX, float posY) {
        this.posX=posX;
        this.posY=posY;
        color = Color.RED;
        width=50;
        height=50;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
