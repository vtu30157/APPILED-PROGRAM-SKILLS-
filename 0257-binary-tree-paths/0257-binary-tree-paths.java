class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        dfs(root, "", result);

        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        if (path.isEmpty()) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        // If leaf, add complete path
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Explore left and right
        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}
