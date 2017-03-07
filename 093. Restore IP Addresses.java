// https://leetcode.com/problems/restore-ip-addresses

public class Solution {
    public void helper(List<String> addrs, String s, int group, String remainder) {
        if (group == 4 && remainder.length() == 0) {
            System.out.println(s);
            addrs.add(s.substring(0, s.length()-1));
        } else {
            for (int c = 1; c <= Math.min(3, remainder.length()); c++) {
                String next = remainder.substring(0, c);
                if ((next.length() == 1) ||
                    (Integer.parseInt(next) <= 255 && !next.substring(0, 1).equals("0"))) {
                    helper(addrs, s+remainder.substring(0, c)+".", group+1, remainder.substring(c, remainder.length()));
                }
            }
        }
        return;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> out = new ArrayList<String>();
        if (s.length() >= 4 && s.length() <= 12) {
            helper(out, "", 0, s);
        }
        
        return out;
    }
}
