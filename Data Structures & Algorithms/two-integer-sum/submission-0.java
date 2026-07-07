class Solution {
    public int[] twoSum(int[] nums, int target) {
        // sorting
        // use two points to find two numbers that sum up to the target
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // .comparingInt tells to compare based on the first index
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // initialize two pointers
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i][0] + arr[j][0] == target) {
                return new int[]{Math.min(arr[i][1], arr[j][1]), Math.max(arr[i][1], arr[j][1])};
            } else if (arr[i][0] + arr[j][0] < target) {
                // increment the lower pointer
                i++;
            } else {
                j--;
            }
        }

        return new int[0];
    }
}
