package repositories;

import model.Doctor;

import java.util.Optional;

public interface DoctorRepository {

    void addDoctor(Doctor Doctor);
    Optional<Doctor> findDoctorById(int id);

    static DoctorRepository build(Type type) {
        switch (type) {
            case DB: return new DBDoctorRepository();
            case FILE: return new FileDoctorRepository();
            case LIST:return new ListDoctorRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        DB,FILE, LIST
    }
}