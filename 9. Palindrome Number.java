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


// for ref: https://discuss.leetcode.com/topic/8090/9-line-accepted-java-code-without-the-need-of-handling-overflow

public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}
