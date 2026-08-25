import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int value : pushed) {

            // Push the value
            stack.push(value);

            // If the top of stack matches popped[j],
            // we can pop it
            while (!stack.isEmpty()
                    && j < popped.length
                    && stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        // If all elements were popped successfully
        return stack.isEmpty();
    }
}