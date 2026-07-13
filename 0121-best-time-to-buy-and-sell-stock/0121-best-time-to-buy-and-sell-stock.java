class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(min > price) min = price;
            else{
                maxProfit = maxProfit < price - min ? price - min : maxProfit;
            }
        }

        return maxProfit;
    }
}