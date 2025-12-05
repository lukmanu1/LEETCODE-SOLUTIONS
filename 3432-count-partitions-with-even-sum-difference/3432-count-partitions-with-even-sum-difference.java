class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int val : nums)sum += val;

        int leftSum = 0, rightSum = 0, count = 0;

        for(int val : nums){
            leftSum += val;
            rightSum = sum - leftSum;
            if((leftSum - rightSum) % 2 == 0 && rightSum != 0)count++;
        }

        return count;
    }
}