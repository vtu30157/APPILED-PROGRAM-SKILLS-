import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (!stack.isEmpty()
                    && stack.peek() > 0
                    && asteroid < 0) {

                int top = stack.peek();

                // Top asteroid is smaller
                if (top < -asteroid) {
                    stack.pop();
                    continue;
                }

                // Both asteroids have same size
                if (top == -asteroid) {
                    stack.pop();
                }

                // Current asteroid is destroyed
                destroyed = true;
                break;
            }

            // Current asteroid survives
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}