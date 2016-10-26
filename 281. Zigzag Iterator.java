public class ZigzagIterator {
    int index;
    int length;
    List<Integer> zzList;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        zzList = new ArrayList<Integer>();
        index = 0;
        length = v1.size() + v2.size();
        
        while (index < length) {
            if (index % 2 == 0) {
                if (v1.size() > 0)  {
                    zzList.add(v1.remove(0));
                } else {
                    zzList.add(v2.remove(0));
                }
            } else {
                if (v2.size() > 0) {
                    zzList.add(v2.remove(0));
                } else {
                    zzList.add(v1.remove(0));
                }
            }
            index++;
        }
        index = 0;
    }

    /**
     * General case (not tested): List of Lists
         public ZigzagIterator(List<List<Integer>> v) {
            zzList = new ArrayList<Integer>();
            for (int i = 0; i < v.size(); i++) {
                length += v.get(i).size();
            }
            index = 0; // keep track of number of elements in total
            int order = 0; // keep track of which list to remove next

            while (index < length) {
                while (v.get(order).size() == 0) {
                    order++;
                }
                zzList.add(v.get(order).remove(0));
                order++;
                index++;
            }
            index = 0;
        }
     */
    
    public int next() {
        return zzList.get(index++);
    }

    public boolean hasNext() {
        return index < length;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
