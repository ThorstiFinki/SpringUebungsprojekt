package com.example.demo.AnnesCorner;

public class Kinderauto extends Auto{

    public double getKinderalter() {
        return kinderalter;
    }

    private double kinderalter = 0.0;

    public boolean isHatKupplung() {
        return hatKupplung;
    }

    private boolean hatKupplung = false;
    public Kinderauto(String typ, int pS, double kinderalter, boolean hatKupplung) {
        super(typ, pS);
        this.kinderalter = kinderalter;
        this.hatKupplung = hatKupplung;
    }
}
