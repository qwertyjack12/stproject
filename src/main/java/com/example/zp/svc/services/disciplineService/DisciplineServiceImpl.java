package com.example.zp.svc.services.disciplineService;

import com.example.zp.svc.Deserializator;
import com.example.zp.svc.Serializator;
import com.example.zp.discipline.Discipline;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class DisciplineServiceImpl implements DisciplineService {

    private Hashtable<Integer, Discipline<?>> disciplineTable;
    private final String fileName = "usedFiles\\Discipline.bin";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(disciplineTable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.disciplineTable = Deserializator.getHashtable(fileName);
        } catch (IOException|ClassNotFoundException e) {
            this.disciplineTable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkDisciplineKey(Integer key) {
        if (disciplineTable.containsKey(key)){
            return true;
        }else {
            System.out.println("Wrong discipline key input!");
            return false;
        }
    }

    @Override
    public void setDiscipline(int id, String name) {
        disciplineTable.put(id, new Discipline<>(id, name));
    }

    @Override
    public Discipline<?> getDiscipline(Integer key) {
        return disciplineTable.get(key);
    }

    @Override
    public void getDisciplines() {
        System.out.println(disciplineTable);
    }
}
