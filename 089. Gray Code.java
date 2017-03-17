// https://leetcode.com/problems/gray-code
// magical bit manipulation see https://en.wikipedia.org/wiki/Gray_code
// doubt that it's possible to come up with this solution during 30 min interview without gray code familiarity!!!
// though it might be possible to look at the reflection pattern and do it the long way
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < 1<<n; i++) 
            result.add(i ^ i>>1);
            
        return result;
    }
}
