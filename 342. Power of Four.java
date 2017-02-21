public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 1) return true; // not liking this workaround
        String bin = Integer.toBinaryString(num);
        int pos = bin.length() - bin.indexOf('1');
        return (pos % 2 == 1) && (pos > 1) && (bin.indexOf('1', bin.indexOf('1')+1) == -1);
    }
}
