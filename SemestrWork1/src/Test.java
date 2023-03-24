import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 2, 4, 6};
		System.out.println(TimSort.timSort(arr));
		System.out.println(Arrays.toString(arr));
	}
}
