package AlgorithmPrograms;

import java.util.HashMap;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String first = sc.nextLine();

        System.out.print("Enter second string: ");
        String second = sc.nextLine();

        if (checkAnagram(first, second)) {
            System.out.println("The given strings are anagrams.");
        } else {
            System.out.println("The given strings are not anagrams.");
        }
        sc.close();
    }

    public static boolean checkAnagram(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();

        // adding chars of first string to map
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // removing chars of second string from map
        for (char c : str2.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                count--;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
}
