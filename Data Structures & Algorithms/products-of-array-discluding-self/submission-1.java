class Solution {
    public int[] productExceptSelf(int[] nums) {
        // variable to store the length of nums
        int n = nums.length;

        // prefix and suffix
        // prefix product: product of all elements to the left of i
        // suffix product: product of all elements to the right of i
        // result for each index is prefix[i] * suffix[i]
        // since the prefix/suffix doesn't include the current element

        int[] pref = new int[n];
        int[] suf = new int[n];
        int[] res = new int[n];

        // initialize the prefix array
        pref[0] = 1; // nothing to the left of index 0
        suf[n - 1] = 1; // nothing to the right of the last index

        // build the prefix product array
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i - 1]; // don't include the current index
        }

        // build the suffix product array
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        // loop through the array, multiplying the prefix and suffix array values
        for (int i = 0; i < res.length; i++) {
            res[i] = pref[i] * suf[i];
        }
        
        return res;
    }
}  
