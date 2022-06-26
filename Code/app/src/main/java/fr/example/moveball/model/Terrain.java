package fr.example.moveball.model;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    private List<Wall> walls;
    private List<Ground> grounds;
    private List<Arrivee> arrivees;
    private List<Vide> vides;

    public Terrain(){
        walls = new ArrayList<>();
        grounds = new ArrayList<>();
        arrivees = new ArrayList<>();
        vides = new ArrayList<>();
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Ground> getGrounds() {
        return grounds;
    }

    public List<Arrivee> getArrivees() {return arrivees; }

    public List<Vide> getVides() { return vides; }

    public void addWall(Wall wall){
        walls.add(wall);
    }

    public void addGround(Ground ground){
        grounds.add(ground);
    }

    public void addArrivee(Arrivee arrivee) { arrivees.add(arrivee); }

    public void addVide(Vide vide) { vides.add(vide); }
}
