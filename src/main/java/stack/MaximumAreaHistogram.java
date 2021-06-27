package stack;

import stack.basic.NSL;
import stack.basic.NSR;

/**
 * Find the largest rectangular area possible in a given histogram
 */

public class MaximumAreaHistogram {
    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }

    public static int getMaxArea(int[] hist, int n) {
        int[] left = NSL.nextSmallerElementFromLeft(hist, n, -1);
        int right[] = NSR.nextSmallerElementFromRight(hist, n, n);
        int width[] = new int[n];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
            int area = width[i] * hist[i];
            maxArea = Math.max(area, maxArea);

        }
        return maxArea;
    }
}
