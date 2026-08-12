class Solution {
    public int findCount(int prices[], int index, int bought, int count, int dp[][][]){
        if(index == prices.length || (count == 2 && bought == 0))return 0;

        if(dp[index][bought][count] != -1)return dp[index][bought][count];

        int x = 0, y = 0;
        if(bought == 0){
            x = findCount(prices, index + 1, 1, count + 1, dp) - prices[index];
            y = findCount(prices, index + 1, 0, count, dp);
        }else if(bought == 1){
            x = findCount(prices, index + 1, 0, count, dp) + prices[index];
            y = findCount(prices, index + 1, 1, count, dp);
        }

        return dp[index][bought][count] = Math.max(x , y);
    }
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];

        for(int i = 0; i<prices.length; i++){
            for(int j = 0; j<2; j++)Arrays.fill(dp[i][j], -1);
        }
        return findCount(prices, 0, 0, 0, dp);
    }
}