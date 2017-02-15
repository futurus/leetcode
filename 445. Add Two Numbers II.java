public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        int i = 1, j = 1;
        
        while(l1 != null){
            hm1.put(i, l1.val);
            l1 = l1.next;
            i++;
        }
        while(l2 != null){
            hm2.put(j, l2.val);
            l2 = l2.next;
            j++;
        }
        
        int carry = 0;
        i--; j--;
        ListNode head = null;
        
        while(i > 0 || j > 0 || carry > 0){
            int a = i > 0 ? hm1.get(i) : 0;
            int b = j > 0 ? hm2.get(j) : 0;
            int res = (a + b + carry) % 10;
            
            ListNode newNode = new ListNode(res);
            newNode.next = head;
            head = newNode;
            
            carry = (a + b + carry) / 10;
            i--; j--;
        }
        return head;
    }
}
// https://discuss.leetcode.com/topic/65271/straightforward-o-n-java-solution-without-modifying-input-lists
