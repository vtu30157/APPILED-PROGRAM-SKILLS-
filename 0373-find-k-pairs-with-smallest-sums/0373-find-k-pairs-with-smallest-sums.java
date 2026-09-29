import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // Min heap: [sum, index1, index2]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Add first k elements from nums1 with nums2[0]
        int limit = Math.min(k, nums1.length);

        for (int i = 0; i < limit; i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            int i = current[1];
            int j = current[2];

            // Add pair to result
            result.add(Arrays.asList(nums1[i], nums2[j]));

            k--;

            // Move to next element in nums2
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return result;
    }
}
