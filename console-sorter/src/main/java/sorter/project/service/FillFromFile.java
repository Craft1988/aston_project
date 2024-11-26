package sorter.project.service;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.utils.Validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class FillFromFile {
    private static List list = new ArrayList<>();

    private FillFromFile() {
        throw new UnsupportedOperationException();
    }

    public static List fill(int count, String type) {
        switch (type) {
            case "Human": {
                try {
                    list = createMan(count);
                } catch (IOException e) {
                    System.out.println("ошибка файла");
                }
                break;
            }
            case "Animal": {
                try {
                    list = createAnimal(count);
                } catch (IOException e) {
                    System.out.println("ошибка файла");
                }
                break;
            }
            case "Barrel": {
                try {
                    list = createBarrel(count);
                } catch (IOException e) {
                    System.out.println("ошибка файла");
                }
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }

    private static List createAnimal(int count) throws IOException {
        List<Object> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "resources", "files", "animal.txt");
        List<String> lines = Files.readAllLines(path);
        int countOfError = 0;
        for (int i = 0; (i < count) && (i < lines.size()); i++) {
            if (Validation.generalValidation(lines.get(i))) {
                if (Validation.animalValidation(lines.get(i))) {
                    String[] value = lines.get(i).split(" ");
                    String types = value[0];
                    boolean wool = false;
                    String eyeColor = null;
                    if (value.length >= 2) {
                        wool = Boolean.parseBoolean(value[1]);
                        if (value.length >= 3) {
                            eyeColor = value[2];
                        }
                    }
                    Animal animal = new Animal.AnimalBuilder(types)
                            .setWool(wool)
                            .setEyeColor(eyeColor)
                            .build();
                    list.add(animal);
                } else {
                    System.out.println("Ошибка валидации2");
                    countOfError++;
                }
            } else {
                System.out.println("Ошибка валидации");
                countOfError++;
            }
        }
        System.out.println("Ошибок валидации: " + countOfError);
        return list;
    }

    private static List createMan(int count) throws IOException {
        List<Object> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "resources", "files", "man.txt");
        List<String> lines = Files.readAllLines(path);
        int countOfError = 0;
        for (int i = 0; (i < count) && (i < lines.size()); i++) {
            if (Validation.generalValidation(lines.get(i))) {
                if (Validation.manValidation(lines.get(i))) {
                    String[] value = lines.get(i).split(" ");
                    String lastName = value[0];
                    int age = 0;
                    String gender = null;
                    if (value.length >= 2) {
                        age = Integer.parseInt(value[1]);
                        if (value.length >= 3) {
                            gender = value[2];
                        }
                    }
                    Human man = new Human.HumanBuilder(lastName)
                            .setSex(gender)
                            .setAge(age)
                            .build();
                    list.add(man);
                } else {
                    System.out.println("Ошибка валидации2");
                    countOfError++;
                }
            } else {
                System.out.println("Ошибка валидации");
                countOfError++;
            }
        }
        System.out.println("Ошибок валидации: " + countOfError);
        return list;
    }

    private static List createBarrel(int count) throws IOException {
        List<Object> list = new ArrayList<>();
        Path path = Paths.get("src", "main", "resources", "files", "barrel.txt");
        List<String> lines = Files.readAllLines(path);
        int countOfError = 0;
        for (int i = 0; (i < count) && (i < lines.size()); i++) {
            if (Validation.generalValidation(lines.get(i))) {
                if (Validation.barrelValidation(lines.get(i))) {
                    String[] value = lines.get(i).split(" ");
                    float volume = Float.parseFloat(value[0]);
                    String material = null;
                    String storedMaterial = null;
                    if (value.length >= 2) {
                        material = value[1];
                        if (value.length >= 3) {
                            storedMaterial = value[2];
                        }
                    }
                    Barrel barrel = new Barrel.BarrelBuilder(volume)
                            .setStoredMaterial(storedMaterial)
                            .setMaterial(material)
                            .build();
                    list.add(barrel);
                } else {
                    System.out.println("Ошибка валидации2");
                    countOfError++;
                }
            } else {
                System.out.println("Ошибка валидации");
                countOfError++;
            }
        }
        System.out.println("Ошибок валидации: " + countOfError);
        return list;
    }
}