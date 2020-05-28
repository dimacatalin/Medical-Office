package repositories;

import model.Pacient;

import java.util.Optional;

public interface PacientRepository {

    void addPacient(Pacient pacient);
    Optional<Pacient> findPacientById(int id);

    static PacientRepository build(Type type) {
        switch (type) {
            case DB: return new DBPacientRepository();
            case FILE: return new FilePacientRepository();
            case LIST:return new ListPacientRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB,FILE, LIST
    }
}