class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left, result);

        // Visit root
        result.add(root.val);

        // Visit right subtree
        inorder(root.right, result);
    }
}
