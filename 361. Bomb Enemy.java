public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int maxKill = 0;
        
        // find empty cells
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int kill = 0;
                if (grid[r][c] == '0') {
                    int row = r;
                    while (--row >= 0 && grid[row][c] != 'W') {
                        if (grid[row][c] == 'E') kill++;
                    }
                    row = r;
                    while (++row < grid.length && grid[row][c] != 'W') {
                        if (grid[row][c] == 'E') kill++;
                    }
                    
                    int col = c;                    
                    while (--col >= 0 && grid[r][col] != 'W') {
                        if (grid[r][col] == 'E') kill++;
                    }
                    col = c;
                    while (++col < grid[r].length && grid[r][col] != 'W') {
                        if (grid[r][col] == 'E') kill++;
                    }
                    if (kill > maxKill) {
                        maxKill = kill;
                    }
                }
            }
        }
        return maxKill;
    }
}


// DP-ish solution for ref: https://discuss.leetcode.com/topic/50374/java-dp-solultion-o-mn-time-o-mn-space-beats-90
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // from left to right
        for (int i = 0; i < m; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) 
                current = process(grid, dp, i, current, j);
        }
        // from top to bottom
        for (int j = 0; j < n; j++) {
            int current = 0;
            for (int i = 0; i < m; i++) 
                current = process(grid, dp, i, current, j);
        }
        // from right to left
        for (int i = 0; i < m; i++) {
            int current = 0;
            for (int j = n - 1; j >= 0; j--) 
                current = process(grid, dp, i, current, j);
        }
        int ans = 0;
        // from bottom to top
        for (int j = 0; j < n; j++) {
            int current = 0;
            for (int i = m - 1; i >= 0; i--) {
                current = process(grid, dp, i, current, j);
                if (grid[i][j] == '0')  ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    private int process(char[][] c, int[][] dp, int i, int current, int j) {
        if (c[i][j] == 'W') current = 0;
        if (c[i][j] == 'E') current++;
        dp[i][j] += current;
        return current;
    }
}
