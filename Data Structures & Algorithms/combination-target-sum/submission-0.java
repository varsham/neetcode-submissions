class Solution {
    List<List<Integer>> res; // initialize a list of lists to return
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // two choices at each index for backtracking
        // 1: stay at the current index
        // 2: skip to the next index
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        backtrack(nums, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        // condition to exit
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }

        if (target < 0 || i >= nums.length) return; // went too far

        // otherwise, go through the conditions
        // stay at the current index
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        // skip the current index
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
}