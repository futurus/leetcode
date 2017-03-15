// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

// NB: an extension of prob 108. Use slow/fast linked-list traversal to find mid element

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode runner = head, runnerX2 = head;

        while (runnerX2.next != tail && runnerX2.next.next != tail) {
            runner = runner.next;
            runnerX2 = runnerX2.next.next;
        }

        TreeNode root = new TreeNode(runner.val);
        root.left = helper(head, runner);
        root.right = helper(runner.next, tail);
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }
}
