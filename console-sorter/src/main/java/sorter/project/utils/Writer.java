package sorter.project.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class Writer {
    public static void writeToFile(String filename, List<?> values) {
        Path path = Paths.get(filename);
        try {
            Files.write(path, values.stream().map(Object::toString).toList(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}