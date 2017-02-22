// NB:
// - elements might contain more than 1 digit

public class Solution {
    public boolean isValidSerialization(String preorder) {
        ArrayList<String> list = new ArrayList<String>();
        String [] elems = preorder.split(",");

        for (int i = 0; i < elems.length; i++) {
            list.add(elems[i]);

            while (list.size() > 2 
            && list.get(list.size()-1).equals("#")
            && list.get(list.size()-2).equals("#")
            && !list.get(list.size()-3).equals("#")) {
                // remove the two nulls
                list.remove(list.size()-1); list.remove(list.size()-1); 
                
                // replace the last element with a null
                list.remove(list.size()-1); list.add("#");
            }
        }

        return (list.size() == 1 && list.get(0).equals("#"));
    }
}
