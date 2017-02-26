// https://leetcode.com/problems/generate-parentheses/?tab=Description
public class Solution {
    public void helper(List<String> result, int n, String sofar, int left, int right) {
        if (sofar.length() == n*2) {
            result.add(sofar);
            return;
        }
        
        if (left == right) {
            helper(result, n, sofar + "(", left + 1, right);
        } else if (left > right && left < n) {
            helper(result, n, sofar + "(", left + 1, right);
            helper(result, n, sofar + ")", left, right + 1);
        } else {
            helper(result, n, sofar + ")", left, right + 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<String>();
        helper(out, n, "", 0, 0);
        
        return out;
    }
}
