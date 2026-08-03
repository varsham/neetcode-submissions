class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0, r = nums.length - 1, numVals = 0;
        for (int n : nums) {
            if (n == val) numVals++;
        }

        while (k < r && k < nums.length - numVals) {
            if (nums[r] == val) {
                r--;
                continue;
            }

            if (nums[k] == val) {
                nums[k] = nums[r];
                r--;
            }

            k++;
        }

        return nums.length - numVals;
    }
}