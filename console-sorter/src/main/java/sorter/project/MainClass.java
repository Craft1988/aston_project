package sorter.project;

import java.util.ArrayList;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.entity.Man;
import sorter.project.object_addition.FillFromConsole;
import sorter.project.object_addition.FillFromFile;
import sorter.project.object_addition.FillFromRandom;
import sorter.project.utils.Sorter;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнить массив");
            System.out.println("2. Сортировать массив");
            System.out.println("3. Найти элемент");
            System.out.println("4. Записать в файл");
            System.out.println("5. Выход");
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		Animal[] animals = { new Animal("Herbivore", true), new Animal("Pet", true), new Animal("Wild", false),
//				new Animal("Predator", true), new Animal("Any", true) };
//		Barrel[] barrels = { new Barrel(5.0f, "Wine", "Wooden"), new Barrel(2.0f, "Oil", "Plastic"),
//				new Barrel(1.5f, "Beer", "Metall") };
//
//		Sorter.sortAnyCustomClass(animals);
//		System.out.println(Arrays.toString(animals));
//		Sorter.sortAnyCustomClass(barrels);
//		System.out.println(Arrays.toString(barrels));
//		Animal an = animals[4];
//		System.out.println(Sorter.binarySearch(an, animals));
//		List<Animal> animals = new ArrayList<>();
//		List<Man> men =new ArrayList<>();
//		List<Barrel> barrels = new ArrayList<>();
//		animals=FillFromRandom.random(20,"Animal");
//		men=FillFromRandom.random(20,"Man");
//		barrels=FillFromRandom.random(20,"Barrel");
////		for(Animal a:animals){
////			System.out.println(a.toString());
////		}
////		for(Man a:men){
////			System.out.println(a.toString());
////		}
////		for(Barrel a:barrels){
////			System.out.println(a.toString());
////		}
//		System.out.println("\ncreate\n");
//		List<Animal> animals1= FillFromFile.fill(39,"Animal");
//		System.out.println("\nprint\n");
//		for(Animal a:animals1){
//			System.out.println(a.toString());
//		}
//		System.out.println("\ncreate\n");
//		List<Man> mens1= FillFromFile.fill(39,"Man");
//		System.out.println("\nprint\n");
//		for(Man a:mens1){
//			System.out.println(a.toString());
//		}
//		System.out.println("\ncreate\n");
//		List<Barrel> barrels1= FillFromFile.fill(39,"Barrel");
//		System.out.println("\nprint\n");
//		for(Barrel a:barrels1){
//			System.out.println(a.toString());
//		}


            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(23);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }


    }
}
        List<Animal> animals3 = new ArrayList<>();
        List example = FillFromConsole.fill("Animal");
        for(int i =0; i<example.size();i++){
            animals3.add((Animal) example.get(i));
        }
//        List<Man> men3 = new ArrayList<>();
//        List<Barrel> barrels3 = new ArrayList<>();

//        for (Barrel a : barrels3) {
//			System.out.println(a.toString());
//		}
//
//        for (Man a : men3) {
//			System.out.println(a.toString());
//		}

        for (Animal a : animals3) {
			System.out.println(a.toString());
		}


                }
            }
