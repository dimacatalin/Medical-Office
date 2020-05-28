package repositories;

import model.Medicament;
import service.AuditService;
import service.FileService;

import java.util.List;
import java.util.Optional;

public class FileMedicamentRepository implements MedicamentRepository{

    private final String filePath = "Medicamente";

    @Override
    public void addMedicament(Medicament e) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String medicamentData = e.toString();
        auditService.writeAction("S-a adaugat un medicament in fisierul " + filePath);
        service.writeFile(filePath,medicamentData);
    }

    @Override
    public Optional<Medicament> findMedicamentById(int id) {
        FileService service = FileService.getInstance();
        Medicament medicament = null;

        try{
            List<String> medicamentList = service.getFile(filePath);
            for (String u : medicamentList) {
                String [] attr = u.split(",");
                if (Integer.parseInt(attr[0]) == id) {
                    medicament = new Medicament(attr[1],Integer.parseInt(attr[0]),Float.parseFloat(attr[2]),attr[3]);
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.ofNullable(medicament);
    }

}