package AlgorithmPrograms;

public class Problem3 {
    public static void main(String[] args) {
        String[] strArr = { "Rajkot", "Mumbai", "Delhi", "Jaipur", "Lucknow", "Banaras" };
        System.out.println("Array before sorting: " + toString(strArr));
        insertionSort(strArr);
        System.out.println("Sorted array: " + toString(strArr));
    }

    public static void insertionSort(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String curr = strArr[i];
            int j = i - 1;
            while (j >= 0 && strArr[j].compareTo(curr) > 0) {
                strArr[j + 1] = strArr[j];
                j--;
            }
            strArr[j + 1] = curr;
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
