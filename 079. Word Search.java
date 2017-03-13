// https://leetcode.com/problems/word-search

public class Solution {
    public boolean helper(char[][]board, String word, boolean[][] visited, int r, int c) {
        if (word.length() == 0) { 
            return true; 
        }
        else {
            char nChar = word.charAt(0);
            visited[r][c] = true;
            if (r - 1 >= 0 
                && !visited[r-1][c] 
                && board[r-1][c] == nChar 
                && helper(board, word.substring(1, word.length()), visited, r-1, c)) {
                    return true;
            }
            if (r + 1 < board.length 
                && !visited[r+1][c] 
                && board[r+1][c] == nChar
                && helper(board, word.substring(1, word.length()), visited, r+1, c)) {
                    return true;
            }
            if (c - 1 >= 0 
                && !visited[r][c-1] 
                && board[r][c-1] == nChar
                && helper(board, word.substring(1, word.length()), visited, r, c-1)) {
                    return true;
            }
            if (c + 1 < board[r].length 
                && !visited[r][c+1] 
                && board[r][c+1] == nChar
                && helper(board, word.substring(1, word.length()), visited, r, c+1)) {
                    return true;
            }
            visited[r][c] = false;
            
            return false;
        }
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if (board.length * board[0].length >= word.length()) {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[r].length; c++) {
                    if (board[r][c] == word.charAt(0)) {
                        if(helper(board, word.substring(1, word.length()), visited, r, c)) 
                            return true;
                    }
                }
            }
        }
        
        return false;
    }
}
