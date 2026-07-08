class Solution {
    public int[] productExceptSelf(int[] nums) {
        // check the number of zeroes
        int numZeroes = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) numZeroes++;
            else prod *= nums[i];
        }

        if (numZeroes > 1) return new int[nums.length];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (numZeroes > 0) {
                if (nums[i] == 0) res[i] = prod;
                else res[i] = 0;
            } else {
                res[i] = prod / nums[i];
            }
        } 
        
        return res;
    }
}  
