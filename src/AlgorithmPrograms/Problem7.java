package AlgorithmPrograms;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem7 {
    public static void main(String[] args) {
        ArrayList<Integer> primes = generatePrimes(1000);
        System.out.println(primes.toString());
        System.out.println(primes.size());
    }

    public static ArrayList<Integer> generatePrimes(int n) {
        // creating an array of length n+1
        int[] numbers = new int[n + 1];

        // initializing all numbers with count 0
        Arrays.fill(numbers, 0);

        // checking for all numbers from 2 - n
        for (int num = 2; num <= n; num++) {
            // increase count for all multiples of num
            int curr = num + num;
            while (curr <= n) {
                numbers[curr]++;
                curr += num;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();

        // iterating and checking all indices, ones with 0 are primes
        for (int i = 2; i <= n; i++) {
            if (numbers[i] == 0) {
                primes.add(i);
            }
        }

        return primes;
    }
}
