// https://leetcode.com/problems/combinations

public class Solution {
    public void helper(List<List<Integer>> result, ArrayList<Integer> current, int n, int k, int last) {
        if (current.size() == k) {
            result.add((ArrayList)current.clone());
            return;
        } else {
            for (int i = last; i <= n; i++) {
                current.add(i);
                helper(result, current, n, k, i+1);
                current.remove(current.indexOf(i));
            }
            return;
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        helper(result, new ArrayList<Integer>(), n, k, 1);
        
        return result;
    }
}
