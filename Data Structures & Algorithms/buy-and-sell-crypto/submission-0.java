class Solution {
    public int maxProfit(int[] prices) {
        // two pointers
        int i = 0, j = 1;
        int max = 0;

        while (i < j && j < prices.length && i < prices.length) {
            if (prices[j] > prices[i]) {
                max = Math.max(prices[j] - prices[i], max);
            } else {
                // found a cheaper buy price
                i = j;
                j = i;
            }
            j++;
        }

        return max;
    }
}
