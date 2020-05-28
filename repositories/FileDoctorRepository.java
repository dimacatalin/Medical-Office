package repositories;

import model.Cabinet;
import model.Doctor;
import service.AuditService;
import service.FileService;

import java.util.List;
import java.util.Optional;

public class FileDoctorRepository implements DoctorRepository{

    private final String filePath = "Doctori";

    @Override
    public void addDoctor(Doctor e) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String doctorData = e.toString();
        auditService.writeAction("S-a adaugat un doctor in fisierul " + filePath);
        service.writeFile(filePath,doctorData);
    }

    @Override
    public Optional<Doctor> findDoctorById(int id) {
        FileService service = FileService.getInstance();
        Doctor doctor = null;

        try{
            List<String> doctorList = service.getFile(filePath);
            for (String u : doctorList) {
                String [] attr = u.split(",");
                if (Integer.parseInt(attr[0]) == id) {
                    Cabinet cabinet = new Cabinet(attr[3],attr[4]);
                    doctor = new Doctor(Integer.parseInt(attr[0]),attr[1],attr[2],cabinet,Integer.parseInt(attr[5]));
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.ofNullable(doctor);
    }

}