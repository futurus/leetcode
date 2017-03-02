// much inelegant! but extensible

// https://leetcode.com/problems/integer-to-roman
public class Solution {
    public String intToRoman(int num) {
        String [] cLevels = new String[] {"I", "V", "X", "L", "C", "D", "M"};
        StringBuilder out = new StringBuilder();
        int i = 0;
        
        while(num > 0) {
            int digit = num % 10;
            switch (digit) {
                case 1:
                case 2:
                case 3:
                    out.insert(0, new String(new char[digit]).replace("\0", cLevels[0 + i * 2]));
                    break;
                case 4:
                    out.insert(0, cLevels[0 + i * 2] + cLevels[1 + i * 2]);
                    break;
                case 5:
                    out.insert(0, cLevels[1 + i * 2]);;
                    break;
                case 6:
                case 7:
                case 8:
                    out.insert(0, cLevels[1 + i * 2] + new String(new char[digit - 5]).replace("\0", cLevels[0 + i * 2]));
                    break;
                case 9:
                    out.insert(0, cLevels[0 + i * 2] + cLevels[2 + i * 2]);
                    break;
                default:
                    break;
            }
            num /= 10;
            i++;
        }
        return out.toString();
    }
}


// quickie, however not extensible
// https://discuss.leetcode.com/topic/39799/simple-java-solution
public class Solution {
    private static String M[] = {"","M","MM","MMM"};
    private static String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    private static String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    private static String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    
    public String intToRoman(int num) {
	    StringBuilder roman = new StringBuilder();
	    return roman.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]).toString();
    }
}
