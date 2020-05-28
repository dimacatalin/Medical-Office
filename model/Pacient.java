package model;

import java.util.ArrayList;
import java.util.List;

public class Pacient extends Persoana {

    private List<String> simptome = new ArrayList<String>();
    private CardSanatate cardSanatate;

    public Pacient()
    {

    }

    public Pacient(int id, String nume, String prenume, List<String> simptome) {
        super(id, nume, prenume);
        this.simptome = simptome;
        this.cardSanatate = new CardSanatate(id,nume,prenume);
    }

    @Override
    public String toString() {
        String result = id + "," + nume+","+ prenume;
        for(String iterator: simptome)
            result=result +","+iterator;
        return result;
    }

    public List<String> getSimptome() {
        return simptome;
    }

    public void setSimptome(List<String> simptome) {
        this.simptome = simptome;
    }

    public CardSanatate getCardSanatate() {
        return cardSanatate;
    }

    public void setCardSanatate(CardSanatate cardSanatate) {
        this.cardSanatate = cardSanatate;
    }
}
