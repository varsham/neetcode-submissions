

class Solution {
    public boolean hasDuplicate(int[] nums) {
        // hashset
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }
        return !(seen.size() == nums.length);
    }
}