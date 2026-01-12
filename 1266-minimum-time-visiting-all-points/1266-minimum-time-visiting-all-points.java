class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, distance = 0;
        x1 = points[0][0];
        y1 = points[0][1];

        for(int i = 1; i<points.length; i++){
            x2 = points[i][0];
            y2 = points[i][1];

            distance += Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
            x1 = x2;
            y1 = y2;
        }

        return distance;
    }
}