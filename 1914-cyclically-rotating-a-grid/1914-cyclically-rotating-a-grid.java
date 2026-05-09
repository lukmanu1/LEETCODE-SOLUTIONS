class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rowStart = 0, columnStart = 0, rowEnd = grid.length - 1, columnEnd = grid[0].length - 1;
        int parimeter = 0;
        int r = 0, z = 0, temp = 0;

        while(rowStart < rowEnd && columnStart < columnEnd){
            parimeter = 2 * (rowEnd - rowStart + 1) + 2 * (columnEnd - columnStart + 1) - 4; 
            r = k % parimeter;
            z = 0;

            while(z < r){
                temp = grid[rowStart][columnStart];

                for(int i = columnStart; i<=columnEnd; i++){
                    if(i == columnEnd) grid[rowStart][i] = grid[rowStart + 1][i];
                    else grid[rowStart][i] = grid[rowStart][i + 1];
                }
                
                for(int i = rowStart + 1; i<=rowEnd; i++){
                    if(i == rowEnd) grid[i][columnEnd] = grid[i][columnEnd - 1];
                    else grid[i][columnEnd] = grid[i + 1][columnEnd];
                }
                
                for(int i = columnEnd - 1; i>=columnStart; i--){
                    if(i == columnStart) grid[rowEnd][i] = grid[rowEnd - 1][i];
                    else grid[rowEnd][i] = grid[rowEnd][i - 1];
                }
                for(int i = rowEnd - 1; i >= rowStart + 2; i--){
                    grid[i][columnStart] = grid[i - 1][columnStart];
                }

                grid[rowStart + 1][columnStart] = temp;
                z++;
            }

            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
        }

        return grid;
    }
}