package sorter.project.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class Writer {
    public static void writeCollectionToFile(String filename, List<?> list) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (Object value : list) {
                writer.write(value + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    public static void writeIndexToFile(String filename, int value) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(("Найденный элемент был на " + value + "строчке") + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }
}