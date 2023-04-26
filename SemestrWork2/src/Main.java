import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final int INSERT = 10000;
        final int SEARCH = 100;
        final int REMOVE = 1000;

        int[] timeToInsert = new int[INSERT];
        int[] timeToSearch = new int[SEARCH];
        int[] timeToRemove = new int[REMOVE];

        int[] countOfIterationToInsert = new int[INSERT];
        int[] countOfIterationToSearch = new int[SEARCH];
        int[] countOfIterationToRemove = new int[REMOVE];


        int[] numbers = new int[INSERT];
        Random rand = new Random();
        TwoThreeTree tree = new TwoThreeTree();
        //Метод для создания массива рандомный чисел
        for (int i = 0; i < INSERT; i++) {
            numbers[i] = rand.nextInt();
        }

        //Добавление элементов в tree
        for (int i = 0; i < INSERT; i++) {
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
        System.out.println("| Time of Insert: max -> " +
                Arrays.stream(timeToInsert).max().getAsInt() + "; min -> " +
                Arrays.stream(timeToInsert).min().getAsInt() + "; average -> " +
                Arrays.stream(timeToInsert).average().getAsDouble());
        System.out.println("| Time of Search: max -> " +
                Arrays.stream(timeToSearch).max().getAsInt() + "; min -> " +
                Arrays.stream(timeToSearch).min().getAsInt() + "; average -> " +
                Arrays.stream(timeToSearch).average().getAsDouble());
        System.out.println("| Time of Remove: max -> " +
                Arrays.stream(timeToRemove).max().getAsInt() + "; min -> " +
                Arrays.stream(timeToRemove).min().getAsInt() + "; average -> " +
                Arrays.stream(timeToRemove).average().getAsDouble());

        System.out.println("Информация о кол-ве итераций в работе 2-3 Tree:");
        System.out.println("| Iteration of Insert: max -> " +
                Arrays.stream(countOfIterationToInsert).max().getAsInt() + "; min -> " +
                Arrays.stream(countOfIterationToInsert).min().getAsInt() + "; average -> " +
                Arrays.stream(countOfIterationToInsert).average().getAsDouble());
        System.out.println("| Iteration of Search: max -> " +
                Arrays.stream(countOfIterationToSearch).max().getAsInt() + "; min -> " +
                Arrays.stream(countOfIterationToSearch).min().getAsInt() + "; average -> " +
                Arrays.stream(countOfIterationToSearch).average().getAsDouble());
        System.out.println("| Iteration of Remove: max -> " +
                Arrays.stream(countOfIterationToRemove).max().getAsInt() + "; min -> " +
                Arrays.stream(countOfIterationToRemove).min().getAsInt() + "; average -> " +
                Arrays.stream(countOfIterationToRemove).average().getAsDouble());


    }
}