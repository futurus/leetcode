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
