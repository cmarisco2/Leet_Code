//? Problem 121: Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


//? Examples:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

//? Solution Notes:
//* 1) Two Pointer Problem.
//* 2) Visualize Price v. Days Line Graph.
    //* Once (Sell - Buy) is negative, move ptrs up (found new min to start from, looking for highest max while its the min)
    //* Otherwise - Keep track of maxValue (Sell - Buy) until end of array or forced to move ptrs up



//* TC - O(N), SC - O(1)
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