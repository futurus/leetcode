public class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int nAdj = 0;
                    
                    if (row == 0 || grid[row-1][col] == 0) 
                        nAdj++;
                    
                    if (col == 0 || grid[row][col-1] == 0) 
                        nAdj++;
                    
                    if (row == grid.length - 1 || grid[row+1][col] == 0) 
                        nAdj++;
                    
                    if (col == grid[row].length - 1 || grid[row][col+1] == 0) 
                        nAdj++;
                        
                    perimeter += nAdj;
                }
            }
        }
        
        return perimeter;
    }
}
