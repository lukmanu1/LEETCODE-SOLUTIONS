class Solution {
    public int rotatedDigits(int n) {
        int dp[] = new int[n + 2];

        int count = 0, a = 0, b = 0;

        for(int i = 0; i<=n; i++){
            if( i == 0 ||
                i == 1 ||
                i == 8 )
            {
                dp[i] = 1;
                continue;
            }

            if(
                i == 2 || 
                i == 5 ||
                i == 6 ||
                i == 9 
            ){
                dp[i] = 2;
                count++;
                continue;
            }

            if(
                i == 3 ||
                i == 4 ||
                i == 7
            ){
                dp[i] = 0;
                continue;
            }

            a = i / 10;
            b = i % 10;

            if(dp[a] == 1 && dp[b] == 1)dp[i] = 1;
            else if(dp[a] >= 1 && dp[b] >= 1){
                dp[i] = 2;
                count++;
            }
            else dp[i] = 0;


        }

        return count;
    }
}