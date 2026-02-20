
// Node class representing each element in the linked list
class Node {
    int key;                // The value stored in the node
    Node next;              // Reference to the next node in the list
}

public class LinkedList {

    // Function to insert a new node at the beginning of the linked list
    public static Node listInsert(Node head, Node x) {
        x.next=head;        // Point the new node's next to the current head of the list
        head=x;             // Update the head to be the new node
        return head;        // return the new head of the list
    }

    // Function to search for a node with a specific key in the linked list
    public static Node listSearch(Node head, int key) {
        Node curr=head;         // start from the head of the list

        // Traverse the list until the end
        while(curr!=null) {
            if(curr.key==key) {
                return curr;        // If the current node's key matches the search key, return the node
            }
            curr=curr.next;         // Move to the next node in the list
        }
        return null;                // If the key is not found in the list, return null
    }

    // Function to delete a node from the linked list
    public static Node listDelete(Node head, Node x) {
        // If the node to be deleted is the head of the list, update the head to the next node, and return the new head
        if(x==head) {
            head=head.next;
            return head;
        }

        Node curr=head;             // Start from the head of the list

        // Traverse the list to find the node that points to the node to be deleted
        while(curr!=null) {
            // If the next node is the node to be deleted, update the current node's next to skip the node to be deleted
            if(curr.next==x) {
                curr.next=x.next;
                break;
            }
            curr=curr.next;     // Move to the next node in the list
        }
        return head;            // Return the head of the list after deletion
    }

    public static void main(String[] arge) {

        // Create nodes and assign keys
        Node node1=new Node();
        node1.key=1;

        Node node2=new Node();
        node2.key=2;

        Node node3=new Node();
        node3.key=3;

        Node node4=new Node();
        node4.key=4;

        // Set head to null (empty list)
        Node head=null;

        // Insert nodes into the linked list
        head=listInsert(head, node1);
        head=listInsert(head, node2);
        head=listInsert(head, node3);
        head=listInsert(head, node4);

        // Print the linked list
        Node printedNode=head;
        while(printedNode!=null) {
            System.out.print(printedNode.key +" ");
            printedNode=printedNode.next;
        }
        System.out.println();

        // Search for a node with key 3 in the linked list
        Node searchedNode=listSearch(head, 3);
        // If the node is found, print its key
        if(searchedNode!=null) {
            System.out.println("Node with key " +searchedNode.key +" found.");
        }
        // If the node is not found, print a message indicating that the node was not found
        else {
            System.out.println("Node not found.");
        }

        // Delete node2 from the list
        head=listDelete(head, node2);
        // Print the linked list after deletion
        printedNode=head;
        while(printedNode!=null) {
            System.out.print(printedNode.key +" ");
            printedNode=printedNode.next;
        }
        System.out.println();

    }
}
