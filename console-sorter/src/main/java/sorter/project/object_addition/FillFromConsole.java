package sorter.project.object_addition;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Man;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillFromConsole {
    static List list=new ArrayList<>();
    private static Scanner console = new Scanner(System.in);

    private FillFromConsole() {
        throw new UnsupportedOperationException();
    }
    public static List fill(String type) {
        System.out.println("Для завершения введите \"exit\"");
        switch (type) {
            case "Man": {
                System.out.println("Вводите данные по образцу:");
                System.out.println("Фамилия возраст пол");
                System.out.println("Иванов 10 man");
                list=createMan();
                break;
            }
            case "Animal": {
                System.out.println("Вводите данные по образцу:");
                System.out.println("Вид наличие_шерсти цвет_глаз");
                System.out.println("Зверь true Синий");
                list=createAnimal();
                break;
            }
            case "Barrel": {
                System.out.println("Вводите данные по образцу:");
                System.out.println("Объем материал хранимый_материал");
                System.out.println("20.5 Дуб Сусло");
                list=createBarrel();
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }
    private static List createAnimal(){
        while (true){
            String line = console.nextLine();
            if(line.equalsIgnoreCase("exit")){
                break;
            }
            if(Validation.generalValidation(line)&&Validation.animalValidation(line)){
                int first = line.indexOf(" ");
                int second = line.indexOf(" ", first + 1);
                String types = line.substring(0, first);
                boolean wool = Boolean.parseBoolean(line.substring(first + 1, second));
                String eyeColor = line.substring(second);
                Animal animal = new Animal.AnimalBuilder(types)
                        .wool(wool)
                        .eyeColor(eyeColor)
                        .build();
                list.add(animal);
            }else {
                System.out.println("Не валидно");
            }
        }
        return list;
    }
    private static List createMan(){
        while (true){
            String line = console.nextLine();
            if(line.equalsIgnoreCase("exit")){
                break;
            }
            if(Validation.generalValidation(line)&&Validation.manValidation(line)){
                int first = line.indexOf(" ");
                int second = line.indexOf(" ", first + 1);
                String lastName = line.substring(0, first);
                int age = Integer.parseInt(line.substring(first + 1, second));
                String gender = line.substring(second);
                Man man = new Man.ManBuilder(lastName)
                        .age(age)
                        .gender(gender)
                        .build();
                list.add(man);
            }else {
                System.out.println("Не валидно");
            }
        }
        return list;
    }
    private static List createBarrel(){
        while (true){
            String line = console.nextLine();
            if(line.equalsIgnoreCase("exit")){
                break;
            }
            if(Validation.generalValidation(line)&&Validation.barrelValidation(line)){
                int first = line.indexOf(" ");
                int second = line.indexOf(" ", first + 1);
                float volume = Float.parseFloat(line.substring(0, first));
                String material = line.substring(first + 1, second);
                String storedMaterial = line.substring(second);
                Barrel barrel = new Barrel.BarrelBuilder(volume)
                        .storedMaterial(storedMaterial)
                        .material(material)
                        .build();
                list.add(barrel);
            }else {
                System.out.println("Не валидно");
            }
        }
        return list;
    }
}
