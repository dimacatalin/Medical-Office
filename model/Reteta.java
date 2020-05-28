package model;

import java.util.ArrayList;
import java.util.List;

public class Reteta {
    private List<Medicament> medicamente=new ArrayList<Medicament>();
    private float pret;

    public Reteta(List<Medicament> medicamente) {
        this.medicamente = medicamente;

        for (int i = 0; i < medicamente.size(); i++)
            pret = pret + medicamente.get(i).getPret();

        this.pret = pret;
    }

    public List<Medicament> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(List<Medicament> medicamente) {
        this.medicamente = medicamente;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return medicamente +
                "," + pret;
    }
}
