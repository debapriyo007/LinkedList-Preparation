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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = reverse(l1);
        ListNode right = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode tem = dummy;
        int c = 0;
        while(left!=null || right!=null){
            int s = 0 + c;
            if(left!=null){
                s+=left.val;
                left = left.next;
            }
            if(right!=null){
                s+=right.val;
                right = right.next;
            }
            c = s/10;
            s = s%10;
            tem.next = new ListNode(s);
            tem = tem.next;
        }
        if(c==1)tem.next = new ListNode(1);
        return reverse(dummy.next);
        
    }
    public static ListNode reverse(ListNode Node){
        //base case.
        if(Node == null)return Node;
        ListNode curr = Node;
        ListNode prev = null;
        ListNode next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}