class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        // Count each task
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Find the maximum frequency
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        // Number of tasks having maximum frequency
        int maxCount = 0;
        for (int c : count) {
            if (c == max) {
                maxCount++;
            }
        }

        // Calculate minimum intervals
        int result = (max - 1) * (n + 1) + maxCount;

        return Math.max(result, tasks.length);
    }
}