package model;

public class Cabinet {
    private String specializare;
    private String adresa;

    public Cabinet(String specializare, String adresa) {
        this.specializare = specializare;
        this.adresa = adresa;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return  specializare + "," +adresa;
    }
}
