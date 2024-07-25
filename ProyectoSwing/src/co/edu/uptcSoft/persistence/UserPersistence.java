package co.edu.uptcSoft.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import co.edu.uptcSoft.model.Dentist;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserPersistence {
    private static final String DENTISTS_FILE_PATH = "src/co/edu/uptcSoft/files/dentists.json";

    public ArrayList<Dentist> readDentistsFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(DENTISTS_FILE_PATH)) {
            Type type = new TypeToken<ArrayList<Dentist>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeDentistsToFile(ArrayList<Dentist> dentists) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(DENTISTS_FILE_PATH)) {
            gson.toJson(dentists, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dentist getDentistByName(String name) {
        ArrayList<Dentist> dentists = readDentistsFromFile();
        for (Dentist dentist : dentists) {
            if (dentist.getName().equals(name)) {
                return dentist;
            }
        }
        return null;
    }
}