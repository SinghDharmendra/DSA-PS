package ps.bs;

/** Nearly sorted
 * Element will be present at i or i-1 or i+1 from it's sorted location
 */
public class FindAnElementInNearlySortedArray {
    public static void main(String[] args) {
        int arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40;
        int index=search(arr,0,arr.length,key);
        System.out.println("index of Ele:"+index);
    }

    private static int search(int[] arr, int start, int end, int ele) {
        if(start>end)
            return -1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(arr[mid]==ele){
                return mid;
            }else if(mid-1>=start && arr[mid-1]==ele){
                return mid-1;
            }else if(mid+1<=end && arr[mid+1]==ele){
                return mid+1;
            }
            if(arr[mid]>ele){
                end=mid-2;
            }else {
               start=mid+2;
            }
        }
        return -1;
    }
}
