package ps.bs;

public class FindIndexOfMinNumberInRotatedSortedArray {
    public static void main(String[] args) {
       int arr[] = {15, 18, 2, 3, 6, 12};
       int index= findIndexOfMinElement(arr, 0,arr.length-1 );
        System.out.println("Index:"+index);
    }

    public static int findIndexOfMinElement(int[] arr, int start, int end) {
        int N=arr.length;
        while(end>=start){
            int mid = start +(end-start)/2;
            int next = (mid+1)%N;
            int prev = (mid+N-1)%N;
            if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
                return mid;
            }
            if(arr[mid]<=arr[end]){
                end=mid-1;
            }else if(arr[mid]>=arr[start]){
                start=mid+1;
            }
        }

        return -1;
    }
}
