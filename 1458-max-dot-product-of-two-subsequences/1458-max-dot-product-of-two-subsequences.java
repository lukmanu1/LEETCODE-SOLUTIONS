class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];

        int max = Integer.MIN_VALUE;

        // for(int i=0; i<nums1.length; i++){
        //     for(int j = 0; j<nums2.length; j++){
        //         product[i][j] = nums1[i] * nums2[j];
        //         max = Math.max(max, product[i][j]);
        //     }
        // }

        // for(int i = 1; i<nums1.length; i++){
        //     for(int j = 1; j<nums2.length; j++){
                
        //         product[i][j] = Math.max(
        //             product[i-1][j], 
        //             Math.max(
        //                 product[i][j], 
        //                 Math.max(
        //                     product[i - 1][j - 1],
        //                     Math.max(
        //                         product[i][j - 1],
        //                         product[i][j] + product[i - 1][j - 1]
        //                     )
        //                 )
        //             )
        //         );

        //         max = Math.max(max, product[i][j]);
        //     }
        // }

        dp[0][0] = nums1[0] * nums2[0];

        for(int i = 1; i<nums1.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], nums1[i] * nums2[0]);
        }

        for(int i = 1; i<nums2.length; i++){
            dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
        }


        for(int i = 1; i<nums1.length; i++){
            for(int j = 1; j<nums2.length; j++){
                int pick = Math.max(
                    nums1[i] * nums2[j] + dp[i - 1][j -1],
                    nums1[i] * nums2[j]
                );

                int notPick = Math.max(
                    dp[i-1][j],
                    dp[i][j- 1]
                );

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[nums1.length-1][nums2.length - 1];
    }
}