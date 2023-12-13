package DataStructurePrograms;

import java.util.Scanner;
import DataStructures.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // reading text from console
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // creating linkedlist of string
        LinkedList<String> list = new LinkedList<>();

        // storing every word in string array and then in linked list
        String[] strArr = text.split(" ");
        for (String str : strArr) {
            list.add(str);
        }

        System.out.println(list);

        // word to search
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        if (list.search(word) == -1) {
            list.add(word);
            System.out.println("Word added successfully.");
        } else {
            list.deleteNode(word);
            System.out.println("Word deleted successfully.");
        }

        System.out.println(list);
        sc.close();
    }
}
