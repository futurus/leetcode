public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1, carry = 0, num = 0, digit1 = 0, digit2 = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0 || carry > 0) {
            digit1 = i < 0 ? 0 : (num1.charAt(i) - '0');
            digit2 = j < 0 ? 0 : (num2.charAt(j) - '0');
            num = digit1 + digit2 + carry;
            carry = num / 10;
            num %= 10;
            sb.insert(0, num);
            i--; j--;
        }
        
        return sb.toString();
    }
}
