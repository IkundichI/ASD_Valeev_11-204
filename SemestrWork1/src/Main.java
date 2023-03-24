import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		String filename = "SourcesOfTimSort/logsOfIteration.txt"; //Создаём файл, в который поместим все наши данные полученные от TimSort
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		try (Scanner scanner = new Scanner(new File("SourcesOfTimSort/data.txt"))) { //Чтение файла
			while (scanner.hasNextLine()) {

				String[] lineArray = scanner.nextLine().split(";");
				int[] arrayOfNumbers = new int[lineArray.length];
				for (int i = 0; i < lineArray.length; i++) {
					arrayOfNumbers[i] = Integer.parseInt(lineArray[i]);
				}
				writer.write(String.valueOf(arrayOfNumbers.length));
				writer.write(";");
				long startTime = System.nanoTime();
				TimSort.timSort(arrayOfNumbers);
				long endTime = System.nanoTime();
				long secondsOfLineSort = (int)((endTime - startTime)); // в наносекундах их и будем использовать для диаграмм
				writer.write(String.valueOf(secondsOfLineSort));
				writer.write(";");
				writer.write(String.valueOf(TimSort.timSort(arrayOfNumbers)));
				writer.newLine();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
		System.out.println("File " + filename + " generated successfully.");
	}
}