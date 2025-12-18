class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long prefix[] = new long[n];
        long statePrefix[] = new long[n];

        long sum1 = 0;
        long sum2 = 0;

        for(int i = 0; i<n; i++){

            sum1 += prices[i];
            sum2 += prices[i] * strategy[i];

            prefix[i] = sum1;
            statePrefix[i] = sum2;

        }

        long total = 0, max = statePrefix[n-1], intermediate = 0;
        long front = 0, back = 0;

        for(int i = k -1, j = 0, mid = k/2; i<n; i++, j++){
            front = j == 0 ? 0 : statePrefix[j-1];
            back = i == n -1 ? 0 : statePrefix[n-1] - statePrefix[i];
            intermediate = prefix[i] - prefix[j + mid - 1];

            max = Math.max(max, (front + back + intermediate));
        }

        return max;

        
    }
}