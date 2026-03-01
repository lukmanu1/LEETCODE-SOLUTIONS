class Solution {
    public void swap(int nums[], int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public void sortColors(int[] nums) {
        int zero = 0;
        int i = 0;
        int two = nums.length - 1;

        while(i <= two){
            if(nums[i] == 0){
                swap(nums, zero, i);
                zero++;
                i++;
                
            }else if(nums[i] == 2)
            {
                swap(nums, two, i);
                two--;
                
            }else i++;
            
        }
    }
}