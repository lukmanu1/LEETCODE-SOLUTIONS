class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            if(map.getOrDefault(val, 0) == 1)return val;
            map.put(val, 1);
        }
        return 0;
    }
}