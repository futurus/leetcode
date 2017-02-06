public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> out = new ArrayList<String>();
        BitSet bsh = null;
        BitSet bsm = null;
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                bsh = new BitSet(4);
                bsm = new BitSet(6);
                String[] hour = Integer.toBinaryString(h).split("");
                String[] min = Integer.toBinaryString(m).split("");
                
                for (int i = 0; i < hour.length; i++) {
                    if (hour[hour.length-1-i].equals("1")) {
                        bsh.set(4-1-i);
                    }
                }
                for (int i = 0; i < min.length; i++) {
                    if (min[min.length-1-i].equals("1")) { 
                        bsm.set(6-1-i);
                    }
                }
                
                if (bsh.cardinality() + bsm.cardinality() == num) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h).append(":").append(m < 10 ? "0" : "").append(m);
                    out.add(new String(sb));
                }
            }
        }
        return out;
    }
}

// More elegant:
public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<>();
    for (int h=0; h<12; h++)
        for (int m=0; m<60; m++)
            if (Integer.bitCount(h * 64 + m) == num)
                times.add(String.format("%d:%02d", h, m));
    return times;        
}
