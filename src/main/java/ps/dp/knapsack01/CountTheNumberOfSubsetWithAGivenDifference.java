package ps.dp.knapsack01;

import java.util.Arrays;

public class CountTheNumberOfSubsetWithAGivenDifference {
    public static void main(String[] args) {
        int [] arr ={1,1,2,3};
        int diff=1;
        int sum= Arrays.stream(arr).sum();
        if((sum+diff)%2==1)
            System.out.println(0);
        int s1=(sum+diff)/2;
        System.out.println( CountOfSubsetsWithSumEqualToX.findCnt(arr,s1,arr.length));

    }
}
