class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=nums.length - 2; i>=0; i--){
            int val = 0;
            for(int j = i + 1; j<nums.length; j++){
                if(nums[i] < nums[j]){
                    val = Math.max(val, dp[j]);
                }
            }

            dp[i] += val;

            max = max < dp[i] ? dp[i] : max;
        }

        return max;
    }
}