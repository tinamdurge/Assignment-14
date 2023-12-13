package DataStructurePrograms;

import java.util.Arrays;
import DataStructures.*;

public class Problem10 {
    public static void main(String[] args) {
        // stack of primes and anagrams
        Stack<Integer> primesAndAnagrams = generatePrimesandAnagrams(0, 1000);

        // printing in reverse order
        while (!primesAndAnagrams.isEmpty()) {
            System.out.print(primesAndAnagrams.pop() + " ");
        }
    }

    public static Stack<Integer> generatePrimesandAnagrams(int start, int end) {
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

        Stack<Integer> anagrams = new Stack<>();
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            String keyVal = sortDigits(prime);

            if (hashTable.containsKey(keyVal) && hashTable.get(keyVal).size() >= 2) {
                anagrams.push(prime);
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
