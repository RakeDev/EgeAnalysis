package org.example;
import java.io.FileNotFoundException;
import java.util.List;

public interface Converting {
    List<Dao>getStats() throws FileNotFoundException;
    List<Dao> convertCsvToLines(String input);
    Dao convertLinesToMeaning(String line);
}
