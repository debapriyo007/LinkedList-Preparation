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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)return null;
        //Fist write down the reverse code.
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = k;
        while(curr!= null && count > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
            count--;
        }
        if(curr == null && count > 0){
            curr = prev;
            prev = null;
            next = null;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr= next;
            }
        }
        if(count >0){
            return prev;
        }else{head.next = reverseKGroup(next, k);}
        
        return prev;
    }
}