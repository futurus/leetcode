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

// Space and Time improvement https://discuss.leetcode.com/topic/59378/short-python-java
public int findNthDigit(int n) {
    n -= 1;
    int digits = 1, first = 1;
    while (n / 9 / first / digits >= 1) {
        n -= 9 * first * digits;
        digits++;
        first *= 10;
    }
    return (first + n/digits + "").charAt(n%digits) - '0';
}
