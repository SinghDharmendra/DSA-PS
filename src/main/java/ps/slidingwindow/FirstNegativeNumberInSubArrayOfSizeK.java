package ps.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeNumberInSubArrayOfSizeK {
    public static void main(String[] args) {
        int [] nums ={12,-1,-7,8,-15,30,16,28};
        int k= 3;
        List<Integer> result = findFirstNegative(nums,k);
        System.out.println("result"+result);
    }

    private static List<Integer> findFirstNegative(int[] nums, int k) {
        int i=0, j=0;
        LinkedList<Integer> sub = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        while(j<nums.length){
            if(nums[j]<0){
                sub.add(nums[j]);
            }
            if(j-i+1<k){

                j++;
            }else if(j-i+1==k){
                if(sub.isEmpty()){
                    result.add(0);
                }else {
                    result.add(sub.getFirst());
                }
                if(nums[i]<0)
                sub.removeFirst();

                i++;
                j++;


            }
        }
        return result ;

    }
}
