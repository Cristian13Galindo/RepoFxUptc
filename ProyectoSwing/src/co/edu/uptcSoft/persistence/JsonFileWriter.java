package co.edu.uptcSoft.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import co.edu.uptcSoft.model.Paciente;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonFileWriter {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/co/edu/uptcSoft/files/pacientes.json";

    public static void addPaciente(Paciente paciente) {
        ArrayList<Paciente> pacientes = readJson();

        if (pacientes == null) {
            pacientes = new ArrayList<>();
        }

        pacientes.add(paciente);
        writeToJson(pacientes);
    }

    public static ArrayList<Paciente> getPacientes() {
        return readJson();
    }

    private static ArrayList<Paciente> readJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<ArrayList<Paciente>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void writeToJson(ArrayList<Paciente> pacientes) {
        Gson gson = new Gson();
        String json = gson.toJson(pacientes);

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(json);
            System.out.println("Se pudo escribir el archivo correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}