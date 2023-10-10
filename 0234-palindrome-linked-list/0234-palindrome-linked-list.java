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
    public boolean isPalindrome(ListNode head) {
        //Step 1 : Find out the middle node.
        ListNode middleNode = findMid(head);
        //Step 2 : Reverse the 2nd half.
        ListNode prev = null;
        ListNode curr = middleNode;
        ListNode next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //Left half head will be ..
        ListNode leftHalf = head;
        ListNode righHalf = prev;
        //Step 3 : Check 1st half (leftHalf) and 2nd Half (righHalf) val.
        while(righHalf!= null){
            if(leftHalf.val!=righHalf.val){return false;}
            leftHalf = leftHalf.next;
            righHalf = righHalf.next;
        }return true;
        
    }
    
    //Findout middle node..
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!= null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }return slow;// slow is my middle node..
    }
    
}