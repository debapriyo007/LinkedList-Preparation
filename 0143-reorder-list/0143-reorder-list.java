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
    /* THIS QUESTION IS ALSO BE KNOWN AS -> "ZIGZAG" */
    
    public void reorderList(ListNode head) {
        //Step 1 :Findout Middle.
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }ListNode mid = slow;
        
        //step 2: Revrse the second half.
        //my seecond half head node is (mid.next).
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;
        ListNode next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //Step 3 : Merge two ll.
        //Left half head is
        ListNode lefHalf_Head = head;
        ListNode rightHalf_Head = prev; //why prev cause i revserse the ll so,my reverse ll head is always prev.
        ListNode tem1 , tem2;
        while(lefHalf_Head!= null && rightHalf_Head!= null){
            tem1 = lefHalf_Head.next;
            lefHalf_Head.next = rightHalf_Head;
            tem2 = rightHalf_Head.next;
            rightHalf_Head.next = tem1;
            
            lefHalf_Head = tem1;
            rightHalf_Head = tem2;
            }
        }
}