class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // create a result list
        int[] result = new int[n];
        result[0] = 1;

        // populate the result list with prefixes
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        // multiply by the suffixes
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}  
