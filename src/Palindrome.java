
class ListNode {
    int key;
    ListNode next;
}

class MyList {
    ListNode head;

    MyList() {
        head=null;
    }

    public void insert(int key) {
        ListNode newNode=new ListNode();
        newNode.key=key;
        newNode.next=head;
        head=newNode;
    }
}

public class Palindrome {

    static ListNode left;

    public static ListNode palindromeHelper(ListNode right) {

        if(right==null) {
            return left;
        }

        ListNode node=palindromeHelper(right.next);

        if(node==null) {
            return null;
        }

        if(left.key!=right.key) {
            return null;
        }
        left=left.next;
        return node;
    }

    public static boolean isPalindrome(MyList list) {
        left=list.head;
        return palindromeHelper(list.head)!=null;
    }

    public static void main(String[] args) {

        // list 1: 1->2->3->2->1
        MyList list1=new MyList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(2);
        list1.insert(1);
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
        if(isPalindrome(list3)) {
            System.out.println("List 3 is a palindrome.");
        }
        else {
            System.out.println("List 3 is not a palindrome.");
        }


    }
}
