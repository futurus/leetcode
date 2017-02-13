public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        
        if (n < 0) {
            x = 1/x;
            // very silly workaround
            n =(n == Integer.MIN_VALUE) ? Integer.MAX_VALUE - 1 : -n;
        }
        
        return (n % 2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
