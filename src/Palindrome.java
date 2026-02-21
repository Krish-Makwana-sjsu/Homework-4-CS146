
// ListNode class represents a node in the linked list
class ListNode {
    int key;
    ListNode next;
}

// Class to make a linked list and insert nodes into it
class MyList {
    ListNode head;

    // Constructor to initialize the linked list
    MyList() {
        head=null;
    }

    // Function to insert a new node with the given key at the beginning of the linked list
    public void insert(int key) {
        ListNode newNode=new ListNode();
        newNode.key=key;
        newNode.next=head;
        head=newNode;
    }
}

public class Palindrome {

    // Static variable to keep track of the left pointer during the recursive palindrome check
    static ListNode left;

    // Helper function to recursively check if the linked list is a palindrome
    public static ListNode palindromeHelper(ListNode right) {

        // If the right pointer has reached the end of the list, return the left pointer
        if(right==null) {
            return left;
        }

        // Recursively call the helper function with the next node of the right pointer
        ListNode node=palindromeHelper(right.next);

        // If the node returned from the recursive call is null, it means a mismatch was found, so return null
        if(node==null) {
            return null;
        }

        // If the keys of the left and right pointers do not match, return null to indicate that the list is not a palindrome
        if(left.key!=right.key) {
            return null;
        }
        left=left.next;     // Move the left pointer to the next node for the next comparison
        return node;        // Return the node to continue the recursive checks
    }

    // Function to check if the linked list is a palindrome
    public static boolean isPalindrome(MyList list) {
        left=list.head;                             // Initialize the left pointer to the head of the list
        return palindromeHelper(list.head)!=null;   // Return whether the helper function returns a non-null value
    }

    public static void main(String[] args) {

        // list 1: 1->2->3->2->1
        MyList list1=new MyList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(2);
        list1.insert(1);
        // Check if list 1 is a palindrome and print the result
        if(isPalindrome(list1)) {
            System.out.println("List 1 is a palindrome.");
        }
        else {
            System.out.println("List 1 is not a palindrome.");
        }

        // list 2: 10->20->20->10
        MyList list2=new MyList();
        list2.insert(10);
        list2.insert(20);
        list2.insert(20);
        list2.insert(10);
        // Check if list 2 is a palindrome and print the result
        if(isPalindrome(list2)) {
            System.out.println("List 2 is a palindrome.");
        }
        else {
            System.out.println("List 2 is not a palindrome.");
        }

        // list 3: 5->10->17
        MyList list3=new MyList();
        list3.insert(17);
        list3.insert(10);
        list3.insert(5);
        // Check if list 3 is a palindrome and print the result
        if(isPalindrome(list3)) {
            System.out.println("List 3 is a palindrome.");
        }
        else {
            System.out.println("List 3 is not a palindrome.");
        }


    }
}
