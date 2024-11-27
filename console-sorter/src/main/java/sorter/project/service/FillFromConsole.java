package sorter.project.service;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillFromConsole{

    private static final Scanner console = new Scanner(System.in);

    private FillFromConsole() {
        throw new UnsupportedOperationException();
    }

    static List<Object> list = new ArrayList<>();

    public static List<Object> fill(String type) {
        System.out.println("Для завершения введите \"exit\"");
        switch (type) {
            case "Human": {
                System.out.println("Вводите данные по образцу:");
                System.out.println("Фамилия возраст пол");
                System.out.println("Иванов 10 man");
                list = createMan();
                break;
            }
            case "Animal": {
                System.out.println("Вводите данные по образцу:");
                System.out.println("Вид наличие_шерсти цвет_глаз");
                System.out.println("Зверь true Синий");
                list = createAnimal();
                break;
            }
            case "Barrel": {
                System.out.println("Вводите данные по образцу:");
                System.out.println("Объем материал хранимый_материал");
                System.out.println("20.5 Дуб Сусло");
                list = createBarrel();
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }

    private static List<Object> createAnimal() {
        while (true) {
            String line = console.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            if (Validation.generalValidation(line) && Validation.animalValidation(line)) {
                String[] value = line.split(" ");
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
                        .setEyeColor(eyeColor)
                        .setWool(wool)
                        .build();
                list.add(animal);
            } else {
                System.out.println("Не валидно");
            }
        }
        return list;
    }

    private static List<Object> createMan() {
        while (true) {
            String line = console.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            if (Validation.generalValidation(line) && Validation.manValidation(line)) {
                String[] value = line.split(" ");
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
                        .setAge(age)
                        .setSex(gender)
                        .build();
                list.add(man);
            } else {
                System.out.println("Не валидно");
            }
        }
        return list;
    }

    private static List<Object> createBarrel() {
        while (true) {
            String line = console.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            if (Validation.generalValidation(line) && Validation.barrelValidation(line)) {
                String[] value = line.split(" ");
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
                        .setMaterial(material)
                        .setStoredMaterial(storedMaterial)
                        .build();
                list.add(barrel);
            } else {
                System.out.println("Не валидно");
            }
        }
        return list;
    }
}
