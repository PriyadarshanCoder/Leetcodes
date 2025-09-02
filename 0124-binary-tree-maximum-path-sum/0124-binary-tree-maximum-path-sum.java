/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum;  // global variable to keep track of the best result

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max contribution from left and right subtrees
        int left = Math.max(0, dfs(node.left));   // ignore if negative
        int right = Math.max(0, dfs(node.right)); // ignore if negative

        // Path that goes "through" this node
        int pathThroughNode = node.val + left + right;

        // Update global max if this path is better
        maxSum = Math.max(maxSum, pathThroughNode);

        // Contribution to parent (must choose only one side)
        return node.val + Math.max(left, right);
    }
}
