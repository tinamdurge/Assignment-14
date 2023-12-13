package DataStructurePrograms;

import java.util.Scanner;
import DataStructures.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking inputs
        System.out.print("Enter size of input list: ");
        int size = sc.nextInt();
        sc.nextLine();

        int[] inputs = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number: ");
            inputs[i] = sc.nextInt();
            sc.nextLine();
        }

        // creating mapping of slot numbers and linkedlist
        LinkedList<Integer>[] map = new LinkedList[11];

        // adding the numbers to the map
        for (int num : inputs) {
            if (map[num % 11] == null) {
                map[num % 11] = new LinkedList<>();
                map[num % 11].add(num);
            } else {
                map[num % 11].add(num);
            }
        }

        // printing the mappings
        for (int i = 0; i < 11; i++) {
            if (map[i] == null) {
                continue;
            } else {
                System.out.println(i + " -> " + map[i]);
            }
        }

        sc.close();
    }
}
