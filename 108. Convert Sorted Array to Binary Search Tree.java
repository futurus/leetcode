// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

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
    public TreeNode helper(int[] nums) {
        TreeNode root = null;
        
        if (nums.length > 0) {
            int mid = (nums.length - 1) / 2;
            root = new TreeNode(nums[mid]);
            root.left = helper(Arrays.copyOfRange(nums, 0, mid));
            root.right = helper(Arrays.copyOfRange(nums, mid + 1, nums.length));
        } 
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums);
    }
}
