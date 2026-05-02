class Solution {
    public int findNumberOfValidDigit(int num){
        int digit = 0, count = 0;
        while(num > 0){
            digit = num % 10;
            num /= 10;

            if( digit == 2 ||
                digit == 5 ||
                digit == 6 ||
                digit == 9
            ) count++;

            if( digit == 3 ||
                digit == 4 ||
                digit == 7
                ) return 0;
        }

        return count > 0 ? 1 : 0;
    }
    public int rotatedDigits(int n) {
        int sum = 0;
        int count = 0;
        for(int i = 2; i<=n; i++){
            sum += findNumberOfValidDigit(i);
        }

        return sum;
    }
}