package AlgorithmPrograms;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a number: ");
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        bubbleSort(arr);
        System.out.println("Sorted array: " + toString(arr));

        sc.close();
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static String toString(int[] arr) {
        String data = "[ ";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                data += arr[i] + " ]";
            } else {
                data += arr[i] + ", ";
            }
        }
        return data;
    }
}
