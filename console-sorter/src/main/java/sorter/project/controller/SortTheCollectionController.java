package sorter.project.controller;

import sorter.project.entity.WorkingCollection;
import sorter.project.utils.InsertionSort;
import sorter.project.utils.QuickSort;
import sorter.project.utils.SortStrategy;
import sorter.project.entity.Human;
import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;

import java.util.*;

public class SortTheCollectionController {
    public static void sortCollection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("1. Быстрая сортировка");
        System.out.println("2. Сортировка вставками");
        System.out.println("3. На главную");
        int choice = scanner.nextInt();
        if (choice == 3) {
            return;
        }
        System.out.println("""
                Выберите необходимый порядок:
                1. Animal->Human->Barrel
                2. Animal->Barrel->Human
                3. Human->Barrel->Animal
                4. Human->Animal->Barrel
                5. Barrel->Human->Animal
                6. Barrel->Animal->Human
                """);

        int typeChoice = scanner.nextInt();

        SortStrategy<Object> sortStrategy;
        switch (choice) {
            case 1:
                sortStrategy = new QuickSort<>();
                break;
            case 2:
                sortStrategy = new InsertionSort<>();
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }
        List animals = animalCollection(WorkingCollection.getCollection());
        List humans = humanCollection(WorkingCollection.getCollection());
        List barrels = barrelCollection(WorkingCollection.getCollection());
        switch (typeChoice) {
            case 1:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(threeToOneCollection(
                        sortStrategy.sort(animals, Comparator.comparing(o -> ((Animal) o).getType())),
                        sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getSurname())),
                        sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume()))));
                WorkingCollection.setIsSorted(true);

                break;
            case 2:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(threeToOneCollection(
                        sortStrategy.sort(animals, Comparator.comparing(o -> ((Animal) o).getType())),
                        sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume())),
                        sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getSurname()))));
                WorkingCollection.setIsSorted(true);
                break;
            case 3:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(threeToOneCollection(
                        sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getSurname())),
                        sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume())),
                        sortStrategy.sort(animals, Comparator.comparing(o -> ((Animal) o).getType()))));
                WorkingCollection.setIsSorted(true);
                break;
            case 4:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(threeToOneCollection(
                        sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getSurname())),
                        sortStrategy.sort(animals, Comparator.comparing(o -> ((Animal) o).getType())),
                        sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume()))));
                WorkingCollection.setIsSorted(true);
                break;
            case 5:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(threeToOneCollection(
                        sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume())),
                        sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getSurname())),
                        sortStrategy.sort(animals, Comparator.comparing(o -> ((Animal) o).getType()))));
                WorkingCollection.setIsSorted(true);
                break;
            case 6:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(threeToOneCollection(
                        sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume())),
                        sortStrategy.sort(animals, Comparator.comparing(o -> ((Animal) o).getType())),
                        sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getSurname()))));
                WorkingCollection.setIsSorted(true);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }
    }

    public static List<Animal> animalCollection(List<Object> list) {
        List<Animal> animals = new ArrayList<>();

        for (Object o : list) {
            if (o instanceof Animal) {
                animals.add((Animal) o);
            }
        }
        return animals;
    }

    public static List<Human> humanCollection(List<Object> list) {
        List<Human> humans = new ArrayList<>();

        for (Object o : list) {
            if (o instanceof Human) {
                humans.add((Human) o);
            }
        }
        return humans;
    }

    public static List<Barrel> barrelCollection(List<Object> list) {
        List<Barrel> barrels = new ArrayList<>();

        for (Object o : list) {
            if (o instanceof Barrel) {
                barrels.add((Barrel) o);
            }
        }
        return barrels;
    }

    private static List<Object> threeToOneCollection(List<Object> first, List<Object> second, List<Object> third) {
        List<Object> result = new ArrayList<>();
        if (!first.isEmpty()) result.addAll(first);
        if (!second.isEmpty()) result.addAll(second);
        if (!third.isEmpty()) result.addAll(third);
        return result;
    }
}
