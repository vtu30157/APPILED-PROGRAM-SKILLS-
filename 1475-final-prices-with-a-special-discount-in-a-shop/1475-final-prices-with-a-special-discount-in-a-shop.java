import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] answer = prices.clone();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Current price can be the discount
            // for previous prices in the stack
            while (!stack.isEmpty() &&
                   prices[stack.peek()] >= prices[i]) {

                int index = stack.pop();

                answer[index] = prices[index] - prices[i];
            }

            // Store current index
            stack.push(i);
        }

        return answer;
    }
}