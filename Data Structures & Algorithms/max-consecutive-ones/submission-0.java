class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxStreak = Integer.MIN_VALUE;
        int curStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) curStreak++;
            else {
                maxStreak = Math.max(curStreak, maxStreak);
                curStreak = 0;
            }
        }

        return Math.max(curStreak, maxStreak);
    }
}