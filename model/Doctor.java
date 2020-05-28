package model;

public class Doctor extends Persoana {

    private Cabinet cabinet;
    private int aniExperienta;

    public Doctor(int id, String nume, String prenume, Cabinet cabinet, int aniExperienta) {
        super(id, nume, prenume);
        this.cabinet = cabinet;
        this.aniExperienta = aniExperienta;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    @Override
    public String toString() {
        return cabinet +
                "," + aniExperienta +
                "," + id +
                "," + nume +
                "," + prenume;
    }
}
