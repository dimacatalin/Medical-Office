package repositories;

import model.Medicament;

import java.util.Optional;

public interface MedicamentRepository {

    void addMedicament(Medicament medicament);
    Optional<Medicament> findMedicamentById(int id);

    static MedicamentRepository build(Type type) {
        switch (type) {
            case DB: return new DBMedicamentRepository();
            case FILE: return new FileMedicamentRepository();
            case LIST:return new ListMedicamentRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB,FILE, LIST
    }
}