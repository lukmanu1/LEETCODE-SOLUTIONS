class Solution {
    public int sumFourDivisors(int[] nums) {

        int ans = 0, sum = 0, count = 0;
        Boolean flag = false;
        
        for(int i = 0 ; i<nums.length; i++){

            sum = 0;
            count = 0;
            flag = false;

            for(int j = 1 ; j <= Math.sqrt(nums[i]); j++){
                
                if(nums[i] % j == 0){
                    if( j != nums[i] / j){

                        sum += j;
                        sum += nums[i] / j;
                        count += 2;

                    }else{

                        sum += j;
                        count++;

                    }

                    if(count == 4){
                        flag = true;
                    }else if(count >= 5){
                        flag = false;
                        break;
                    }

                }


            }

            if(flag) ans += sum;
        }

        return ans;
    }
}