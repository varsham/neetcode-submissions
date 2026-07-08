class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums.length;

        // sort the array first
        Arrays.sort(nums);
        int streakLength = 1;
        int maxStreak = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            else if (nums[i] - nums[i - 1] == 1) streakLength++;
            else streakLength = 1;

            maxStreak = Math.max(streakLength, maxStreak);
        }

        return Math.max(streakLength, maxStreak);
    }

}
