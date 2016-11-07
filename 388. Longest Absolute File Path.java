public class Solution {
    public int lengthLongestPath(String input) {
        String [] entities = input.split("\n");
        int maxLen = 0;
        int curLvl = 0;
        String curPath = "";
        
        for (int i = 0; i < entities.length; i++) {
            int tab = entities[i].length() - entities[i].replace("\t", "").length();

            // adjustment to current path
            while (tab < curLvl) {
                curPath = curPath.substring(0, curPath.lastIndexOf("/"));
                curLvl--;
            }

            // add dir/file to path
            curPath += "/" + entities[i].replace("\t", "");
            curLvl++;
            
            System.out.println(curPath);

            if ((curPath.length() > maxLen) && curPath.contains(".")) {
                maxLen = curPath.length();
            }
        }
        
        if (maxLen > 0) {
            return (maxLen-1);
        } else { 
            return 0;
        }
    }
}
