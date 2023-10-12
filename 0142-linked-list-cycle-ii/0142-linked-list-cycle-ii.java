/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){ //when my slow and fast are equal then 
                slow = head;  // slow move to the head.
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }return slow;
            }
        }return null;
        
    }
}