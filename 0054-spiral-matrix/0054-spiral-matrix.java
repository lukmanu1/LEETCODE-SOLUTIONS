class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1, size = matrix[0].length * matrix.length;

        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i<= colEnd && list.size() < size; i++){
                System.out.println(matrix[rowStart][i]);
                list.add(matrix[rowStart][i]);
            }

            for(int i = rowStart + 1; i<= rowEnd && list.size() < size; i++){
                System.out.println(matrix[i][colEnd]);
                list.add(matrix[i][colEnd]);
            }
            
            for(int i = colEnd - 1; i>= colStart && list.size() < size; i--){
                System.out.println(matrix[rowEnd][i]);
                list.add(matrix[rowEnd][i]);
            }
            
            for(int i = rowEnd - 1; i>= rowStart + 1 && list.size() < size; i--){
                System.out.println(matrix[i][colStart]);
                list.add(matrix[i][colStart]);
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }

        return list;
    }
}