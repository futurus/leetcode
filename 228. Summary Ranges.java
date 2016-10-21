public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            if((i == nums.length - 1) || (nums[i+1] > nums[i] + 1)) {
                result.add(String.valueOf(nums[i]));
                i += 1;
            } else {
                int j = i + 1;
                int prev = nums[i];
                while (nums[j] == prev + 1) {
                    prev = nums[j];
                    j += 1;
                    if (j == nums.length) break;
                }
                
                result.add(String.valueOf(nums[i]) + "->" + String.valueOf(prev));
                i = j;
            }
            
        }
        
        return result;
    }
}
