package AlgorithmPrograms.Problem9;

public class BinarySearch<T extends Comparable<T>> {

    public int search(T target, T[] array) {
        return searchHelper(target, array, 0, array.length - 1);
    }

    private int searchHelper(T target, T[] array, int left, int right) {
        if (left <= right) {
            int mid = (right + left) / 2;

            // comparing using compareTo method
            int result = target.compareTo(array[mid]);
            if (result > 0) {
                return searchHelper(target, array, mid + 1, right);
            } else if (result < 0) {
                return searchHelper(target, array, left, mid - 1);
            } else {
                return mid;
            }
        }

        return -1;
    }
}
