package AlgorithmPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = { "Rajkot", "Mumbai", "Delhi", "Jaipur", "Lucknow", "Banaras" };

        // sort the array for performing binary search
        Arrays.sort(strArr);

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();
        int index = binarySearch(word, 0, strArr.length - 1, strArr);
        if (index == -1) {
            System.out.println("Word not found.");
        } else {
            System.out.println("Word found at index " + index);
        }
        sc.close();
    }

    public static int binarySearch(String target, int left, int right, String[] strArr) {
        if (left > right) {
            return -1;
        }
        int mid = (right + left) / 2;
        int result = target.compareTo(strArr[mid]);
        if (result > 0) {
            return binarySearch(target, mid + 1, right, strArr);
        } else if (result < 0) {
            return binarySearch(target, left, mid - 1, strArr);
        } else {
            return mid;
        }
    }
}
