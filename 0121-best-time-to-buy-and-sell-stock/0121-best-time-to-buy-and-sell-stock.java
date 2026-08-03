class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =Integer.MIN_VALUE;

        int minStock = prices[0];

        for(int stock : prices){
            int profit = stock - minStock;
            maxProfit = Math.max(profit , maxProfit);
            minStock = Math.min(stock,minStock);
        }
        return maxProfit;
    }
}