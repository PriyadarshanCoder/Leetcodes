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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
     // If the main tree is empty, it cannot contain any subtree
        if (root == null) return false;

        // If the current node's subtree matches subRoot, return true
        if (isIdentical(root, subRoot)) return true;

        // Otherwise, recursively check if subRoot is in the left or right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        // If both trees are empty, they are identical
        if (s == null && t == null) return true;

        // If one tree is empty but not both, they are not identical
        if (s == null || t == null) return false;

        // If current node values don't match, trees are not identical
        if (s.val != t.val) return false;

        // Check recursively for both left and right subtrees
        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}