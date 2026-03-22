class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0, sum = 0;

        map.put(0, 1);

        int i = 0;
        while(i < nums.length){
            sum += nums[i];
            int extra = sum - k;

            
            count += map.getOrDefault(extra, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
            i++;
        }

        return count;
    }
}