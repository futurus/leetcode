public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        
        int h = 0;
        while (h <= haystack.length() - needle.length()) {
            if (haystack.charAt(h) == needle.charAt(0)) {
                boolean match = true;
                for (int n = 0, hP = h; n < needle.length(); n++, hP++) {
                    if (haystack.charAt(hP) != needle.charAt(n)) {
                        match = false;
                        break;
                    }
                }
                if (match == true) {
                    return h;
                }
            }
            h++;
        }
        
        return -1;
    }
}
