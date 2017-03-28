// https://leetcode.com/problems/number-complement

public class Solution {
    public int highestBit(int num) {
        int pos = 0;
        while (num != 0) {
            pos++;
            num >>= 1;
        }
        return pos;
    }
    
    public int findComplement(int num) {
        int highest = highestBit(num);
        int ones = 0;
        
        for (int i = 1; i <= highest; i++) {
            ones = (ones << 1) | 1;
        }
        
        return ones ^ num;
    }
}
