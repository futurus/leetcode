public class Solution {
    public boolean validUtf8(int[] data) {
        ArrayList<String> octs = new ArrayList<>();
        
        for (int i : data) {
            octs.add(Integer.toBinaryString( (1 << 8) | i ).substring( 1 ));
        }
        
        int cIndex = 0;
        
        while (cIndex < data.length) {
            String b = octs.get(cIndex);
            
            if (b.substring(0, 5).equals("11110")) { // check 4-byte
                if (cIndex + 3 >= octs.size() 
                    || !octs.get(cIndex+1).substring(0, 2).equals("10")
                    || !octs.get(cIndex+2).substring(0, 2).equals("10")
                    || !octs.get(cIndex+3).substring(0, 2).equals("10")) {
                    return false;
                }
                
                cIndex += 4;
            } else if (b.substring(0, 4).equals("1110")) { // check 3-byte
                
                if (cIndex + 2 >= octs.size() 
                    || !octs.get(cIndex+1).substring(0, 2).equals("10")
                    || !octs.get(cIndex+2).substring(0, 2).equals("10")) {
                    return false;
                }
                
                cIndex += 3;
            } else if (b.substring(0, 3).equals("110")) {  // check 2-byte
                if (cIndex + 1 >= octs.size() 
                    || !octs.get(cIndex+1).substring(0, 2).equals("10")) {
                    return false;
                }
                
                cIndex += 2;
            } else if (b.substring(0, 1).equals("0")) { // check 1-byte
                cIndex += 1;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
