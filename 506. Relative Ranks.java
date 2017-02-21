public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);
        String[] ranks = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int rank = nums.length - Arrays.binarySearch(sortedNums, nums[i]);
            System.out.println(rank);
            if (rank == 1) {
                ranks[i] = "Gold Medal";
            } else if (rank == 2) {
                ranks[i] = "Silver Medal";
            } else if (rank == 3) {
                ranks[i] = "Bronze Medal";
            } else {
                ranks[i] = String.valueOf(rank);
            }
        }

        return ranks;
    }
}
