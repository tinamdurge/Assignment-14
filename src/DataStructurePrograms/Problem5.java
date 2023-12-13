package DataStructurePrograms;

import java.util.Scanner;
import DataStructures.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking string input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // checking if string is palindrome or not
        if (isPalindrome(input)) {
            System.out.println("Given string is palindrome");
        } else {
            System.out.println("Given string is not palindrome");
        }

        sc.close();
    }

    public static boolean isPalindrome(String str) {
        DeQueue<Character> dequeue = new DeQueue<>();

        // adding the string to dequeue
        for (char c : str.toCharArray()) {
            dequeue.addFront(c);
        }

        // removing from dequeue and comparing
        while (dequeue.size() > 1) {
            char front = dequeue.removeFront();
            char rear = dequeue.removeRear();

            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}
