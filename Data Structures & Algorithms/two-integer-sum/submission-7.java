class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hash map, two pass
        // create a hash map to store the numbers
        Map<Integer, Integer> set = new HashMap<>();

        // populate the hashmap
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        } 

        // loop through, checking if a number's complement exists
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(target - nums[i]) && set.get(target - nums[i]) != i)
                return new int[]{i, set.get(target - nums[i])};
        }

        return new int[0];
    }
}
