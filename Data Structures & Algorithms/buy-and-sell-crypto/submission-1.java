class Solution {
    public int maxProfit(int[] prices) {
        // dyprog
        // keep track of two things: lowest price so far (best day to buy)
        // best profit so far: selling today - lowest buy price seen earlier

        // then, update the maximum profit
        // the lowest price if we find a cheaper one
        int minBuy = prices[0];
        int maxP = 0;

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            if (sell < minBuy) minBuy = sell;
        }

        return maxP;
    }
}
