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
      private TreeNode nextRight = null; // Tracks the previously processed node
    public void flatten(TreeNode root) { 
        if (root == null) return;

        // Reverse preorder: right → left → root
        flatten(root.right);
        flatten(root.left);

        // Rewire pointers
        root.right = nextRight;
        root.left = null;
        nextRight = root;
    }
}
