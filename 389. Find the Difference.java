public class Solution {
    public char findTheDifference(String s, String t) {
        String[] ss = s.split("");
        String[] ts = t.split("");
        Arrays.sort(ss);
        Arrays.sort(ts);
        
        for (int i = 0; i < ss.length; i++) {
            if (!ss[i].equals(ts[i])) {
                return ts[i].charAt(0);
            }
        }

        return ts[ts.length-1].charAt(0);
    }
}
