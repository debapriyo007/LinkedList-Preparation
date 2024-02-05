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
    public void reorderList(ListNode head) {
        
        ListNode mid = Middle(head);
        ListNode secondHalf =Revrse(mid.next);
        mid.next = null;
        
        ListNode LeftHead = head;
        ListNode rightHead = secondHalf;
        ListNode tem1 = null;
        ListNode tem2 = null;
        
        while(LeftHead!= null && rightHead!= null){
            tem1 = LeftHead.next;
            LeftHead.next = rightHead;
            tem2 = rightHead.next;
            rightHead.next = tem1;
            
            LeftHead = tem1;
            rightHead = tem2;
            
        }
        
        
    }
    //calculate the middle of the ll
    public static ListNode Middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //Reverse function.
    public static ListNode Revrse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        return prev;
    }
}