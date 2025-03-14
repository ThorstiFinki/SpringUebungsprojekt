package com.example.demo.AnnesCorner;

public class Kinderauto extends Auto{

    public double getKinderalter() {
        return kinderalter;
    }

    private double kinderalter = 0.0;
    public Kinderauto(String typ, int pS, double kinderalter) {
        super(typ, pS);
        this.kinderalter = kinderalter;
    }
}
