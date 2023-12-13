package AlgorithmPrograms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    public static void main(String[] args) {
        String sentence = "abcd";

        // print all combinations with iterative method
        ArrayList<String> permutations1 = getPermutationsIterative(sentence);
        System.out.println(permutations1.toString());

        // print all combinations with recursive method
        ArrayList<String> permutations2 = new ArrayList<>();
        getPermutationsRecursive(sentence, "", permutations2);
        System.out.println(permutations2.toString());

        // checking if both outputs are equal
        permutations1.sort((str1, str2) -> str1.compareTo(str2));
        permutations2.sort((str1, str2) -> str1.compareTo(str2));
        System.out.println(permutations1.equals(permutations2));
    }

    // recursive method to generate all permutations
    public static void getPermutationsRecursive(String str, String curr, ArrayList<String> strings) {
        // base case
        if (str.isEmpty()) {
            strings.add(curr);
            return;
        }

        // for every character, remove a character and add to strings
        for (int i = 0; i < str.length(); i++) {
            char toAdd = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1); // string after removing one character
            getPermutationsRecursive(remaining, curr + toAdd, strings);
        }
    }

    // iterative method to generate all permutations
    public static ArrayList<String> getPermutationsIterative(String str) {
        Queue<String> queue = new LinkedList<>();
        char[] charArr = str.toCharArray();
        queue.add("" + charArr[0]);
        for (int i = 1; i < charArr.length; i++) {
            char toAdd = charArr[i];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String curr = queue.poll();
                for (int k = 0; k <= curr.length(); k++) {
                    queue.add(curr.substring(0, k) + toAdd + curr.substring(k));
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
