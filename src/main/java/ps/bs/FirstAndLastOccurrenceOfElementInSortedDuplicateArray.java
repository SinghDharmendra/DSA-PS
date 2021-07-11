package ps.bs;

public class FirstAndLastOccurrenceOfElementInSortedDuplicateArray {
    public static void main(String[] args) {
        int [] nums ={1, 3, 5, 5, 5, 5 ,67, 123, 125};
        int x=5;
        int idx = findFirstOccurrence(nums,x);
        System.out.println("First occurrence of x is at: "+idx);
        int idxLast =findLastOccurrence(nums,x);
        System.out.println("Last occurrence of x is at: "+idxLast);
    }

    private static int findFirstOccurrence(int[] nums, int x) {
        int start =0, end=nums.length-1;
        int res =-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==x){
                res=mid;
                end=mid-1;
            }else if(nums[mid]>x){
                end=mid-1;
            }else {
                start=mid+1;
            }

        }
        return res;

    }
    private static int findLastOccurrence(int[] nums, int x) {
        int start =0, end=nums.length-1;
        int res =-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==x){
                res=mid;
                start=mid+1;
            }else if(nums[mid]>x){
                end=mid-1;
            }else {
                start=mid+1;
            }

        }
        return res;

    }

}
