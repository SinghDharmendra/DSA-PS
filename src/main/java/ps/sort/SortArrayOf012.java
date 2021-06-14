package ps.sort;

import java.sql.SQLOutput;
import java.util.Arrays;

public class SortArrayOf012 {
    public static void main(String[] args)
    {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        System.out.println(Arrays.toString(arr));
    }


    private static void sort012(int[] arr, int n) {
        int low=0,mid=0,high=n-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }else  if(arr[mid]==1){
                mid++;

            }else{
                swap(arr,mid,high);
                high--;
            }



        }

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
