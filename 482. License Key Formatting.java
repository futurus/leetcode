public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String pre = S.replace("-", "");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < pre.length(); i++) {
            sb.append(pre.charAt(pre.length() - 1 - i));
            if (i % K == (K-1) && (i != pre.length() - 1)) {
                sb.append("-");
            }
        }
        
        return sb.reverse().toString().toUpperCase();
    }
}
