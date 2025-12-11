class MinMax{
    int min;
    int max;

    MinMax(){
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
    }

    MinMax(int min, int max){
        this.min = min; 
        this.max = max;
    }
}
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, MinMax> xMap = new HashMap<>();
        HashMap<Integer, MinMax> yMap = new HashMap<>();

        int x = 0;
        int y = 0;

        MinMax temp = null;

        for(int arr[] : buildings){

            x = arr[0];
            y = arr[1];

            temp = xMap.computeIfAbsent(x, k -> new MinMax());
            temp.min = Math.min(y, temp.min);
            temp.max = Math.max(y, temp.max);

            temp = yMap.computeIfAbsent(y, k -> new MinMax());
            temp.min = Math.min(x, temp.min);
            temp.max = Math.max(x, temp.max);

        }

        int count = 0;

        for(int arr[] : buildings){
            x = arr[0];
            y = arr[1];

            temp = xMap.get(x);

            if(temp.min < y && temp.max > y){
                temp = yMap.get(y);
                if(temp.min < x && temp.max > x){
                    count++;
                }else continue;
            }else continue;
        }

        return count;
    }
}