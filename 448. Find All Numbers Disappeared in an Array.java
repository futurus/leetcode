public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, false);
        }
        
        for (int i : nums) {
            map.put(i, true);
        }
        
        for (Integer i : map.keySet()) {
            if (!map.get(i)) {
                out.add(i);
            }
        }
        
        return out;
    }
}

// Consider working directly on the input to achieve O(1) space
List<Integer> result = new ArrayList<Integer>();
    for( int i=0;i< nums.length; i++){
        int index = nums[i];
        if(nums[Math.abs(index)-1] > 0){
            nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
        }
    }

    for(int j =1 ;j <= nums.length ; j++){
        if(nums[j-1] > 0){
            result.add(j);
        }
    }
    return result;
}
