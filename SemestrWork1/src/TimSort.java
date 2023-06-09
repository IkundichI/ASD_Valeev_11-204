class TimSort
{
    private static int countOfIteration = 0; //Создание переменной, которая будет считать кол-во итераций
    static int MIN_MERGE = 32; //Минимальный размер слияний
    public static int minRunLength(int n) //Данный метод приводит числа ближе к 32
    {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
            countOfIteration++;
        }
        return n + r;
    }

    public static void insertionSort(int[] arr, int left, int right) { //Это обычная сортировка вставками
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j + 1] = arr[j];
                j--;
                countOfIteration++;

            }
            arr[j + 1] = temp;
        }
    }
    public static void merge(int[] arr, int l, int m, int r) { //Данный метод склеивает отсортированные подмассивы
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
            countOfIteration++;
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
            countOfIteration++;
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
            countOfIteration++;
        }
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
            countOfIteration++;
        }
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
            countOfIteration++;
        }
    }
    public static int timSort(int[] arr)
    {
        int n = arr.length;
        int minRun = minRunLength(MIN_MERGE);
        for (int i = 0; i < n; i += minRun)
        {
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size)
        {
            for (int left = 0; left < n;
                 left += 2 * size)
            {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if(mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
        int countOfIteration1 = countOfIteration;
        countOfIteration = 0;
        return countOfIteration1;
    }
}



