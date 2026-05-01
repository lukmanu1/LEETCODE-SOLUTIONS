class Solution {
    public int maxRotateFunction(int[] nums) {
        int functPrev = 0, totalSum = 0;
        for(int i = 0; i<nums.length; i++){
            functPrev += i * nums[i];
            totalSum += nums[i];
        }

        int max = functPrev, functCurrent = 0;
        for(int i = 0; i<nums.length - 1; i++){
            functCurrent = totalSum + functPrev - nums.length * (nums[nums.length - 1 - i]);
            max = Math.max(max, functCurrent);
            functPrev = functCurrent;
        }

        return max;
    }
}