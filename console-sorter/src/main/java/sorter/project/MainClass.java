package sorter.project;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Man;
import sorter.project.object_addition.FillFromRandom;
import sorter.project.utils.Sorter;

public class MainClass {

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
		List<Animal> animals = new ArrayList<>();
		List<Man> men =new ArrayList<>();
		List<Barrel> barrels = new ArrayList<>();
		animals=FillFromRandom.random(20,"Animal");
		men=FillFromRandom.random(20,"Man");
		barrels=FillFromRandom.random(20,"Barrel");
		for(Animal a:animals){
			System.out.println(a.toString());
		}
		for(Man a:men){
			System.out.println(a.toString());
		}
		for(Barrel a:barrels){
			System.out.println(a.toString());
		}


	}
}
