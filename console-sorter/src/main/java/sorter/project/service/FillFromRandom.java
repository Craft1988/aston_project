package sorter.project.service;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.entity.enums.AnimalEyeColor;
import sorter.project.entity.enums.AnimalWithWool;
import sorter.project.entity.enums.AnimalWithoutWool;
import sorter.project.entity.enums.Materials;
import sorter.project.entity.enums.MenLastName;
import sorter.project.entity.enums.StoredMaterial;
import sorter.project.entity.enums.WomenLastName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class FillFromRandom {
    private final static Random rand = new Random();
    private final static MenLastName[] menLastName = MenLastName.values();
    private final static WomenLastName[] womenLastName = WomenLastName.values();
    private final static AnimalWithoutWool[] animalWithoutWools = AnimalWithoutWool.values();
    private final static AnimalWithWool[] animalWithWools = AnimalWithWool.values();
    private final static AnimalEyeColor[] animalEyeColors = AnimalEyeColor.values();
    private final static StoredMaterial[] storedMaterial = StoredMaterial.values();
    private final static Materials[] materials = Materials.values();
    private static List list = new ArrayList<>();


    public static List fill(int count, String type) {
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
            return menLastName[rand.nextInt(menLastName.length)].toString();
        }
        return womenLastName[rand.nextInt(womenLastName.length)].toString();
    }

    private static String randomTypeOfAnimal(boolean wool) {
        if (wool) {
            return animalWithWools[rand.nextInt(animalWithWools.length)].toString();
        }
        return animalWithoutWools[rand.nextInt(animalWithoutWools.length)].toString();
    }

    private static List createAnimal(int count) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            boolean wool = rand.nextBoolean();
            String types = randomTypeOfAnimal(wool);
            Animal animal = new Animal.AnimalBuilder(types)
                    .setEyeColor(animalEyeColors[rand.nextInt(animalEyeColors.length)].toString())
                    .setWool(wool)
                    .build();
            list.add(animal);
        }
        return list;
    }

    private static List createMan(int count) {
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

    private static List createBarrel(int count) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Barrel barrel = new Barrel.BarrelBuilder(rand.nextFloat(100))
                    .setMaterial(materials[rand.nextInt(materials.length)].toString())
                    .setStoredMaterial(storedMaterial[rand.nextInt(storedMaterial.length)].toString())
                    .build();
            list.add(barrel);
        }
        return list;
    }
}
