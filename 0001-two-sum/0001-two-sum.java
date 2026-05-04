class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<nums.length; i++){
            int index = map.getOrDefault(target - nums[i], -1);
            if(index != -1){
                return new int[]{index, i};
            }
            map.put(nums[i], i);
       }
       return new int[2];
    }
}