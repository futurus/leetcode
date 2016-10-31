public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        else {
            int max_pow = (int)Math.log10(x);
            
            for (int i = max_pow; i > 0; i--) {
                if ((Math.floor(x / Math.pow(10, i)) % 10) != 
                Math.floor((x % Math.pow(10, max_pow - i + 1)) / Math.pow(10, max_pow - i))) {
                    return false;
                }
            }
            
            return true;
        }
    }
}
