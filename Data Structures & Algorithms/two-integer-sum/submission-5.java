class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hash map (two pass)
        // can achieve an even faster time complexity

        // create a hash mapto store the value and index of each element in the array
        HashMap<Integer, Integer> numHash = new HashMap<>();

        // populate the hashmap
        for (int i = 0; i < nums.length; i++) {
            numHash.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numHash.containsKey(complement) && numHash.get(complement) != i) {
                return new int[]{i, numHash.get(complement)};
            }
            numHash.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}
