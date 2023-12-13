package AlgorithmPrograms.Problem9;

import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> {
    public void sort(T[] array) {
        sortHelper(array, 0, array.length - 1);
    }

    private void sortHelper(T[] array, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;

            // recursively solve divisions
            sortHelper(array, left, mid);
            sortHelper(array, mid + 1, right);

            // merge the sorted divisions
            mergeHelper(array, left, right);
        }
    }

    // helper function to merge the sorted arrays
    private void mergeHelper(T[] array, int left, int right) {
        int mid = (right + left) / 2;

        // two subarrays -> from l to m and from m+1 to r
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // two subarrays
        ArrayList<T> leftArr = new ArrayList<>(len1);
        ArrayList<T> rightArr = new ArrayList<>(len2);

        // initializing left subarray
        for (int i = 0; i < len1; i++) {
            leftArr.add(array[left + i]);
        }
        for (int i = 0; i < len2; i++) {
            rightArr.add(array[mid + i + 1]);
        }

        // merging the two arrays
        int leftPtr = 0;
        int rightPtr = 0;
        int arrPtr = left;

        while (leftPtr < len1 && rightPtr < len2) {
            if (leftArr.get(leftPtr).compareTo(rightArr.get(rightPtr)) < 0) {
                array[arrPtr] = leftArr.get(leftPtr);
                leftPtr++;
            } else {
                array[arrPtr] = rightArr.get(rightPtr);
                rightPtr++;
            }
            arrPtr++;
        }

        // adding remaining elements from left subarray
        while (leftPtr < len1) {
            array[arrPtr] = leftArr.get(leftPtr);
            leftPtr++;
            arrPtr++;
        }

        // adding remaning elements from right subarray
        while (rightPtr < len2) {
            array[arrPtr] = rightArr.get(rightPtr);
            rightPtr++;
            arrPtr++;
        }
    }
}
