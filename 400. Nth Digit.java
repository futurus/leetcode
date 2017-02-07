// Brute (Memory Limit)
public class Solution {
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; ; i++) {
            sb.append(i);
            
            if (sb.length() >= n) {
                return sb.charAt(n-1) - '0';
            }
        }
    }
}

// Space improvement (Time Limit)
public class Solution {
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; ; i++) {
            sb.append(i);
            
            if (n > sb.length()) {
                n -= sb.length();
                sb.delete(0, sb.length());
            } else {
                return sb.charAt(n-1) - '0';
            }
        }
    }
}
