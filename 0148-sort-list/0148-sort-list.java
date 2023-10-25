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
        //Step 1 : Find middle Node.
        ListNode mid = getMid(head);
        //Step 2: Separate left and rigth half.
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(rightHead);
        
        //Step 3: Merge two sorted List.
        return mergeTwoSortedList(newLeft,newRight);
   }
    
    //GetMid methord.
    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }return slow;
    }
    //mergeTwoSortedList Methord.
    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tem = dummy;
        while(l1!= null && l2!= null){
            if(l1.val<=l2.val){
                tem.next = l1;
                l1 = l1.next;
                tem = tem.next;
            }else{
                tem.next = l2;
                l2 = l2.next;
                tem = tem.next;
            }
        }
        while(l1!=null){
            tem.next = l1;
            l1 = l1.next;
            tem = tem.next;
        }
        while(l2!=null){
            tem.next = l2;
            l2 = l2.next;
            tem = tem.next;
        }return dummy.next;
    }
    
}