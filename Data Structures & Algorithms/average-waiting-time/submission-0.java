class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sumWaits = customers[0][1], curTime = customers[0][0] + customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            if (curTime < customers[i][0]) curTime = customers[i][0];
            curTime += customers[i][1];
            sumWaits += curTime - customers[i][0];

            System.out.println(curTime + " " + sumWaits);
        }
        
        return sumWaits / customers.length;
    }
}  