class Solution {
    public int search(int[] nums, int target)  {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }   

        int pivot = l;
        int low = 0, high = nums.length - 1, mid = 0;
        if (target >= nums[pivot] && target <= nums[high]) low = pivot;
        else high = pivot;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target > nums[mid]) low = mid + 1;
            else if (target < nums[mid]) high = mid - 1;
            else return mid;
        }
        
        return -1;
    }
}
