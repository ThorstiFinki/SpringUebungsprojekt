package com.example.demo.AnnesCorner;

public class Kinderauto extends Auto{

    public double getKinderalter() {
        return kinderalter;
    }

    private double kinderalter = 0.0;

    public String getFarbe() {
        return farbe;
    }

    private String farbe = "grau";
    public Kinderauto(String typ, int pS, double kinderalter, String farbe) {
        super(typ, pS);
        this.kinderalter = kinderalter;
        this.farbe = farbe;
    }
}
