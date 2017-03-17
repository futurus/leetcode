// https://leetcode.com/problems/text-justification

public class Solution {
    public int getLineWidth(List<String> words) {
        int width = 0;
        
        for (String word : words) {
            width += word.length() + 1;
        }
        
        return width;
    }
    
    public String formatLine(List<String> words, int maxWidth, boolean lastSentence) {
        StringBuilder sb = new StringBuilder();
        
        if (words.size() == 1 || lastSentence) { // left-justified single-word line
            for (String word : words) {
                sb.append(word);
                if (sb.length() < maxWidth) {
                     sb.append(" ");
                }
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
        } else {
            List<StringBuilder> wordBuilder = new ArrayList<>();
            int wordLength = 0;
            for (String word : words) {
                wordBuilder.add(new StringBuilder(word));
                wordLength += word.length();
            }
            
            int spaceToDist = maxWidth - wordLength;
            int i = 0;
            
            while (spaceToDist > 0) {
                wordBuilder.get(i).append(" ");
                spaceToDist--;
                i++;
                if (i == words.size() - 1) {
                    i = 0;
                }
            }
            
            for (StringBuilder wBuilder : wordBuilder) {
                sb.append(wBuilder);
            }
        }
        
        return sb.toString();
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        
        if (maxWidth == 0) {
            lines.add("");
            return lines;
        }
        
        List<String> cLine = new ArrayList<>();
        
        for (String word : words) {
            if (getLineWidth(cLine) + word.length() <= maxWidth) {
                cLine.add(word);
            } else {
                lines.add(formatLine(cLine, maxWidth, false));
                cLine = new ArrayList<>();
                cLine.add(word);
            }
        }
        lines.add(formatLine(cLine, maxWidth, true));
        
        return lines;
    }
}
