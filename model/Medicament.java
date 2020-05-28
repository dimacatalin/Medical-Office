package model;

public class Medicament {
    private String nume;
    private int id;
    private float pret;
    private String doza;

    public Medicament(String nume, int id, float pret, String doza) {
        this.nume = nume;
        this.id = id;
        this.pret = pret;
        this.doza = doza;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDoza() {
        return doza;
    }

    public void setDoza(String doza) {
        this.doza = doza;
    }

    @Override
    public String toString() {
        return nume +
                "," + id +
                "," + pret +
                "," + doza;
    }
}
