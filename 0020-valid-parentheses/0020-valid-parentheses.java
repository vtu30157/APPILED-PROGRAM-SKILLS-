import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If it is an opening bracket, push it
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // If it is a closing bracket
            else {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check whether the brackets match
                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        // Stack must be empty if all brackets matched
        return stack.isEmpty();
    }
}