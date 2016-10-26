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
