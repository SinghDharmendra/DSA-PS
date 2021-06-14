package stack;

public class StackImpWithGetMiddleInOrderOf1 {
    DNode head=null,mid=null;
    int count=0;

    public static void main(String[] args) {
        StackImpWithGetMiddleInOrderOf1 ob=new StackImpWithGetMiddleInOrderOf1();
        ob.push(11);
        ob.push(22);
        ob.push(33);
        ob.push(44);
        ob.push(55);
        ob.push(66);
        ob.push(77);
        System.out.println("Item popped is " + ob.pop());
        System.out.println("Item popped is " + ob.pop());
        System.out.println("Middle Element is "
                + ob.findMiddle());


    }


    int pop(){
        if(count==0){
            System.out.printf("underflow");
            return -1;
        }
        DNode dataNode=head;
        head=head.next;
        if(head!=null){
            head.prev=null;
        }
        count--;
        if(count%2==0){
            mid=mid.next;
        }
        return dataNode.data;
    }
    void push(int data){
        DNode newNode=new DNode(data);
        newNode.prev=null;
        count++;
        newNode.next=head;
        if(count==1){
            mid=newNode;
        }else{
            head.prev=newNode;
            if(count%2!=0){
                mid=mid.prev;
            }
        }
        head=newNode;

    }
    int findMiddle(){
        if(count==0)
            System.out.println("Underflow");
        return mid.data;
    }

}

class DNode{
    int data;
    DNode prev,next;
    public DNode(){
    }
    public DNode(int data){
        this.data=data;
    }
}
