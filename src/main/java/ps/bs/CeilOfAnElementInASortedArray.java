package ps.bs;

public class CeilOfAnElementInASortedArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int len = arr.length;
        int ele=5;
        int floorValue= findCeilElement(arr,0,len-1,ele);
        System.out.println("CeilValue:"+floorValue);
    }

    private static int findCeilElement(int[] arr, int low, int high, int ele) {
        if(low>high)
            return -1;
        int res=-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid]==ele){
                return arr[mid];
            }
            if(arr[mid] <ele ){

                low=mid+1;
            }else{
                res=arr[mid];
                high=mid-1;

            }
        }
        return res;
    }
}
