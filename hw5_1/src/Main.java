public class Main {

    public static void main(String[] args) {

        int weignt = 201;
        int[] array = {1, 2, 3, 4, 200};
        int[] binaryArray;

        for (int i = 1; i < Math.pow(2, array.length); i++) {
            binaryArray = createBinaryArray(array.length, i);
            int sum = 0;
            for (int j = 0; j < binaryArray.length; j++) {
                if (binaryArray[j] == 1) {
                    sum += array[j];

                }
            }
            if (sum == weignt) {
                System.out.print(weignt + " -> ");
                for (int j = 0; j < binaryArray.length; j++) {
                    if (binaryArray[j] == 1) {
                        System.out.print(array[j] + " ");
                    }
                }
            }
        }
    }

    public static int[] createBinaryArray(int n, int num) {
        int[] arr = new int[n];
        String binaryStr = Integer.toBinaryString(num);
        int len = binaryStr.length();
        for (int i = 0; i < n; i++) {
            if (i < n - len) {
                arr[i] = 0;
            } else {
                arr[i] = Character.getNumericValue(binaryStr.charAt(i - (n - len)));
            }
        }
        return arr;
    }


}