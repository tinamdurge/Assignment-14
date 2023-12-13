package AlgorithmPrograms;

public class Problem5 {
    public static void main(String[] args) {
        String[] strArr = { "Rajkot", "Mumbai", "Delhi", "Jaipur", "Lucknow", "Banaras" };
        System.out.println("Array before sorting: " + toString(strArr));
        mergeSort(strArr, 0, strArr.length - 1);
        System.out.println("Sorted array: " + toString(strArr));
    }

    public static void mergeSort(String[] strArr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;

            // recursively solve divisions
            mergeSort(strArr, left, mid);
            mergeSort(strArr, mid + 1, right);

            // merge the sorted divisions
            merge(strArr, left, right);
        }
    }

    // helper function to merge the sorted arrays
    public static void merge(String[] strArr, int left, int right) {
        int mid = (right + left) / 2;

        // two subarrays -> from l to m and from m+1 to r
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // two subarrays
        String[] leftArr = new String[len1];
        String[] rightArr = new String[len2];

        // initializing left subarray
        for (int i = 0; i < len1; i++) {
            leftArr[i] = strArr[left + i];
        }
        for (int i = 0; i < len2; i++) {
            rightArr[i] = strArr[mid + i + 1];
        }

        // merging the two arrays
        int leftPtr = 0;
        int rightPtr = 0;
        int arrPtr = left;

        while (leftPtr < len1 && rightPtr < len2) {
            if (leftArr[leftPtr].compareTo(rightArr[rightPtr]) < 0) {
                strArr[arrPtr] = leftArr[leftPtr];
                leftPtr++;
            } else {
                strArr[arrPtr] = rightArr[rightPtr];
                rightPtr++;
            }
            arrPtr++;
        }

        // adding remaining elements from left subarray
        while (leftPtr < len1) {
            strArr[arrPtr] = leftArr[leftPtr];
            leftPtr++;
            arrPtr++;
        }

        // adding remaning elements from right subarray
        while (rightPtr < len2) {
            strArr[arrPtr] = rightArr[rightPtr];
            rightPtr++;
            arrPtr++;
        }
    }

    public static String toString(String[] strArr) {
        String data = "[ ";
        for (int i = 0; i < strArr.length; i++) {
            if (i == strArr.length - 1) {
                data += strArr[i] + " ]";
            } else {
                data += strArr[i] + ", ";
            }
        }
        return data;
    }
}
