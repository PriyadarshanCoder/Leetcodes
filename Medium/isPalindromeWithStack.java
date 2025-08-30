import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;

        // Step 1: push all nodes into stack
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        // Step 2: compare while popping
        curr = head;
        while (curr != null) {
            if (curr.val != stack.pop()) return false;
            curr = curr.next;
        }

        return true;
    }
}
