package ps.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * given a data stream we need to find median at any instance
 *
 * Idea is to use two heaps left : maxHeap and right: minHeap
 * so that we can pull highest and lowest number in order of 1
 *
 * do re-balence in between these heaps inorder to keep a right track og middle elements of data stream
 */

public class MedianFromDataStream {
    PriorityQueue<Integer> left = new PriorityQueue<Integer>(Comparator.reverseOrder());
    PriorityQueue<Integer> right =new  PriorityQueue<Integer>();

    /** initialize your data structure here. */
    public MedianFromDataStream() {

    }

    public void addNum(int num) {
        if(left.isEmpty() || left.peek()>num){
            left.offer(num);
        }else{
            right.offer(num);
        }
        balence();

    }
    void balence(){
        PriorityQueue<Integer> bigger=(left.size()>right.size())?left:right;
        PriorityQueue<Integer> smaller=(left.size()>right.size())?right:left;
        while(bigger.size()-smaller.size()>=2){
            smaller.offer(bigger.poll());
        }

    }

    public double findMedian() {
        PriorityQueue<Integer> bigger=(left.size()>right.size())?left:right;
        PriorityQueue<Integer> smaller=(left.size()>right.size())?right:left;
        if(bigger.size()==smaller.size()){
            return (double)(bigger.peek()+smaller.peek())/2.0;
        }else{
            return (double) bigger.peek();
        }

    }

    public static void main(String[] args) {

    }
}
