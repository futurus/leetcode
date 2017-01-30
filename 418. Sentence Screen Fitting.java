// TODO: optimize
// Consider sentence length and effective output from cols x rows


// Brute-force solution: timeout
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int nSentence = 0;
        int w = 0;

        for (int r = 0; r < rows; r++) {
            int c = 0;
            
            while (c < cols) {
                if ((c == 0 && sentence[w].length() <= cols)  // new row
                || (c != 0 && sentence[w].length() <= cols - c)) {
                    c += sentence[w].length() + 1;
                    w++;
                    
                    if (w == sentence.length) {
                        nSentence++;
                        w = 0;
                    }
                } else {
                    break;
                }
            }
        }
        
        return nSentence;
    }
}
