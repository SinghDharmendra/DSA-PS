package ps.bs;  

public class MinimumDifferenceElementInASortedArray {


    public static void main(String[] args) {
        int ar[]={1,3,8,10,15},ele =12;
        int minDiffNumber=bs(ar,0,ar.length-1,ele);
        System.out.println("Min diff acn be found at :"+minDiffNumber);

    }

    private static int bs(int[] ar, int start, int end, int ele) {
        while (start<=end){
            int mid= start + (end-start)/2;
            if(ar[mid]==ele)
                return ar[mid];
            else if(ar[mid]>ele){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return ((Math.abs(ar[end]-ele))>Math.abs(ar[start]-ele))?ar[start]:ar[end];
    }
}
