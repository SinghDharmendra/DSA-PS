package ps.bs;

public class FindAnElementInInfiniteSortedArray {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};
        int index = bsInInfiniteArray(arr, 11);
        System.out.println("Found at :"+index);

    }

    private static int bsInInfiniteArray(int[] arr, int ele) {
        int start=0, end=1;
        while(arr[end]<ele){
            start=end;
            end=end*2;
        }
        // Problem has been reduce to bs now once boundaries known
        return bs(arr,start,end,ele);
    }

    private static int bs(int[] arr, int start, int end, int ele) {
        if(end<start)
            return -1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==ele)
                return mid;
            else if(arr[mid]>ele){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
