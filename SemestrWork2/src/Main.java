import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Константы, которые показываеют количество этих операций
        final int INSERT = 1000000;
        final int SEARCH = 1000000;
        final int REMOVE = 100000;

        //Массивы для хранения времени работы каждой операции
        int[] timeToInsert = new int[INSERT];
        int[] timeToSearch = new int[SEARCH];
        int[] timeToRemove = new int[REMOVE];

        //Массивы с количеством итераций для каждого действия
        int[] countOfIterationToInsert = new int[INSERT];
        int[] countOfIterationToSearch = new int[SEARCH];
        int[] countOfIterationToRemove = new int[REMOVE];

        //Массив, в котором будут храниться число, после заполнения
        int[] numbers = new int[INSERT];

        Random rand = new Random();
        TwoThreeTree tree = new TwoThreeTree();

        //Добавление элементов в tree ( +random)
        for (int i = 0; i < INSERT; i++) {
            numbers[i] = rand.nextInt();
            long startTime = System.nanoTime();
            tree.insert(numbers[i]);
            long endTime = System.nanoTime();
            timeToInsert[i] = (int) ((endTime - startTime));
            countOfIterationToInsert[i] = tree.getCountOfIteration();
        }

        //Поиск элементов в tree
        for (int i = 0; i < SEARCH; i++) {
            int randomMarkInArray = rand.nextInt(0, numbers.length);
            long startTime = System.nanoTime();
            tree.search(numbers[randomMarkInArray]);
            long endTime = System.nanoTime();
            timeToSearch[i] = (int) ((endTime - startTime));
            countOfIterationToSearch[i] = tree.getCountOfIteration();
        }

        //Удаление элементов из tree
        for (int i = 0; i < REMOVE; i++) {
            int randomMarkInArray = rand.nextInt(0, numbers.length);
            long startTime = System.nanoTime();
            tree.remove(numbers[randomMarkInArray]);
            long endTime = System.nanoTime();
            timeToRemove[i] = (int) ((endTime - startTime));
            countOfIterationToRemove[i] = tree.getCountOfIteration();
        }

        //Вывод данных
        System.out.println("Информация о времени работы 2-3 Tree {в наносекундах}:");
        printInfo("Time of Insert", timeToInsert);
        printInfo("Time of Search", timeToSearch);
        printInfo("Time of Remove", timeToRemove);

        System.out.println("\n" + "Информация о кол-ве итераций в работе 2-3 Tree:");
        printInfo("Iteration of Insert", countOfIterationToInsert);
        printInfo("Iteration of Search", countOfIterationToSearch);
        printInfo("Iteration of Remove", countOfIterationToRemove);

    }

    //Метод для печати данных об операциях {remove, insert, search}
    public static void printInfo(String infoText, int[] array) {
        System.out.println("| " + infoText + ": max -> " +
                Arrays.stream(array).max().getAsInt() + "; min -> " +
                Arrays.stream(array).min().getAsInt() + "; average -> " +
                Arrays.stream(array).average().getAsDouble());
    }
}