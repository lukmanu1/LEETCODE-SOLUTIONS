class Solution {
    public int[] maxValue(int[] nums) {

        int prefixMax[] = new int[nums.length];
        prefixMax[0] = nums[0];

        int suffixMin[] = new int[nums.length];
        suffixMin[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i<nums.length; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
            suffixMin[nums.length - 1 - i] = Math.min(suffixMin[nums.length - i], nums[nums.length - 1 - i]);
        }

        int ans[] = new int[nums.length];
        ans[nums.length - 1] = prefixMax[nums.length - 1];

        for(int i = nums.length - 2; i>=0; i--){
            if(prefixMax[i] <= suffixMin[i + 1]) ans[i] = prefixMax[i];
            else ans[i] = ans[i + 1];
        }

        return ans;


    }
}