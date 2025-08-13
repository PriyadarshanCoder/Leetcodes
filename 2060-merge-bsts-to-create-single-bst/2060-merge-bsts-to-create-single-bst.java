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
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> roots = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        // Collect all roots; count every node value (root + immediate children)
        for (TreeNode t : trees) {
            roots.put(t.val, t);
            freq.merge(t.val, 1, Integer::sum);
            if (t.left  != null) freq.merge(t.left.val,  1, Integer::sum);
            if (t.right != null) freq.merge(t.right.val, 1, Integer::sum);
        }

        // Find the unique global root (its value occurs exactly once)
        TreeNode root = null;
        for (TreeNode t : trees) {
            if (freq.getOrDefault(t.val, 0) == 1) {
                if (root != null) return null; // more than one candidate
                root = t;
            }
        }
        if (root == null) return null;

        // Remove chosen root so only remaining trees can be grafted
        roots.remove(root.val);

        // Merge by grafting trees at matching leaves, while validating BST with bounds
        if (!mergeAndValidate(root, Long.MIN_VALUE, Long.MAX_VALUE, roots)) return null;

        // All trees must be used up
        return roots.isEmpty() ? root : null;
    }

    private boolean mergeAndValidate(TreeNode node, long low, long high,
                                     Map<Integer, TreeNode> roots) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;

        // If node is a leaf and matches a remaining tree's root, graft that tree here
        if (node.left == null && node.right == null) {
            TreeNode attach = roots.get(node.val);
            if (attach != null) {
                node.left = attach.left;
                node.right = attach.right;
                roots.remove(node.val);
            }
        }

        // Validate/graft recursively with BST bounds
        return mergeAndValidate(node.left,  low, node.val, roots) &&
               mergeAndValidate(node.right, node.val, high, roots);
    }
}