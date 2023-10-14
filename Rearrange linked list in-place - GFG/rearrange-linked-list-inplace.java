//{ Driver Code Starts
import java.util.*;
import java.lang.*;

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

class Rerrange
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i < n; i++)
            {
                int data = sc.nextInt();
                addToTheLast(new Node(data));
            }
            GfG gfg = new GfG();
            Node node = gfg.rearrange(head);
            printList(node);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}


// } Driver Code Ends


/*
The structure of linked list is the following

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
*/

class GfG 
{
    public static Node rearrange(Node root)
    {
        //Same question as "REORDER LIST in leetcode.."
        //Step 1 :Findout Middle.
        Node head = root;
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }Node mid = slow;
        
        //step 2: Revrse the second half.
        //my seecond half head node is (mid.next).
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //Step 3 : Merge two ll.
        //Left half head is
        Node lefHalf_Head = head;
        Node rightHalf_Head = prev; //why prev cause i revserse the ll so,my reverse ll head is always prev.
        Node tem1 , tem2;
        while(lefHalf_Head!= null && rightHalf_Head!= null){
            tem1 = lefHalf_Head.next;
            lefHalf_Head.next = rightHalf_Head;
            tem2 = rightHalf_Head.next;
            rightHalf_Head.next = tem1;
            
            lefHalf_Head = tem1;
            rightHalf_Head = tem2;
            }
            return head;
    }
}

