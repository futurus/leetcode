// https://leetcode.com/problems/restore-ip-addresses

public class Solution {
    public void helper(List<String> addrs, String s, int group, String remainder) {
        if (group == 4 && remainder.length() == 0) {
            System.out.println(s);
            addrs.add(s.substring(0, s.length()-1));
        } else {
            for (int c = 1; c <= Math.min(3, remainder.length()); c++) {
                String next = remainder.substring(0, c);
                if ((next.length() == 1) ||
                    (Integer.parseInt(next) <= 255 && !next.substring(0, 1).equals("0"))) {
                    helper(addrs, s+remainder.substring(0, c)+".", group+1, remainder.substring(c, remainder.length()));
                }
            }
        }
        return;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> out = new ArrayList<String>();
        if (s.length() >= 4 && s.length() <= 12) {
            helper(out, "", 0, s);
        }
        
        return out;
    }
}


// interesting view point (similar to another problem done earlier 
// [https://github.com/futurus/leetcode/blob/master/401.%20Binary%20Watch.java]
// using direct approach sometimes is faster than recursive one)

// 4 nested for loops but runtime is <= 3^4 so no biggie
// inner most if checks for 0.010.x.x cases

// c++  code
vector<string> restoreIpAddresses(string s) {
    vector<string> ret;
    string ans;

    for (int a=1; a<=3; a++)
    for (int b=1; b<=3; b++)
    for (int c=1; c<=3; c++)
    for (int d=1; d<=3; d++)
        if (a+b+c+d == s.length()) {
            int A = stoi(s.substr(0, a));
            int B = stoi(s.substr(a, b));
            int C = stoi(s.substr(a+b, c));
            int D = stoi(s.substr(a+b+c, d));
            if (A<=255 && B<=255 && C<=255 && D<=255)
                if ( (ans=to_string(A)+"."+to_string(B)+"."+to_string(C)+"."+to_string(D)).length() == s.length()+3)
                    ret.push_back(ans);
        }    

    return ret;
}
