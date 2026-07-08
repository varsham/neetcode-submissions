class Solution {
    public int[] productExceptSelf(int[] nums) {
        // initialize a result array with all values set to 1
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        int prefix = 1;

        // first pass, left to right
        // set res[i] to the prefix (product of all elements to the right)
        for (int i = 1; i < nums.length; i++) {
            result[i] = prefix * nums[i - 1];
            prefix *= nums[i - 1];
        }

        int postfix = 1;
        // second pass, right to left
        // multiply res[i] by the postfix
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= nums[i + 1] * postfix;
            postfix *= nums[i + 1];
        }

        return result;
    }
}  
