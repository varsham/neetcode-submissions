class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hash map to collect the complements
        // key: number
        // value: index
        Map<Integer, Integer> set = new HashMap<>();

        // loop through the array and check if the complement exists
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (set.containsKey(complement)) {
                return new int[] {set.get(complement), i};
            }

            // otherwise, add the new number
            set.put(nums[i], i);
        }

        return new int[0];
    }
}