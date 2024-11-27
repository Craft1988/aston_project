package sorter.project.controller;

import sorter.project.entity.WorkingCollection;
import sorter.project.utils.InsertionSort;
import sorter.project.utils.QuickSort;
import sorter.project.utils.SortStrategy;
import sorter.project.entity.Human;
import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;

import java.util.*;

public class ExtraSortTheCollectionController {
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
                1. Human->Barrel
                2. Barrel->Human
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
        List<Human> humans = SortTheCollectionController.humanCollection(WorkingCollection.getCollection());
        List<Barrel> barrels = SortTheCollectionController.barrelCollection(WorkingCollection.getCollection());
        switch (typeChoice) {
            case 1:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(twoToOneCollection(
                        divideHuman(humans, sortStrategy),
                        divideBarrels(barrels, sortStrategy)));
                WorkingCollection.setIsSorted(true);

                break;
            case 2:
                WorkingCollection.deleteCollection();
                WorkingCollection.addInCollection(twoToOneCollection(
                        divideBarrels(barrels, sortStrategy),
                        divideHuman(humans, sortStrategy)));
                WorkingCollection.setIsSorted(true);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }
    }

    private static List<Object> divideHuman(List<Human> humans, SortStrategy sortStrategy) {
        List<Human> unsortingValues = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        int count=0;
        for (int i = 0; i < humans.size();) {
            if ((humans.get(i).getAge() % 2) == 0) {
                unsortingValues.add(humans.get(i));
                indexes.add(i+count);
                humans.remove(i);
                count++;
                i--;
            }
            i++;
        }
        List surtingValues = sortStrategy.sort(humans, Comparator.comparing(o -> ((Human) o).getAge()));
        for (int i = 0; i < unsortingValues.size(); i++) {
            surtingValues.add(indexes.get(i), unsortingValues.get(i));
        }
        return surtingValues;
    }

    private static List<Object> divideBarrels(List<Barrel> barrels, SortStrategy sortStrategy) {
        List<Barrel> unsortingValues = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        int count=0;
        for (int i = 0; i < barrels.size();) {
            if ((Math.round(barrels.get(i).getVolume()) % 2) == 0) {
                unsortingValues.add(barrels.get(i));
                indexes.add(i + count);
                barrels.remove(i);
                count++;
                i--;
            }
            i++;
        }
        List<Object> surtingValues = sortStrategy.sort(barrels, Comparator.comparing(o -> ((Barrel) o).getVolume()));
        for (int i = 0; i < unsortingValues.size(); i++) {
            surtingValues.add(indexes.get(i), unsortingValues.get(i));
        }
        return surtingValues;
    }

    private static List<Object> twoToOneCollection(List<Object> first, List<Object> second) {
        List<Object> result = new ArrayList<>();
        if (!first.isEmpty()) result.addAll(first);
        if (!second.isEmpty()) result.addAll(second);
        return result;
    }


}
