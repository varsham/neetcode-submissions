class Solution {
    List<List<Integer>> res; // initialize a list of lists to return
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // utilize sorting and easy stopping
        // sort the numbers so that once a number makes the sum exceed the target, all numbers will also exceed the target
        Arrays.sort(nums);

        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, target, 0, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, int runningSum, List<Integer> cur, int i) {
        if (runningSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (runningSum + nums[j] > target) return;

            cur.add(nums[j]);
            backtrack(nums, target, runningSum + nums[j], cur, j);
            cur.remove(cur.size() - 1);
        }
    }
}