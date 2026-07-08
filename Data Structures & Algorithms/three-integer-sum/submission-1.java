class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // required for two pointer solutions

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // will result in a bad solution because the array is sorted
            // any number will be higher

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }
}
