class Solution {
    public int countOdds(int low, int high) {
        int a = low % 2 == 0 ? low + 1 : low;
        int an = high % 2 == 0 ? high - 1 : high;

        // System.out.print(a +" "+an+" ");

        int ans = (an - a) / 2;
        return ans + 1;
    }
}