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
    public int longest(TreeNode root, int len) {
        // edge case is when tree is deep, we sometimes have to reset sequence
        // so must do Max(Max(left, prev.left), Max(right, prev.right))
        return Math.max(Math.max((root.left  == null) ? len : longest(root.left , (root.val+1 == root.left.val ) ? len + 1 : 1), len),
                        Math.max((root.right == null) ? len : longest(root.right, (root.val+1 == root.right.val) ? len + 1 : 1), len));
    }
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) { return 0; } else { return longest(root, 1); }
    }
}
