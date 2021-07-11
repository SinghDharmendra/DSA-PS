package ps.bs;

class FindPeakElement {
    public static void main(String[] args) {
        int [] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));

    }
    public static int findPeakElement(int[] nums) {
        int start=0,end = nums.length-1;
        int len = nums.length;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid>0 && mid<len-1){
                if(nums[mid]>=nums[mid-1] && nums[mid]>= nums[mid+1]){
                    return mid;
                }else if(nums[mid] < nums[mid-1]){
                    end=mid-1;

                }else{
                    start=mid+1;
                }
            }else if(mid==0){
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }else{
                    return mid+1;
                }
            }else if(mid==len-1){
                if(nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    return mid-1;
                }
            }
        }
        return -1;
    }
}