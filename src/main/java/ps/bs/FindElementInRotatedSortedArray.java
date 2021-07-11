package ps.bs;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * This is just a modification of binary search in two steps
 * a) find which half is sorted
 * b) make a decision of moving start and end based on fitting of this element in sorted half
 *
 */

public class FindElementInRotatedSortedArray {
    public static void main(String[] args) {
        int []nums = {4,5,6,7,0,1,2};
        int target = 0;
        FindElementInRotatedSortedArray finder = new FindElementInRotatedSortedArray();
        int idx=finder.search(nums,target);
        System.out.println("Found at :"+idx);

    }

    public int search(int[] nums, int target) {
        int idx = bs(nums, target);
        return idx;

    }

    int bs(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (nums[mid] >= target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else if (nums[mid] <= nums[end]) {
                if (nums[mid] <= target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;

    }
}
