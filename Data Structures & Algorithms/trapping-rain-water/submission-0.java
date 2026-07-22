class Solution {
    public int trap(int[] height) {
        // question: can I just write a single-pass solution?
        if (height == null || height.length == 0) return 0;
        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        int curMax = height[0];

        for (int i = 1; i < prefix.length; i++) {
            curMax = Math.max(curMax, height[i]);
            prefix[i] = curMax;
        }

        int sum = 0;
        curMax = height[height.length - 1];
        for (int j = height.length - 1; j >= 0; j--) {
            curMax = Math.max(curMax, height[j]);
            sum += Math.min(curMax, prefix[j]) - height[j]; 
        }

        return sum;
    }
}
