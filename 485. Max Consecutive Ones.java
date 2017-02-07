public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { 
                cur = 0;
            } else {
                cur += 1;
                if (cur > max) {
                    max = cur;
                }
            }
        }
        
        return max;
    }
}
