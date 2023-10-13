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
    public ListNode rotateRight(ListNode head, int k) {
        
        //base case.
        if(head == null || head.next == null || k == 0)return head;
        //Step 1: cal the size of ll.
        int len = 1;
        ListNode curr = head;
        while(curr.next!= null){
            curr = curr.next;
            len++;
        }
        //Now my curr pointing last node.
        curr.next = head;
        //Step 2 : find out the k .
         k = k%len;
         k = len - k;
        
        //step 3: Move my curr to 3 node.  // 1 ->2->3->4->5 
        while(k>0){
            curr = curr.next;
            k--;
        }
        
        //step 4: declear my head as my curr next node
        head = curr.next;
        curr.next = null; //break my link.
        
        return head;
    }
}