import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stores: number -> next greater element
        Map<Integer, Integer> map = new HashMap<>();

        // Stack stores elements waiting for their next greater element
        Stack<Integer> stack = new Stack<>();

        // Process nums2 from left to right
        for (int num : nums2) {

            // If current number is greater than stack top,
            // current number is the next greater element
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Elements remaining in stack have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}