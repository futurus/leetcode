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
    private int modeCount = 0; 
    private int curCount = 0;
    private int previous = Integer.MIN_VALUE;
    private ArrayList<Integer> ans;
    
    // Keywords are: Binary Search Tree, Inorder Traversal!!! (O(1) space)
    // However, a HashMap straightforward implementation is more likely (O(n) space)
    
    public void helper(TreeNode root) {
        if (root == null) return;
        
        helper(root.left);
        
        if (root.val != previous) {
            curCount = 1;
        } else {
            curCount++;
        }
        
        if (curCount >= modeCount) {
            if (curCount > modeCount) {
                ans.clear();
            }
            
            modeCount = curCount;
            ans.add(root.val);
        }
        
        previous = root.val;
        helper(root.right);
    }
    
    int [] convert(ArrayList<Integer> ans) {
        int[] out = new int[ans.size()];
        int j = 0;
        for (Integer i : ans) {
            out[j++] = i;
        }
        
        return out;
    }
    
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        this.ans = new ArrayList<>();
        
        helper(root);

        return convert(ans);
    }
}
