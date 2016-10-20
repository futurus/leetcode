public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        
        int height = grid.length;
        int width = grid[0].length;

        int numOfIslands = 0;
        int[][] visited = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    boolean island = false;
                    ArrayList<Integer> nextR = new ArrayList<>();
                    nextR.add(i);
                    ArrayList<Integer> nextC = new ArrayList<>();
                    nextC.add(j);
                    
                    while (nextR.size() > 0) {
                        int r = nextR.remove(0);
                        int c = nextC.remove(0);

                        if (visited[r][c] == 0) {
                            visited[r][c] = 1;

                            if (island == false) {
                                numOfIslands++;
                                island = true;
                            }
                            if ((r - 1 >= 0 && r - 1 < height) && grid[r-1][c] == '1') {
                                nextR.add(r-1);
                                nextC.add(c);
                            }
                            if ((r + 1 >= 0 && r + 1 < height) && grid[r+1][c] == '1') {
                                nextR.add(r+1);
                                nextC.add(c);
                            }
                            if ((c - 1 >= 0 && c - 1 < width) && grid[r][c-1] == '1') {
                                nextR.add(r);
                                nextC.add(c-1);
                            }
                            if ((c + 1 >= 0 && c + 1 < width) && grid[r][c+1] == '1') {
                                nextR.add(r);
                                nextC.add(c+1);
                            }
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
