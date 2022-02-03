//? Problem 121: Best Time to Buy and Sell Stock


class BestBuyAndSellStock_121{
    public static int maxProfit(int[] prices) {
        // Handles Edge Cases for Arrays <= Size of 2
        if (prices.length <= 2) {
            if (prices.length < 2 || prices[0] > prices[1])
                return 0;
            return prices[1] - prices[0];
        }

        int buy = 0, sell = buy + 1, maxValue = prices[sell] - prices[buy];
        for (; sell < prices.length; sell++) {
            if (prices[sell] - prices[buy] <= 0)
                buy = sell;
            maxValue = Math.max(maxValue, prices[sell] - prices[buy]);
        }
        if (maxValue <= 0)
            return 0;
        return maxValue;
    }
    public static void main(String[] args){
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        for(int i = 0; i < prices.length; i++){
            System.out.println("Day " + (i + 1) + " Price: " + prices[i]);
        }
        System.out.println("The max amount of profit possible on these " + prices.length + " days is: " + maxProfit(prices));
    }
}