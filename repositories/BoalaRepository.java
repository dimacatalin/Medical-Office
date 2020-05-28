package repositories;

import model.Boala;

import java.util.Optional;

public interface BoalaRepository {

    void addBoala(Boala boala);
    Optional<Boala> findBoalaById(int id);

    static BoalaRepository build(Type type) {
        switch (type) {
            case DB: return new DBBoalaRepository();
            case FILE: return new FileBoalaRepository();
            case LIST:return new ListBoalaRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB,FILE, LIST
    }
}