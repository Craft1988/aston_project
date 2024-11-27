package sorter.project.service;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.entity.dataForRandom.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class FillFromRandom {
    private final static Random rand = new Random();
    private static List<Object> list = new ArrayList<>();


    public static List<Object> fill(int count, String type) {
        switch (type) {
            case "Human": {
                list = createMan(count);
                break;
            }
            case "Animal": {
                list = createAnimal(count);
                break;
            }
            case "Barrel": {
                list = createBarrel(count);
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }

    private static String randomGender() {
        if (rand.nextInt(3) > 1) return "man";
        return "woman";
    }

    private static String randomLastName(String gender) {
        if (gender.equals("man")) {
            return DataForHumanRandom.mansSurname.get(rand.nextInt(DataForHumanRandom.mansSurname.size()));
        }
        return DataForHumanRandom.womansSurname.get(rand.nextInt(DataForHumanRandom.womansSurname.size()));
    }

    private static String randomTypeOfAnimal(boolean wool) {
        if (wool) {
            return DataForAnimalRandom.animalWithWool.get(rand.nextInt(DataForAnimalRandom.animalWithWool.size()));
        }
        return DataForAnimalRandom.animalWithoutWool.get(rand.nextInt(DataForAnimalRandom.animalWithoutWool.size()));
    }

    private static List<Object> createAnimal(int count) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            boolean wool = rand.nextBoolean();
            String types = randomTypeOfAnimal(wool);
            Animal animal = new Animal.AnimalBuilder(types)
                    .setEyeColor(DataForAnimalRandom.animalEyeColor.get(rand.nextInt(DataForAnimalRandom.animalEyeColor.size())))
                    .setWool(wool)
                    .build();
            list.add(animal);
        }
        return list;
    }

    private static List<Object> createMan(int count) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String gender = randomGender();
            String lastName = randomLastName(gender);
            Human man = new Human.HumanBuilder(lastName)
                    .setAge(rand.nextInt(70))
                    .setSex(gender)
                    .build();
            list.add(man);
        }
        return list;
    }

    private static List<Object> createBarrel(int count) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Barrel barrel = new Barrel.BarrelBuilder(rand.nextFloat(100))
                    .setMaterial(DataForBarrelRandom.materials.get(rand.nextInt(DataForBarrelRandom.materials.size())))
                    .setStoredMaterial(DataForBarrelRandom.storedMaterials.get(rand.nextInt(DataForBarrelRandom.storedMaterials.size())))
                    .build();
            list.add(barrel);
        }
        return list;
    }
}
