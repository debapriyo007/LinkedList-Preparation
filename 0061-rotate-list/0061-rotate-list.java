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
        if(head == null || head.next == null || k==0)return head;
        //Compute the length of the ll.
        ListNode tem = head;
        int len = 1;
        while(tem.next!= null){
            tem = tem.next;
            len++;
        }
        
        tem.next = head;//coz when i calculate the len my tem is on last node.
        k = k%len;
        ListNode curr = head;
        for(int i = 1;i<len-k;i++){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}