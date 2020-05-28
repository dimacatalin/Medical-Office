package repositories;

import model.Medicament;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListMedicamentRepository implements MedicamentRepository {

    private List<Medicament> medicamente = new ArrayList<Medicament>();

    @Override
    public void addMedicament(Medicament medicament) {
        medicamente.add(medicament);
    }

    @Override
    public Optional<Medicament> findMedicamentById(int id) {
        for (int i = 0; i<medicamente.size(); i++) {
            if (medicamente.get(i).getId() == id) {
                return Optional.of(medicamente.get(i));
            }
        }
        return Optional.empty();
    }
}