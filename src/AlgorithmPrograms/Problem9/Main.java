package AlgorithmPrograms.Problem9;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] strArr = { "Banaras", "Delhi", "Jaipur", "Lucknow", "Mumbai", "Rajkot" };
        Integer[] intArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        BinarySearch<String> strArrSearch = new BinarySearch<>();
        System.out.println(strArrSearch.search("Delhi", strArr));

        BinarySearch<Integer> intArrSearch = new BinarySearch<>();
        System.out.println(intArrSearch.search(3, intArr));

        MergeSort<Integer> intArrSort = new MergeSort<>();
        intArrSort.sort(intArr);
        for (int num : intArr) {
            System.out.print(num + " ");
        }

        System.out.println();

        MergeSort<String> strArrSort = new MergeSort<>();
        strArrSort.sort(strArr);
        for (String str : strArr) {
            System.out.print(str + " ");
        }
    }
}
