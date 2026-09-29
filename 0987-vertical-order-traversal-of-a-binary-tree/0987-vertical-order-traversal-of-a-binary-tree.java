class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> row -> min heap of values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue stores: node, row, column
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            // Create column if it doesn't exist
            map.putIfAbsent(col, new TreeMap<>());

            // Create row if it doesn't exist
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            // Add node value
            map.get(col).get(row).offer(node.val);

            // Left child
            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            }

            // Right child
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // TreeMap automatically gives columns from left to right
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            // Rows are automatically sorted top to bottom
            for (PriorityQueue<Integer> pq : rows.values()) {

                // Values at the same row and column
                // are sorted by value
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    // Helper class to store node position
    static class NodeInfo {
        TreeNode node;
        int row;
        int col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
