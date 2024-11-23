package sorter.project;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;

public class MainClass {
    public static void main(String[] args) {
        // тестим создание объекта билдером
        Animal animal = new Animal.AnimalBuilder("Bird", "Black", false).build();
        Barrel barrel = new Barrel.BarrelBuilder(1.1, "Gold", "Iron").build();
        Human human = new Human.HumanBuilder("men", 55, "Tarantino").build();
        System.out.println(animal);
        System.out.println(barrel);
        System.out.println(human);
    }
}
