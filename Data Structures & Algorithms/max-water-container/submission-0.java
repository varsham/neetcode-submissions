class Solution {
    public int maxArea(int[] heights) {
        // two pointers
        int l = 0;
        int r = heights.length - 1;

        int result = 0;

        while (l < r) {
            // compute the current area
            int curArea = Math.min(heights[l], heights[r]) * (r - l);
            result = Math.max(curArea, result);

            if (heights[l] > heights[r]) r--;
            else l++;
        }

        return result;
    }
}
