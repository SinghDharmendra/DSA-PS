package ps.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 * <p>
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */

public class FindDuplicatesInArraySpecialUseCase {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < len; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                result.add(idx + 1);
            nums[idx] = -nums[idx];
        }
        return result;

    }
}
