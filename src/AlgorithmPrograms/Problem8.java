package AlgorithmPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class Problem8 {
    public static void main(String[] args) {
        // using the same class of previous problem to generate primes
        ArrayList<Integer> primes = Problem7.generatePrimes(1000);

        // getting all anagrams within these prime numbers
        HashMap<String, ArrayList<Integer>> anagrams = getAnagrams(primes);
        System.out.println("The groups of anagrams are: ");
        for (Map.Entry<String, ArrayList<Integer>> entry : anagrams.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getValue().toString());
            }
        }

        // getting all palindromes within these prime numbers
        ArrayList<Integer> palindromes = getPalindromes(primes);
        System.out.println("\nPalindrome numbers are: ");
        System.out.println(palindromes.toString());
    }

    // method to get all palindromes from list of primes
    public static ArrayList<Integer> getPalindromes(ArrayList<Integer> primes) {
        ArrayList<Integer> palindromes = new ArrayList<>();
        for (int prime : primes) {
            if (prime == reverse(prime)) {
                palindromes.add(prime);
            }
        }
        return palindromes;
    }

    // helper function to reverse an integer
    public static int reverse(int num) {
        int reverse = 0;
        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return reverse;
    }

    // method to get all anagrams from list of primes
    public static HashMap<String, ArrayList<Integer>> getAnagrams(ArrayList<Integer> primes) {
        HashMap<String, ArrayList<Integer>> anagrams = new HashMap<>();
        for (int prime : primes) {
            // storing the number as character array and sorting it
            char[] digits = String.valueOf(prime).toCharArray();
            Arrays.sort(digits);

            // converting number to string for key in hashmap
            String num = "";
            for (char c : digits) {
                num += c;
            }

            // updating the hashmap if number is anagram or not
            ArrayList<Integer> list;
            if (anagrams.containsKey(num)) {
                list = anagrams.get(num);
            } else {
                list = new ArrayList<>();
            }
            list.add(prime);
            anagrams.put(num, list);
        }
        return anagrams;
    }
}
