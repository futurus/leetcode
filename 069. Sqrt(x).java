public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) { return x; }
        else {
            // Binary/Newton's
            long r = x;
            while (r*r > x)
                r = (r + x/r) / 2;
            return (int) r;
        }
    }
}
