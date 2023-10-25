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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode mid = findMid(head);
        
        ListNode righthead = mid.next;
        mid.next = null;
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(righthead);
        return mergerList(leftHalf, rightHalf);
    }
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }return slow;
    }
    public static ListNode mergerList(ListNode l1 , ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tem = dummy;
        while(l1!= null && l2!=null){
            if(l1.val <= l2.val){
                tem.next = l1;
                tem = tem.next;
                l1 = l1.next;
            }else{
                tem.next = l2;
                tem = tem.next;
                l2 = l2.next;
            }
        }
        while(l1!=null){
            tem.next = l1;
            tem = tem.next;
            l1 = l1.next;
        }
         while(l2!=null){
            tem.next = l2;
            tem = tem.next;
            l2 = l2.next;
        } return dummy.next;
    }
   
}