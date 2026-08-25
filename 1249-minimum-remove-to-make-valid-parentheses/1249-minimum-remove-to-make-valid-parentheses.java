import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        boolean[] remove = new boolean[s.length()];

        // Find invalid parentheses
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                // Store the index of '('
                stack.push(i);
            }

            else if (ch == ')') {

                if (!stack.isEmpty()) {
                    // Match with the previous '('
                    stack.pop();
                } else {
                    // No '(' available, so this ')' is invalid
                    remove[i] = true;
                }
            }
        }

        // Any '(' remaining in the stack is invalid
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Build the answer
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}