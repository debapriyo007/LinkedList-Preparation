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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Step 1 : first calculate the size..
        int size = 0;
        ListNode tem = head;
        while(tem!=null){
            tem = tem.next;
            size++;
        }
        
        
        
        //base case , suppose i have to delete my head node means my size == n.
        if(size == n){
            head = head.next;
            return head;
        }
        //Step 2 : find out my nth prev node which willn be --> size - n.
        int i = 1;
        ListNode prev = head;
        while(i<size -n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}