import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNumberGenerator {
	public static void main(String[] args) throws IOException {
		String filename = "SourcesOfTimSort/data.txt"; //Файл с данными для TimSort
		int[] arrayOfCountNumbersInLine = arrayGenerate(100, 100, 10000);
		System.out.println(Arrays.toString(arrayOfCountNumbersInLine));
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		Random rand = new Random();
		for (int i = 0; i < arrayOfCountNumbersInLine.length; i++) {
			for (int j = 0; j < arrayOfCountNumbersInLine[i]; j++) {
				int randomNumber = rand.nextInt();
				writer.write(Integer.toString(randomNumber));
				if (j - 1 != arrayOfCountNumbersInLine[i]) {
					writer.write(";");
				}
			}
			if (i < arrayOfCountNumbersInLine.length - 1) {
				writer.newLine();
			}
		}
		//На выходе получаем файл из n-строк, в которой записаны числа через ;
		writer.close();
		System.out.println("File " + filename + " generated successfully.");
	}
	//Данный метод создаёт массивы с кол-вом значений
	public static int[] arrayGenerate(int countOfNumbers, int min, int max) {

		Random rand = new Random();
		int[] array = new int[countOfNumbers];
		for (int i = 0; i < countOfNumbers; i++) {
			array[i] = rand.nextInt(max - min + 1) + min;
		}
		return array;
	}
}