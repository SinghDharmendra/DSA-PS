package ps.slidingwindow.fsd;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int N = 4, K = 2;
        int []arr = {100, 200, 300, 400};
        int sum=maxSumSubArray(arr,K);
        System.out.println("MaxSumSubArrayOfSizeK"+sum);


    }

    private static int maxSumSubArray(int[] arr, int k) {
        int i=0, j=0;
        int n= arr.length;
        int sum=0;
        int max=Integer.MIN_VALUE;

        while (j<n){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                max=Math.max(max,sum);
                sum-=arr[i];
                j++;
                i++;
            }
        }
        return max;
    }
}
