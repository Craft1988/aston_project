package sorter.project.object_addition;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Man;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FillFromFile {
    static List list=new ArrayList<>();
    public static List file(int count, String type) {
        switch (type) {
            case "Man": {
                try {
                    list = createMan(count);
                } catch (IOException e) {
                    System.out.println("ошибка111");
                }
                break;
            }
            case "Animal": {
                try {
                    list = createAnimal(count);
                } catch (IOException e) {
                    System.out.println("ошибка222");
                }
                break;
            }
            case "Barrel": {
                try {
                    list = createBarrel(count);
                } catch (IOException e) {
                    System.out.println("ошибка333");
                }
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }
    public static List createAnimal(int count) throws IOException {
        List<Object> list =new ArrayList<>();
        String s ="src\\main\\java\\sorter\\project\\object_addition\\animal.txt";
        Path path =Path.of(s).toAbsolutePath();
        List<String> lines = Files.readAllLines(path);
        for(int i=0;(i<count) && (i<lines.size());i++){
            int first=lines.get(i).indexOf(" ");
            int second=lines.get(i).indexOf(" ",first+1);
            String types = lines.get(i).substring(0,first);
            boolean wool = Boolean.parseBoolean(lines.get(i).substring(first+1,second));
            String eyeColor=lines.get(i).substring(second);
            Animal animal= new Animal.AnimalBuilder(types)
                    .wool(wool)
                    .eyeColor(eyeColor)
                    .build();
            list.add(animal);
        }
        return list;
    }
    public static List createMan(int count) throws IOException {
        List<Object> list =new ArrayList<>();
        String s ="src\\main\\java\\sorter\\project\\object_addition\\man.txt";
        Path path =Path.of(s).toAbsolutePath();
        List<String> lines = Files.readAllLines(path);
        for(int i=0;(i<count) && (i<lines.size());i++){
            int first=lines.get(i).indexOf(" ");
            int second=lines.get(i).indexOf(" ",first+1);
            String lastName = lines.get(i).substring(0,first);
            int age = Integer.parseInt(lines.get(i).substring(first+1,second));
            String gender=lines.get(i).substring(second);
            Man man= new Man.ManBuilder(lastName)
                    .age(age)
                    .gender(gender)
                    .build();
            list.add(man);
        }
        return list;
    }
    public static List createBarrel(int count) throws IOException {
        List<Object> list =new ArrayList<>();
        String s ="src\\main\\java\\sorter\\project\\object_addition\\barrel.txt";
        Path path =Path.of(s).toAbsolutePath();
        List<String> lines = Files.readAllLines(path);
        for(int i=0;(i<count) && (i<lines.size());i++){
            int first=lines.get(i).indexOf(" ");
            int second=lines.get(i).indexOf(" ",first+1);
            float volume = Float.parseFloat(lines.get(i).substring(0,first));
            String storedMaterial = lines.get(i).substring(first+1,second);
            String material=lines.get(i).substring(second);
            Barrel barrel= new Barrel.BarrelBuilder(volume)
                    .storedMaterial(storedMaterial)
                    .material(material)
                    .build();
            list.add(barrel);
        }
        return list;
    }

}
