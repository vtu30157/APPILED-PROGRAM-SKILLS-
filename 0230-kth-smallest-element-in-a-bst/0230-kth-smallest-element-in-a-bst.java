class Solution {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (true) {

            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the next smallest node
            current = stack.pop();
            k--;

            // kth smallest found
            if (k == 0) {
                return current.val;
            }

            // Move to right subtree
            current = current.right;
        }
    }
}
