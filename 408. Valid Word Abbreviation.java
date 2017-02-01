public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() < abbr.length()) { // guard against "hi" vs "hi0"
            return false;
        }
        int i = 0;
        StringBuilder w = new StringBuilder();
        int r = 0;
        
        while (i < abbr.length()) {
            Character c = abbr.charAt(i);
            
            if (c >= 'a' && c <= 'z') {
                r = 0;
                w.append(abbr.charAt(i));
                i++;
            } else {
                if (c == '0') { return false; } // guard against "hi" vs "02"
                while (c < 'a' || c > 'z') {
                    r = r * 10 + (c - '0');
                    if (++i == abbr.length()) { break; }
                    c = abbr.charAt(i);
                }
                if (r <= word.length()) {
                    for (int j = 0; j < r; j++) {
                        w.append("-");
                    }
                } else { return false; } // guard against "hello" vs "99999"
            }
        }
        
        String w_rd = new String(w);
        
        if (word.length() != w_rd.length()) {
            return false;
        } else {
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) != '-' && w_rd.charAt(j) != '-' && word.charAt(j) != w_rd.charAt(j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
