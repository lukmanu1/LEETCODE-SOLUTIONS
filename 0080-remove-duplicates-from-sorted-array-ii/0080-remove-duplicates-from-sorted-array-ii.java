class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 2, j = 1;
        for(i = 2; i<nums.length; i++){
            if(nums[j - 1] != nums[i]){
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }
}