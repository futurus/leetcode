// https://leetcode.com/problems/unique-binary-search-trees-ii

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
    public List<TreeNode> generate(int first, int last) {
        List<TreeNode> list = new ArrayList<>();
        
        if (first > last) {
            list.add(null);
        } else if (first == last) {
            list.add(new TreeNode(first));
        } else {
            List<TreeNode> left = new ArrayList<>();
            List<TreeNode> right = new ArrayList<>();
            
            for (int i = first; i <= last; i++) {
                left = generate(first, i - 1);
                right = generate(i + 1, last);
                
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        
        return generate(1, n);
    }
}
