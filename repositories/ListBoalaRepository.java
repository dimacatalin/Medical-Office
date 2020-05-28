package repositories;

import model.Boala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListBoalaRepository implements BoalaRepository {

    private List<Boala> boli = new ArrayList<Boala>();

    @Override
    public void addBoala(Boala boala) {
        boli.add(boala);
    }

    @Override
    public Optional<Boala> findBoalaById(int id) {
        for (int i = 0; i<boli.size(); i++) {
            if (boli.get(i).getId() == id) {
                return Optional.of(boli.get(i));
            }
        }
        return Optional.empty();
    }
}