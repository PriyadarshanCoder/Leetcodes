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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0L)); // use long to avoid overflow

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            long startIndex = queue.peekFirst().index; // first element
            long endIndex   = queue.peekLast().index;  // last element

            maxWidth = Math.max(maxWidth, (int)(endIndex - startIndex + 1));

            for (int i = 0; i < currentLevelSize; i++) {
                Pair current = queue.pollFirst();
                long idx = current.index;

                if (current.node.left != null)
                    queue.offerLast(new Pair(current.node.left, idx * 2));
                if (current.node.right != null)
                    queue.offerLast(new Pair(current.node.right, idx * 2 + 1));
            }
        }

        return maxWidth;
    }

    static class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode n, long i) {
            node = n;
            index = i;
        }
    }
}