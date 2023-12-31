/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //step 1 :Create a dummy node.
        ListNode dummy = new ListNode(-1);
        ListNode tem = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = 0 + carry;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            sum = sum % 10;
            tem.next = new ListNode(sum);
            tem = tem.next;
        }if(carry == 1)tem.next = new ListNode(1);
        return dummy.next;
        
    }
}