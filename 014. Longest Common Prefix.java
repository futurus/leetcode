// https://leetcode.com/problems/longest-common-prefix
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        else if (strs.length == 1) return strs[0];
        else {
            Arrays.sort(strs);
    
            String prefix = "";
            for (int i = 0; i < strs[0].length(); i++) {
                prefix = strs[0].substring(0, i+1);
                System.out.println(prefix);
                for (int s = 0; s < strs.length; s++) {
                    if (!prefix.equals(strs[s].substring(0, i+1))) {
                        return prefix.substring(0, prefix.length() - 1);
                    }
                }
            }
            
            return prefix;
        }
    }
}

// reference
// https://discuss.leetcode.com/topic/6987/java-code-with-13-lines

public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
