package DataStructurePrograms;

import DataStructures.*;

public class Problem3 {
    public static void main(String[] args) {
        String expression = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
        if (isValidParenthesis(expression)) {
            System.out.println("Expression is balanced");
        } else {
            System.out.println("Expression is not balanced");
        }
    }

    public static boolean isValidParenthesis(String expression) {
        // creating a generic stack of characters
        Stack<Character> stack = new Stack<>();

        // push for (
        // pop for )
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            }

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        // check if stack is empty, true for balanced expressions
        return stack.isEmpty();
    }
}
