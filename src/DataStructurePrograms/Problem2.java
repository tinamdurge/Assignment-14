package DataStructurePrograms;

import java.util.Scanner;
import DataStructures.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking list of numbers as user input
        System.out.print("Enter size of list: ");
        int n = sc.nextInt();
        sc.nextLine();

        // creating ordered list for inputs
        OrderedList<Integer> orderedList = new OrderedList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number: ");
            orderedList.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.println(orderedList);

        // taking user input for a number
        System.out.print("Enter a number to search: ");
        int num = sc.nextInt();
        sc.nextLine();

        if (orderedList.search(num) == -1) {
            orderedList.add(num);
            System.out.println("Number added successfully.");
        } else {
            orderedList.deleteNode(num);
            System.out.println("Number deleted successfully.");
        }

        System.out.println(orderedList);
        sc.close();
    }
}
