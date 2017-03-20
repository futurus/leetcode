// https://leetcode.com/problems/hamming-distance
// shortest?
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
