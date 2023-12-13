package DataStructurePrograms;

import DataStructures.*;

public class Problem8 {
    public static void main(String[] args) {
        // creating array of size 10 for ranges
        int[][] primesInRange = new int[10][];

        // storing range wise in 2D array
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> list = generatePrimes(i * 100, (i + 1) * 100);
            int[] inRange = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                inRange[j] = list.get(j);
            }
            primesInRange[i] = inRange;
        }

        // printing primes in range
        print2DArr(primesInRange);
    }

    public static LinkedList<Integer> generatePrimes(int start, int end) {
        LinkedList<Integer> primes = new LinkedList<>();

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void print2DArr(int[][] arr) {
        for (int i = 0; i < 10; i++) {
            System.out.print("(" + (i * 100) + "-" + (i + 1) * 100 + ") -> [ ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }
}
