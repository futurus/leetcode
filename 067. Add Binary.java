public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length(), j = b.length();
        boolean carry = false;
        
        while (i > 0 || j > 0 || carry) {
            char f = --i < 0 ? '0' : a.charAt(i);
            char s = --j < 0 ? '0' : b.charAt(j);

            if (f == '1' && s == '1') {
                if (carry == true) {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                    carry = true;
                }
            } else if (f == '0' && s == '0') {
                if (carry == true) {
                    sb.insert(0, '1');
                    carry = false;
                } else {
                    sb.insert(0, '0');
                }
            } else {
                if (carry == true) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
            }
        }
        return sb.toString();
    }
}
