//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
       if(head == null || head.next == null)return head; //base case.
       Node mid = getMid(head);
       //spereate ll.
       //rigth Half head node.
       Node rightHead = mid.next;
       mid.next = null;
       Node newL_Head = segregate(head);
       Node newR_Head = segregate(rightHead);
       //merger
       return merge(newL_Head,newR_Head);
    }
    
    //Find my middle node..
    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }return slow;
    }
    
    //mereg methord.
    public static Node merge(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node tem = dummy;
        while(l1!=null && l2!=null){
            if(l1.data<=l2.data){
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


