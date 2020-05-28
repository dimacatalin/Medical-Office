package repositories;

import model.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListDoctorRepository implements DoctorRepository {

    private List<Doctor> doctori = new ArrayList<Doctor>();

    @Override
    public void addDoctor(Doctor doctor) {
        doctori.add(doctor);
    }

    @Override
    public Optional<Doctor> findDoctorById(int id) {
        for (int i = 0; i<doctori.size(); i++) {
            if (doctori.get(i).getId() == id) {
                return Optional.of(doctori.get(i));
            }
        }
        return Optional.empty();
    }
}