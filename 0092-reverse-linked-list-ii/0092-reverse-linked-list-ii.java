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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tem = dummy;
        int i = 1;
        while(i<left){
            tem = tem.next;
            i++;
        }
        ListNode curr = tem.next;
        ListNode next = curr.next;
        
        for(int j = 0;j<right-left;j++){
            curr.next = next.next;
            next.next = tem.next;
            tem.next = next;
            next = curr.next;
        }
        return dummy.next;
    }
}