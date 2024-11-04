import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int mid = prices.length / 2;
        int[] firstH = Arrays.copyOfRange(prices, 0, mid);
        int[] secondH = Arrays.copyOfRange(prices, mid, prices.length-1);

        int max = maxProfitII(prices);
        int leftProf = maxProfitII(firstH);
        int rightProf = maxProfitII(secondH);

        int maxII = leftProf + rightProf;
        if (max > maxII) {
            return max;
        }
        return maxII;
    }

    public int maxProfitII(int[] prices) {
        int min = Integer.MAX_VALUE;
        int diff = 0;
        int maxProf = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            }
            diff = prices[i] - min;

            if (min > maxProf) {
                maxProf = min;
            }
        }
        return maxProf;
    }
}
