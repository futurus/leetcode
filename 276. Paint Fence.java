public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0 || (k == 1 && n >= 3)) {
            return 0;
        } else if (n == 1) {
            return k;
        } else {
            int [] ways = new int[n+1];
            ways[1] = k;
            ways[2] = k*k;
            
            for (int i = 3; i <= n; i++) {
                // Consider 2 cases:
                // - if nth post is of different color from (n-1)th post
                // - if nth post is of same color from (n-1)th post, which means 
                //   (n-1)th post is of different color from (n-2)th post
                ways[i] = ways[i-1] * (k-1) + ways[i-2] * (k-1); 
            }
        
            return ways[n];
        }
    }
}
