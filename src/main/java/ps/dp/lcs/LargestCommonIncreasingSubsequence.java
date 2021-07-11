package ps.dp.lcs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * this is a dp problem where at every index we need to find how long sub sequence
 * can be while considering this element
 */

public class LargestCommonIncreasingSubsequence {
    public static void main(String[] args) {
        int nums []= {10,9,2,5,3,7,101,18};
        int maxLength=findMaxLengthOfLargestCommonIncreasingSubsequence(nums);
        System.out.println("maxLength : "+maxLength);
    }

    private static int findMaxLengthOfLargestCommonIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int t [] = new int[n+1];
        Arrays.fill(t,1);
        t[0]=0;
        int maxLength=1;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<i; j++){
                if(nums[i-1]>nums[j-1]){
                    t[i]=Math.max(t[i],t[j]+1);
                    maxLength=Math.max(maxLength,t[i]);
                }
            }
        }
        return maxLength;

    }
}
/**
 * This solution can be further optimised by
 * using binary search
 */

/**
 * Initialize an array sub which contains the first element of nums.
 *
 * Iterate through the input, starting from the second element. For each element num:
 *      a) If num is greater than any element in sub, then add num to sub.
 *      b) Otherwise, iterate through sub and find the first element that is greater than or equal to num. Replace that element with num.
 * Return the length of sub.
 */
 class LargestCommonIncreasingSubsequence2 {
    public static void main(String[] args) {
        int nums []= {10,9,2,5,3,7,101,18};
        int maxLength=findMaxLengthOfLargestCommonIncreasingSubsequence(nums);
        System.out.println("maxLength : "+maxLength);
    }

    public static int findMaxLengthOfLargestCommonIncreasingSubsequence(int[] nums) {
        ArrayList<Integer> sub= new ArrayList();
        sub.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            if(nums[i]>sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }else{
                int idx=bs(sub,nums[i]);
                sub.set(idx,nums[i]);
            }
        }
        return sub.size();
    }
    static int bs(ArrayList<Integer> sub,int num){
        int start = 0;
        int end =sub.size()-1;
        while(start<=end){
            int mid= start + (end-start)/2;

            if(sub.get(mid)==num){
                return mid;
            }else if(sub.get(mid)>num){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;

    }
}
// TC NLog(N)
// SC : N in worst case if array is sorted

