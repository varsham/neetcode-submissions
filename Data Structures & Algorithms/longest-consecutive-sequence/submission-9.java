class Solution {
    public int longestConsecutive(int[] nums) {
        // create a hashset to store each number
        Set<Integer> set = new HashSet<>();

        // populate the hashset
        for (int num : nums) {
            set.add(num);
        }

        // loop through the nums array
        // if num - 1 doesn't exist in the set, then it's potentially a start to a sequence
        int maxStreak = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curStreak = 1;
                while (set.contains(num + curStreak)) {
                    curStreak++;
                }
                maxStreak = Math.max(curStreak, maxStreak);
            }
        }

        return maxStreak;
    }

}
