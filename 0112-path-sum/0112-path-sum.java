class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Empty tree
        if (root == null) {
            return false;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Check left and right subtrees
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
