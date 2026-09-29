class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        // Both are null
        if (p == null && q == null) {
            return true;
        }

        // One is null, or values don't match
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Compare opposite sides
        return isMirror(p.left, q.right) &&
               isMirror(p.right, q.left);
    }
}
