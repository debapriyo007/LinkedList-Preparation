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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //create a dummy node.
        ListNode dummy = new ListNode(-1);
        //take a pointer on dummy node.
        ListNode tem = dummy;
        
        //Now check two linkedList val.
        while(list1!= null && list2!= null){
            if(list1.val <= list2.val){
                tem.next = list1;
                list1 = list1.next;
                tem = tem.next;
            }else{
                tem.next = list2;
                list2 = list2.next;
                tem = tem.next;
            }
        }
        
        //for the remaing nodes.
        while(list1!= null){
            tem.next = list1;
            list1 = list1.next;
            tem = tem.next;
        }
        while(list2!= null){
            tem.next = list2;
            list2 = list2.next;
            tem = tem.next;
        }return dummy.next; //last return next node from dummy node.
    }
}