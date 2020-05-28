package main;

import model.*;
import repositories.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ListPacientRepository listPacientRepository = new ListPacientRepository();
        List<String> p1Symptoms = Arrays.asList("febra","durere la cap","roseata");
        Pacient p1 = new Pacient(1,"Dima","Catalin",p1Symptoms);

        List<String> p2Symptoms = Arrays.asList("durere articulara","inflamare musculara","diaree");
        Pacient p2 = new Pacient(2,"Florinel","Nacula",p2Symptoms);

        List<String> p3Symptoms = Arrays.asList("febra","nas infundat","stare de grata");
        Pacient p3 = new Pacient(3,"Barbu","Dragosel",p3Symptoms);

        listPacientRepository.addPacient(p1);
        listPacientRepository.addPacient(p2);
        listPacientRepository.addPacient(p3);

        System.out.println(listPacientRepository.findPacientById(2));

        ///////////////////////////////////////////////////////////////////////////////////////
        ListDoctorRepository listDoctorRepository = new ListDoctorRepository();
        Cabinet c1 = new Cabinet("Cronoscopie","Strada targu jiu");
        Doctor d1 = new Doctor(1,"Morlova","Cordesqu",c1,10);

        Cabinet c2 = new Cabinet("Bossologie","Strada Marcu jiu");
        Doctor d2 = new Doctor(2,"Ciprian","Marica",c2,10);

        Cabinet c3 = new Cabinet("Jmekerologie","Strada BOSSU jiu");
        Doctor d3 = new Doctor(3,"Floron","Naquoaaie",c3,10);

        listDoctorRepository.addDoctor(d1);
        listDoctorRepository.addDoctor(d2);
        listDoctorRepository.addDoctor(d3);

        System.out.println(listDoctorRepository.findDoctorById(3));

        ///////////////////////////////////////////////////////////////////////////////////
        ListMedicamentRepository listMedicamentRepository = new ListMedicamentRepository();

        Medicament m1 = new Medicament("doxiciclina",1, 54, "400");
        Medicament m2 = new Medicament("viagrolina",2, 100, "1000");
        Medicament m3 = new Medicament("xanax",3, 47, "250");

        listMedicamentRepository.addMedicament(m1);
        listMedicamentRepository.addMedicament(m2);
        listMedicamentRepository.addMedicament(m3);

        System.out.println(listMedicamentRepository.findMedicamentById(2));

        ///////////////////////////////////////////////////////////////////
        ListBoalaRepository listBoalaRepository = new ListBoalaRepository();

        List<String> b1Symptoms = Arrays.asList("febra","dureri","roseata");
        List<String> b2Symptoms = Arrays.asList("nas infundat","diaree","tuse");
        List<String> b3Symptoms = Arrays.asList("ciroza","dureri musculare","roseata articulara");

        List<String> r1Medi = Arrays.asList("coada calului","fiobilin","aspacardin");
        List<String> r2Medi = Arrays.asList("paracetamol","parasinus");
        List<String> r3Medi = Arrays.asList("xanax","iarba medicinala");



        Boala b1 = new Boala(1,"trocaricioza",r1Medi,b1Symptoms);
        Boala b2 = new Boala(2,"manacoza",r2Medi,b2Symptoms);
        Boala b3 = new Boala(3,"infectie urinara",r3Medi,b3Symptoms);

        listBoalaRepository.addBoala(b1);
        listBoalaRepository.addBoala(b2);
        listBoalaRepository.addBoala(b3);

        System.out.println(listBoalaRepository.findBoalaById(1));


        DBPacientRepository dbPacientRepository = new DBPacientRepository();

        dbPacientRepository.addPacient(p1);
        dbPacientRepository.addPacient(p2);

        System.out.println(dbPacientRepository.findPacientById(2));

        DBDoctorRepository dbDoctorRepository = new DBDoctorRepository();

        dbDoctorRepository.addDoctor(d1);
        dbDoctorRepository.addDoctor(d2);

        System.out.println(dbDoctorRepository.findDoctorById(1));

        DBMedicamentRepository dbMedicamentRepository = new DBMedicamentRepository();

        dbMedicamentRepository.addMedicament(m1);
        dbMedicamentRepository.addMedicament(m2);

        System.out.println(dbMedicamentRepository.findMedicamentById(1));

        DBBoalaRepository dbBoalaRepository = new DBBoalaRepository();

        dbBoalaRepository.addBoala(b1);
        dbBoalaRepository.addBoala(b2);
        dbBoalaRepository.addBoala(b3);

        System.out.println(dbBoalaRepository.findBoalaById(3));


    }
}
