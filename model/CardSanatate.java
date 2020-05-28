package model;

import java.util.Random;

public class CardSanatate {
    private int codIdnetificare;
    private int varsta;
    private String nume;
    private String prenume;

    public CardSanatate(int varsta, String nume, String prenume) {
        Random rand = new Random();
        this.codIdnetificare = rand.nextInt(1000);
        this.varsta = varsta;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getCodIdnetificare() {
        return codIdnetificare;
    }

    public void setCodIdnetificare(int codIdnetificare) {
        this.codIdnetificare = codIdnetificare;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return codIdnetificare + "," + varsta +
                "," + nume +
                "," + prenume;
    }
}
