package AlgorithmPrograms;

import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N (between 0 and 31): ");
        int exp = sc.nextInt();
        sc.nextLine();

        // initializing min and max value
        int min = 0;
        int max = (int) Math.pow(2, exp);
        System.out.println("Guess and Integer number between " + min + " and " + max);

        // binary search for number
        while (min <= max) {
            int mid = (max + min) / 2;
            System.out.print("Is your number between " + min + " and " + mid + "? (y/n): ");
            String choice = sc.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        // guess the number
        System.out.println("Your number is: " + min);
        sc.close();
    }
}
