//

// Time limit exceeded version
public class Solution {
    public int check(int[] nums, int divider) {
        int lSum = 0, rSum = 0;
        for (int i = 0; i < divider; i++) {
            lSum += nums[i];
        }
        for (int i = divider; i < nums.length; i++) {
            rSum += nums[i];
        }
        if (divider == 0) {
            return rSum;
        } else {
            return Math.max(lSum, rSum);
        }
    }
    
    public int helper(int[] nums) {
        int max = check(nums, 0);

        for (int div = 1; div <= nums.length - 1; div++) {
            int val = Math.max(check(nums, div), 
                               Math.max(helper(Arrays.copyOfRange(nums, 0, div)), 
                                        helper(Arrays.copyOfRange(nums, div, nums.length))));
            if (val >= max) {
                max = val;
            }
        }
        
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            return helper(nums);
        }
    }
}


// improvement, still failed

public class Solution {
    public int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
    
    public int helper(int[] nums) {
        int max = sum(nums);

        for (int div = 1; div <= nums.length - 1; div++) {
            int val = Math.max(helper(Arrays.copyOfRange(nums, 0, div)), 
                               helper(Arrays.copyOfRange(nums, div, nums.length)));
            if (val >= max) {
                max = val;
            }
        }
        
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            return helper(nums);
        }
    }
}


// Dynamic Programming approach
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return Integer.MIN_VALUE;
        else {
            int maxSoFar = nums[0], maxEndingHere = nums[0];
            
            for (int i=1; i < nums.length; i++){
            	maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            	maxSoFar      = Math.max(maxSoFar, maxEndingHere);	
            }
            
            return maxSoFar;
        }
    }
}

// another formulation
public class Solution {
    public int maxSubArray(int[] A) {
        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < A.length; i++){
            dp[i] = (dp[i - 1] > 0 ? dp[i - 1] : 0) + A[i];
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }   
}
