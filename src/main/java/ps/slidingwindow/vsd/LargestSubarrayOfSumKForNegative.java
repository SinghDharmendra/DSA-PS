package ps.slidingwindow.vsd;

public class LargestSubarrayOfSumKForNegative {
    public static void main(String[] args) {
        int arr[] = {-5, 8, -14, 2, 4, 12};
        int sum=-5;
        int maxLen =findMaxLengthOfSubArray(arr,sum);
        System.out.println("findMaxLengthOfSubArray"+maxLen);
    }

    private static int findMaxLengthOfSubArray(int[] arr, int k) {
       int max = -1;
       int i=0, j=0;
       int sum=0;
       while(j<arr.length){
           sum+=arr[j];
           if(sum<k){

               j++;
           }else if(sum==k){
               max=Math.max(max,j-i+1);
               j++;
           }else{
               while(sum>k ){
                   sum-=arr[i];
                   i++;
               }
               j++;
           }
       }
       return  max;
    }
}
