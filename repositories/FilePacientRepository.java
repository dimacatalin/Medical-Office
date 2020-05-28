package repositories;

import model.Pacient;
import service.AuditService;
import service.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilePacientRepository implements PacientRepository{

    private final String filePath = "Pacienti";

    @Override
    public void addPacient(Pacient e) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String pacientData = e.toString();
        auditService.writeAction("S-a adaugat un pacient in fisierul " + filePath);
        service.writeFile(filePath,pacientData);
    }

    @Override
    public Optional<Pacient> findPacientById(int id) {
        FileService service = FileService.getInstance();
        Pacient pacient = null;

        try{
            List<String> pacientList = service.getFile(filePath);
            for (String u : pacientList) {
                String [] attr = u.split(",");
                if (Integer.parseInt(attr[0]) == id) {
                    List<String> simptome = new ArrayList<String>();
                    for (int i = 3;i<attr.length;i++){
                        simptome.add(attr[i]);
                    }
                    pacient = new Pacient(Integer.parseInt(attr[0]),attr[1],attr[2],simptome);
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.ofNullable(pacient);
    }

}