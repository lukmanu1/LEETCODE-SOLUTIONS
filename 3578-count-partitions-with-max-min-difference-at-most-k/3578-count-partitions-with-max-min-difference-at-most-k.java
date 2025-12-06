import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        long[] dp = new long[n + 1];      // dp[i] = ways for prefix of length i
        long[] pref = new long[n + 1];    // pref[i] = sum_{t=0..i} dp[t]

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> dqMin = new ArrayDeque<>();
        Deque<Integer> dqMax = new ArrayDeque<>();

        int L = 0; // left pointer of window

        for (int r = 0; r < n; r++) {

            // Maintain dqMin (increasing by value)
            while (!dqMin.isEmpty() && nums[dqMin.peekLast()] >= nums[r]) {
                dqMin.pollLast();
            }
            dqMin.addLast(r);

            // Maintain dqMax (decreasing by value)
            while (!dqMax.isEmpty() && nums[dqMax.peekLast()] <= nums[r]) {
                dqMax.pollLast();
            }
            dqMax.addLast(r);

            // Shrink from left until window [L..r] is valid
            while (!dqMin.isEmpty() && !dqMax.isEmpty() &&
                   nums[dqMax.peekFirst()] - nums[dqMin.peekFirst()] > k) {
                if (dqMin.peekFirst() == L) dqMin.pollFirst();
                if (dqMax.peekFirst() == L) dqMax.pollFirst();
                L++;
            }

            // Now all segments [i..r] with i in [L..r] are valid.
            // dp[r+1] = sum_{i=L..r} dp[i] = pref[r] - pref[L-1]
            long ways = pref[r] - (L == 0 ? 0 : pref[L - 1]);
            ways %= MOD;
            if (ways < 0) ways += MOD;

            dp[r + 1] = ways;
            pref[r + 1] = (pref[r] + dp[r + 1]) % MOD;
        }

        return (int) dp[n];
    }
}