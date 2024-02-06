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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tem = dummy;
        //move my tem one node before left .
        for(int i = 0;i<left-1;i++)tem = tem.next;
        ListNode st = tem.next;
        ListNode stNext = st.next;

        for(int i = 0 ;i<right-left ;i++){ // as given left = 2 
            st.next = stNext.next;         //          right = 4
            stNext.next = tem.next; //The loop run 2 times.
            tem.next = stNext;
            stNext = st.next;
        }
    // 1st iteration: dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // 2nd iteration: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
}