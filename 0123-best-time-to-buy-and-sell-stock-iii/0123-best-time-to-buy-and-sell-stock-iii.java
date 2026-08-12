class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][3];
        int curr[][] = new int[2][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[1][2] = 0;
        for(int i = prices.length - 1; i>=0; i--){
            for(int bought = 0; bought<2; bought++){
                for(int count = 0; count < 3; count++){
                    if(bought == 0){
                        int notBuy = dp[0][count];
                        int buy = 0;

                        if(count < 2){
                            buy = dp[1][count + 1] - prices[i];
                        }

                        curr[bought][count] = Math.max(buy, notBuy);
                    }else{

                        int notSell = dp[1][count];

                        int sell = dp[0][count] + prices[i];

                        curr[bought][count] = Math.max(notSell, sell);
                    }
                }
            }

            int temp[][] = dp;
            dp = curr;
            curr = temp;
        }


        return dp[0][0];
    }
}