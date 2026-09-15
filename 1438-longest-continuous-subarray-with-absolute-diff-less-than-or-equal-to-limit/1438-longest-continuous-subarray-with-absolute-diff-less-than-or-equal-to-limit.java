class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0, ans = 0;

        java.util.Deque<Integer> maxDeque = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> minDeque = new java.util.ArrayDeque<>();

        for (int right = 0; right < n; right++) {

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right])
                maxDeque.pollLast();

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right])
                minDeque.pollLast();

            maxDeque.addLast(right);
            minDeque.addLast(right);

            while ((long) nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left)
                    maxDeque.pollFirst();

                if (minDeque.peekFirst() == left)
                    minDeque.pollFirst();

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}