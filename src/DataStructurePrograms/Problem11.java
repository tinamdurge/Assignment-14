package DataStructurePrograms;

import java.util.Arrays;
import DataStructures.*;

public class Problem11 {
    public static void main(String[] args) {
        // queue of primes and anagrams
        Queue<Integer> primesAndAnagrams = generatePrimesandAnagrams(0, 1000);

        // printing in same order
        while (!primesAndAnagrams.isEmpty()) {
            System.out.print(primesAndAnagrams.dequeue() + " ");
        }
    }

    public static Queue<Integer> generatePrimesandAnagrams(int start, int end) {
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

        Queue<Integer> anagrams = new Queue<>();
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            String keyVal = sortDigits(prime);

            if (hashTable.containsKey(keyVal) && hashTable.get(keyVal).size() >= 2) {
                anagrams.enqueue(prime);
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
