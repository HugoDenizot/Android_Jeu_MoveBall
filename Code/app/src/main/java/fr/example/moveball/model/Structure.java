package fr.example.moveball.model;

public class Structure {
    private int x;
    private int y;
    private int color;
    private int width;
    private int height;

    public Structure(int x, int y, int width, int height,int color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getColor() { return color; }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
