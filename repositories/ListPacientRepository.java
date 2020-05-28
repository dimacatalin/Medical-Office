package repositories;

import model.Pacient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListPacientRepository implements PacientRepository {

    private List<Pacient> pacienti = new ArrayList<Pacient>();

    @Override
    public void addPacient(Pacient pacient) {
        pacienti.add(pacient);
    }

    @Override
    public Optional<Pacient> findPacientById(int id) {
        for (int i = 0; i<pacienti.size(); i++) {
            if (pacienti.get(i).getId() == id) {
                return Optional.of(pacienti.get(i));
            }
        }
        return Optional.empty();
    }
}