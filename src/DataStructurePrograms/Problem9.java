package DataStructurePrograms;

import java.util.Arrays;
import DataStructures.*;

public class Problem9 {
    public static void main(String[] args) {
        // creating array of size 10 for ranges
        int[][] primesAndAnagramsInRange = new int[10][];

        // storing range wise in 2D array
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> list = generatePrimesandAnagrams(i * 100, (i + 1) * 100);
            int[] inRange = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                inRange[j] = list.get(j);
            }
            primesAndAnagramsInRange[i] = inRange;
        }

        // print anagrams and primes
        Problem8.print2DArr(primesAndAnagramsInRange);
    }

    public static LinkedList<Integer> generatePrimesandAnagrams(int start, int end) {
        LinkedList<Integer> primes = Problem8.generatePrimes(start, end);
        HashTable<String, LinkedList<Integer>> hashTable = new HashTable<>();
        System.out.println("\nGenerating anagrams between " + start + " " + end);

        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            String keyVal = sortDigits(prime);

            if (!hashTable.containsKey(keyVal)) {
                hashTable.put(keyVal, new LinkedList<>());
            }

            hashTable.get(keyVal).add(prime);
        }

        LinkedList<Integer> anagrams = new LinkedList<>();
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            String keyVal = sortDigits(prime);

            if (hashTable.containsKey(keyVal) && hashTable.get(keyVal).size() >= 2) {
                anagrams.add(prime);
            }
        }

        return anagrams;
    }

    // method to get frequencies of digits of number and get unique string
    private static String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
