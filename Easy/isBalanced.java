class Solution {
     public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper function: returns height if balanced, else -1
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // left subtree not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // current node not balanced

        return 1 + Math.max(left, right); // return height if balanced
    }
}
