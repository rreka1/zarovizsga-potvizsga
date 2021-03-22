package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(path))) {
            bufferedReader.readLine();
            int males = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if ("male".equalsIgnoreCase(parts[4])) {
                    males++;
                }
            }
            return males;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }
}
