class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r = 1, curLen = 1;
        while (l < r && r < nums.length) {
            if (nums[l] == nums[r] && curLen <= k) return true;
            if (Math.abs(l - r) > k) {
                l++;
                r = l;
            }
            r++;
            curLen = Math.abs(l - r);
        }
        return false;
    }
}