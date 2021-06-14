package linkedlist.insert;

class Node{
    int data;
    Node next;
    Node(){}
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LinkedListInsertion {

    public static void main(String[] args) {
        LinkedListInsertion linkedListInsertion=new LinkedListInsertion();

        Node head=linkedListInsertion.addNodeAtFront(null,10);
        linkedListInsertion.addAtLast(head,20);
        linkedListInsertion.addAtLast(head,30);
        linkedListInsertion.printAllNode(head);



    }

    Node addNodeAtFront(Node head,int data){
        Node newNode=new Node(data);
        if(head==null){
            return newNode;
        }else{
            newNode.next=head;
            head=newNode;
            return head;
        }
    }

    void addNodeAfterGivenNode(Node node,int data){
        Node newNode=new Node(data);
        if(node==null){
            System.out.print("Underflow");
        }

        newNode.next=node.next;
        node.next=newNode;



    }

    Node addAtLast(Node head,int data){
        Node newNode=new Node(data);
        if(head==null)
            return newNode;
        else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
            return head;
        }

    }
    void printAllNode(Node head){
        System.out.println("printAllNode");
       Node current=head;
       while(current!=null){
           System.out.println(current.data);
           current=current.next;
       }
    }

}
