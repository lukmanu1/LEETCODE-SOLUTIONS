class Solution {
    public int findMaxDistribution(int stone[], int low, int high, int dp[][]){
        if(low == high){
            int val = 0;
            if(low == 0)val = stone[low];
            else val = stone[low] - stone[low - 1];
            return 0;
        }

        if(dp[low][high] != -1)return dp[low][high];

        int tempLow = -1, tempHigh = -1, leftSum = 0, rightSum = 0, max = 0;

        for(int i = low; i< high; i++){
            leftSum = low == 0 ? stone[i] : stone[i] - stone[low - 1];
            rightSum = i == high ? stone[high] - stone[high - 1] : stone[high] - stone[i];

            if(leftSum == rightSum){
                max = Math.max(
                    max,
                    Math.max(
                        findMaxDistribution(stone, low, i, dp),
                        findMaxDistribution(stone, i + 1, high, dp)
                    ) + leftSum
                );
            }else if(leftSum > rightSum){
                tempLow = i + 1;
                tempHigh = high;

                max = Math.max(
                    max,
                    findMaxDistribution(stone, tempLow, tempHigh, dp) + rightSum
                );
            }else{
                tempLow = low;
                tempHigh = i;
                max = Math.max(
                    max,
                    findMaxDistribution(stone, tempLow, tempHigh, dp) + leftSum
                );
            }

        }

        return dp[low][high] = max;
    }
    public int stoneGameV(int[] stoneValue) {
        for(int i = 1; i<stoneValue.length; i++)stoneValue[i] += stoneValue[i - 1];

        int dp[][] = new int[stoneValue.length][stoneValue.length];

        for(int i = 0; i<stoneValue.length; i++)Arrays.fill(dp[i], -1);

        return findMaxDistribution(stoneValue, 0, stoneValue.length - 1, dp);
    }
}