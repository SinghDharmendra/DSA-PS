package linkedlist.traverse;


public class FlatteningOfSortedLinkedList {
    class Node
    {
        int data;
        Node right, down;
        Node(int data)
        {
            this.data = data;
            right = null;
            down = null;
        }
    }

    Node head;


    /* Driver program to test above functions */
    public static void main(String args[])
    {
        FlatteningOfSortedLinkedList L = new FlatteningOfSortedLinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }

    private Node flatten(Node root) {
        if(root==null || root.right==null)
            return root;
        
            root.right=flatten(root.right);
        
            root=merge1(root,root.right);
            
            return  root;
        

    }

    private Node merge(Node a, Node b) {
        if(a==null)
            return b;
        if(b==null)
            return a;

        Node result;

        if(a.data<b.data){
            result=a;
            result.down=merge(a.down,b);
        }else{
            result=b;
            result.down=merge(a,b.down);
        }

        return result;


    }

    private Node merge1(Node a, Node b) {
        if(a==null)
            return b;
        if(b==null)
            return a;

        Node result=new Node(-1);
        Node dummy=result;

        while(a!=null && b!=null){
            if(a.data<b.data){
                result.down=a;
                a=a.down;

            }else{
                result.down=b;
                b=b.down;
            }
            result=result.down;

        }
        if(a!=null){
            result.down=a;
        }
        if(b!=null){
            result.down=b;
        }



        return dummy.down;


    }


    Node push(Node head_ref, int data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

}
