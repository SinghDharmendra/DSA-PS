package ps;

import java.awt.dnd.DnDConstants;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int cap,size;
    Map<Integer,DNode> map=new HashMap<>();
    DNode head,tail;


    LRUCache(int cap){
        this.cap=cap;
        map=new HashMap<>();
        head=new DNode();
        tail=new DNode();
        size=0;
        head.next=tail;
        tail.prev=head;
    }

    void addNode(DNode node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    void deleteNode(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    void moveToHead(DNode node){
        deleteNode(node);
        addNode(node);
    }
    DNode popTail(){
        DNode prev=tail.prev;
        deleteNode(prev);
        return prev;
    }

    public int get(int k){
        if(map.containsKey(k)){
            moveToHead(map.get(k));
            return map.get(k).v;

        }
        return -1;
    }

    public void put(int k, int v){
        DNode popped=map.get(k);
        if(popped!=null){
            popped.v=v;
            moveToHead(popped);
        }else {
            DNode newNode=new DNode(k,v);
            size++;
            if(size>cap){
                DNode d=popTail();
                map.remove(d.k);
                size--;
            }
            addNode(newNode);
            map.put(k,newNode);
        }
    }



}

class DNode{
    int k,v;
    DNode prev,next;
    DNode(){}

    DNode(int k,int v){
        this.k=k;
        this.v=v;
        prev=null;
        next=null;
    }
}
