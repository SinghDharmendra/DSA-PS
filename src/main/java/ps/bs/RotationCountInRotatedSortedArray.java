package ps.bs;

/**
 * This is same as finding index of min in rotated sorted array
 * FindIndexOfMinNumberInRotatedSortedArray
 */

public class RotationCountInRotatedSortedArray {
    public static void main (String[] args)
    {
        int arr[] = {15, 18, 2, 3, 6, 12};
        int n = arr.length;

        System.out.println(
                FindIndexOfMinNumberInRotatedSortedArray.findIndexOfMinElement(arr, 0, n-1));
    }
}
