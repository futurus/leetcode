public class Solution {
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U');
    }
    
    public String reverseVowels(String s) {
        if (s.length() == 0) return new String();
        
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int i = 0, j = s.length() - 1;
        
        while (i <= j) {
            while (i < j && !isVowel(s.charAt(i))) {
                left.append(s.charAt(i));
                i++;
            }
            
            while (j > i && !isVowel(s.charAt(j))) {
                right.append(s.charAt(j));
                j--;
            }
            
            if (i == j) { 
                left.append(s.charAt(j));
                break; 
            }
            right.append(s.charAt(i));
            left.append(s.charAt(j));
            i++;
            j--;
        }
        
        return new String(left.append(right.reverse()));
    }
}
