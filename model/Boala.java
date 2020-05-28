package model;

import java.util.ArrayList;
import java.util.List;

public class Boala {
    private List<String> medicamente = new ArrayList<String>();
    private int id;
    private String numeBoala;
    private List<String> simptome = new ArrayList<String>();

    public Boala()
    {
        this.medicamente = null;
        this.simptome = null;
        this.numeBoala = null;
        this.id = 0;
    }

    public Boala( int id, String numeBoala,List<String> medicamente, List<String> simptome) {
        this.medicamente = medicamente;
        this.id = id;
        this.numeBoala = numeBoala;
        this.simptome = simptome;
    }

    @Override
    public String toString() {
            String result = id + "," + numeBoala;
            for(String iterator: simptome)
                result+=","+iterator;
            for(String iterator: medicamente)
                result+=","+iterator;
            return result;
    }

    public List<String> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(List<String> medicamente) {
        this.medicamente = medicamente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeBoala() {
        return numeBoala;
    }

    public void setNumeBoala(String numeBoala) {
        this.numeBoala = numeBoala;
    }

    public List<String> getSimptome() {
        return simptome;
    }

    public void setSimptome(List<String> simptome) {
        this.simptome = simptome;
    }
}
