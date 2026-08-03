class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sumWaits = 0, curTime = 0;

        for (int i = 0; i < customers.length; i++) {
            curTime = Math.max(customers[i][0], curTime) + customers[i][1];
            sumWaits += curTime - customers[i][0];
        }

        return sumWaits / customers.length;
    }
}  