package sorter.project.object_addition;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Man;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillFromRandom {
    static Random rand =new Random();
    static MenLastName[] menLastName = MenLastName.values();
    static WomenLastName[] womenLastName = WomenLastName.values();
    static AnimalWithoutWool[] animalWithoutWools = AnimalWithoutWool.values();
    static AnimalEyeColor[] animalEyeColors = AnimalEyeColor.values();
    static StoredMaterial[] storedMaterial = StoredMaterial.values();
    static Materials[] materials = Materials.values();



    public static List random(int count, String type){
        List<Object> list =new ArrayList<>();
        switch (type){
            case "Man": {
                for(int i=0;i<count;i++){
                    String gender = randomGender();
                    String lastName =randomLastName(gender);
                    Man man= new Man.ManBuilder(lastName)
                            .age(rand.nextInt(70))
                            .gender(gender)
                            .build();
                    list.add(man);
                }
                break;
            }
            case "Animal":{
                for(int i=0;i<count;i++){
                    boolean wool = rand.nextBoolean();
                    String types =randomTypeOfAnimal(wool);
                    Animal animal= new Animal.AnimalBuilder(types)
                            .wool(wool)
                            .eyeColor(animalEyeColors[rand.nextInt(animalEyeColors.length)].toString())
                            .build();
                    list.add(animal);
                }
                break;
            }
            case "Barrel":{
                for(int i=0;i<count;i++){

                    Barrel barrel= new Barrel.BarrelBuilder(rand.nextFloat(100))
                            .storedMaterial(storedMaterial[rand.nextInt(storedMaterial.length)].toString())
                            .material(materials[rand.nextInt(materials.length)].toString())
                            .build();
                    list.add(barrel);
                }
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }
    public static String randomGender(){
        if(rand.nextInt(3)>1) return "man";
        return "women";
    }
    public static String randomLastName(String gender){
        if(gender.equals("man")){
            return menLastName[rand.nextInt(menLastName.length)].toString();
        }
        return womenLastName[rand.nextInt(womenLastName.length)].toString();
    }
    public static String randomTypeOfAnimal(boolean wool){
        if(wool){ return "зверь";        }
        return animalWithoutWools[rand.nextInt(animalWithoutWools.length)].toString();
    }

}
