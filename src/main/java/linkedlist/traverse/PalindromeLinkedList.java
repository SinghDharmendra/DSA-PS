package linkedlist.traverse;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(2);
        head.next.next.next.next=new Node(1);

        boolean isPalindrome= check(head);
        System.out.println("isPalindrome: "+isPalindrome);



    }

    private static boolean check(Node head) {
        Node slow=head;
        Node fast=head;


        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }

        Node lastNode=slow;
        Node reverseHead=ReverseLinkedList.reverse(slow.next);

        boolean found=true;

        Node fhead=head;
        Node shead=reverseHead;

        while(fhead!=null && shead!=null){
            if(fhead.data!=shead.data){
                found=false;
                break;
            }
            fhead=fhead.next;
            shead=shead.next;
        }

        lastNode.next=ReverseLinkedList.reverse(reverseHead);
        ReverseLinkedList.traverseList(head);

        return found;


    }
}
