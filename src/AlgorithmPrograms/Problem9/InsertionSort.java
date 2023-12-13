package AlgorithmPrograms.Problem9;

public class InsertionSort<T extends Comparable<T>> {
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T curr = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(curr) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }
}
