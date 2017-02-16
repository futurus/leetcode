// 1 scan, O(1) memory, w/o modifying input
// works because of condition that ships are separate

public class Solution {
    public int countBattleships(char[][] board) {
        int nship = 0;
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'X') {
                    if (r == 0 && c == 0) {
                        nship++;
                    } else if (r == 0) {
                        if (board[r][c-1] == '.') {
                            nship++;
                        }
                    } else if (c == 0) {
                        if (board[r-1][c] == '.') {
                            nship++;
                        }
                    } else { // (r > 0 && c > 0)
                        if (board[r-1][c] == '.' && board[r][c-1] == '.') {
                            nship++;
                        }
                    }
                }
            }
        }
        
        return nship;
    }
}
