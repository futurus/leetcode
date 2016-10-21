public class ValidWordAbbr {
    Map<String, HashSet<String>> abbrs2Words;
    public ValidWordAbbr(String[] dictionary) {
        abbrs2Words = new HashMap<>();
        
        for (String word : dictionary) {
            String k = abbr(word);
            
            if (!abbrs2Words.containsKey(k)) {
                HashSet<String> v = new HashSet<String>();
                v.add(word);
                abbrs2Words.put(k, v);
            } else {
                HashSet<String> v = abbrs2Words.get(k);
                v.add(word);
                abbrs2Words.put(k, v);
            }
        }
    }

    public boolean isUnique(String word) {
        String k = abbr(word);
        // if a new word, or the only word, then unique
        // otherwise, it's not
        if ((!abbrs2Words.containsKey(k)) ||
            (abbrs2Words.containsKey(k) && abbrs2Words.get(k).contains(word) && abbrs2Words.get(k).size() == 1)) {
            return true;
        }
        
        return false;
    }
    
    private String abbr(String word) {
        if (word.length() <= 2) {
            return word;
        } else {
            int len = word.length();
            return word.charAt(0) + String.valueOf(len - 2) + word.charAt(len-1);
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");


// Shorter solution for ref (https://discuss.leetcode.com/topic/30533/java-solution-with-one-hashmap-string-string-beats-90-of-submissions/2)
public class ValidWordAbbr {
    HashMap<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String str:dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key)){
                if(!map.get(key).equals(str)){
                    map.put(key, "");
                }
            }
            else{
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word))||map.get(getKey(word)).equals(word);
    }
    
    String getKey(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }
}
