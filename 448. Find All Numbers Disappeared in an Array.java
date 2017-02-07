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
