public class WordDistance {
    HashMap<String, ArrayList<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> a;
            if (map.containsKey(words[i])) {
                a = map.get(words[i]);
            } else {
                a = new ArrayList<>();
            }
            a.add(i);
            map.put(words[i], a);
        }
    }
    
    // Important to optimize this for O(n) instead of O(n^2) where n is the avg list length
    public int shortest(String word1, String word2) {
        ArrayList<Integer> w1 = map.get(word1);
        ArrayList<Integer> w2 = map.get(word2);
        
        int dist = Integer.MAX_VALUE;
        
        for (int i = 0, j = 0; i < w1.size() && j < w2.size(); ) {
            int index1 = w1.get(i);
            int index2 = w2.get(j);
            
            if (index1 < index2) {
                dist = Math.min(dist, index2 - index1);
                i++;
            } else {
                dist = Math.min(dist, index1 - index2);
                j++;
            }
        }
        
        return dist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
