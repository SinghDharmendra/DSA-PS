package stack;

/**
 * Rain water problem can be reduced to
 * water contained min of leftMax and rightMax for that pole where we are calculating water
 */

public class RainWaterTrappingProblem {
    public static void main(String []args)
    {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;
        System.out.print(maxWater(arr, n));
    }

    private static int maxWater(int[] arr, int n) {
        int l[]=new int[n];
        int r[]=new int[n];
        l[0]=arr[0];
        r[n-1]=arr[n-1];


        for(int i=1; i<n; i++){
            l[i]=Math.max(l[i-1],arr[i]);
        }
        for(int i=n-2; i>=0; i--){
            r[i]=Math.max(r[i+1],arr[i]);
        }
        int water=0;
        for(int i=0; i<n; i++){
           water+=(Math.min(l[i],r[i])-arr[i]);
        }

        return water;
    }
}
