/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int binSearch(int min, int max) {
        int mid = min + (max - min)/2;
        if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) == -1) {
            return binSearch(min, mid);
        } else {
            return binSearch(mid + 1, max);
        }
    }
    
    public int guessNumber(int n) {
        return binSearch(1, n);
    }
}
