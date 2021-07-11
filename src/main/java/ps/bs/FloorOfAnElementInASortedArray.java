package ps.bs;

public class FloorOfAnElementInASortedArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
        int len = arr.length;
        int ele=6;
        int floorValue=findFloorElement(arr,0,len-1,ele);
        System.out.println("floorValue:"+floorValue);
    }

    private static int findFloorElement(int[] arr, int low, int high, int ele) {
        if(low>high)
            return -1;
        int res=-1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if(arr[mid]==ele){
                return arr[mid];
            }
            if(arr[mid] <ele ){
                res=arr[mid];
                low=mid+1;
            }else{
                high=mid-1;

            }
        }
        return res;
    }
}
