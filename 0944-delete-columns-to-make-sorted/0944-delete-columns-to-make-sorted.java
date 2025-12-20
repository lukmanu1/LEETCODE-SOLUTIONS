class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int count = 0;
        char prev = '0';

        for(int i = 0; i<m; i++){
            prev = strs[0].charAt(i);
            for(int j = 1; j<n; j++){
                if(prev > strs[j].charAt(i)){
                    count++;
                    break;
                }

                prev = strs[j].charAt(i);

            }
        }

        return count;
    }
}