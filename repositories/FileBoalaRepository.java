package repositories;

import model.Boala;
import service.AuditService;
import service.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileBoalaRepository implements BoalaRepository{

    private final String filePath = "Pacienti";

    @Override
    public void addBoala(Boala e) {
        FileService service = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        String boalaData = e.toString();
        auditService.writeAction("S-a adaugat o boala in fisierul " + filePath);
        service.writeFile(filePath,boalaData);
    }

    @Override
    public Optional<Boala> findBoalaById(int id) {
        FileService service = FileService.getInstance();
        Boala boala = null;

        try{
            List<String> boalaList = service.getFile(filePath);
            for (String u : boalaList) {
                String [] attr = u.split(",");
                if (Integer.parseInt(attr[0]) == id) {
                    List<String> simptome = new ArrayList<String>();
                    List<String> medicamente = new ArrayList<String>();
                    //aci ce fac same

                    String [] attrr = attr[3].split(".");

                    for (int i = 0;i<attrr.length;i++){
                        medicamente.add(attrr[i]);
                    }

                    for (int i = 3;i<attr.length;i++){
                        simptome.add(attr[i]);
                    }

                    boala = new Boala(Integer.parseInt(attr[0]),attr[1],medicamente,simptome);
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.ofNullable(boala);
    }

}