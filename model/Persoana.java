package model;

public class Persoana {
    protected int id;
    protected String nume;
    protected String prenume;

    public Persoana()
    {
    }

    public Persoana(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnume() {
        return nume;
    }

    public void setnume(String nume) {
        this.nume = nume;
    }

    public String getprenume() {
        return prenume;
    }

    public void setprenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return id +
                "," + nume +
                "," + prenume;
    }
}
