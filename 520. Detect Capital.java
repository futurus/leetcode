public class Solution {
    public boolean detectCapitalUse(String word) {
        return (word.equals(word.toUpperCase()))
        || (word.equals(word.toLowerCase())) 
        || ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' 
            && word.substring(1, word.length()).equals(word.substring(1, word.length()).toLowerCase()));
    }
}
