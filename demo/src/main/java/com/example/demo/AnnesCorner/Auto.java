package com.example.demo.AnnesCorner;

public class Auto {

    private String name = "Standard Auto";
    private String typ;
    private int psZahl;
    private int baujahr;
    private boolean hatKlima = true;

    public Auto(String typ, int pS) {
        if (pS < 100) {
            this.psZahl = 100;
        } else {
            this.psZahl = pS;
        }

        this.typ = typ;
    }


    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getPsZahl() {
        return psZahl;
    }

    public void setPsZahl(int psZahl) {
        if (psZahl < 100) {
            this.psZahl = 100;
        } else {
            this.psZahl = psZahl;
        }

    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public boolean isHatKlima() {
        return hatKlima;
    }

    public void setHatKlima(boolean hatKlima) {
        this.hatKlima = hatKlima;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
