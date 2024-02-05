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
        
        //Fist I have to create a dummy node.
        ListNode dummy = new ListNode(-1);
        //attached the dummynode with the main ll.
        dummy.next = head;
        //Take 3 pointer on dummy node.
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode next = dummy;
        
        //Now, claculate the size of the ll.
        int size = 0;
        while(curr.next!= null){ //why curr.next ? --> curr pointer on dummynode.
            curr = curr.next;
            size++;
        }
        
        while(size>=k){
            curr = prev.next; //intilize my curr poniter.
            next = curr.next;//intilize my next poniter.
            for(int i = 1;i<k;i++){  //this loop will run two time coz i want to remove two links.that's why i will be start from 1.
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            size-=k;
        }
        return dummy.next;
    }
}