class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // Visit root
        result.add(root.val);

        // Visit left subtree
        preorder(root.left, result);

        // Visit right subtree
        preorder(root.right, result);
    }
}
