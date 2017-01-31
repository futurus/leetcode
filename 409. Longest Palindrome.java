public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), 1);
            } else {
                count.put(s.charAt(i), count.get(s.charAt(i))+1);
            }
        }
        
        int sum = 0;
        for (Integer v : count.values()) {
            sum += (v/2) * 2;
        }
        
        return (sum == s.length()) ? sum : sum + 1;
    }
}
