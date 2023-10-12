/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        //Step 1 : Calculate the length of two linklist.
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        //Step 2: Find out the diff betw ll, and move the pointer to that node.
        while(len1>len2){
            len1--;
            headA = headA.next;
        }
        while(len1<len2){
            len2--;
            headB = headB.next;
        }
        //Step 3: when ever my two poiter doesn't pointing same node move two pointer ahead.
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }return headA;
    }
    //Function to cal the length of ll.
    public static int getLen(ListNode Node){
        int len = 0;
        ListNode tem = Node;
        while(tem!=null){
            tem = tem.next;
            len++;
        }return len;*/
        
        
        /* Approach 2 */
        //base case.
        if(headA == null || headB == null)return null;
        ListNode tem1 = headA;
        ListNode tem2 = headB;
        while(tem1!= tem2){
            if(tem1 == null){
                tem1 = headB;
            }else{
                tem1 = tem1.next;
            }
            if(tem2 == null){
                tem2 = headA;
            }else{
                tem2 = tem2.next;
            }
        }return tem1;

    }
}