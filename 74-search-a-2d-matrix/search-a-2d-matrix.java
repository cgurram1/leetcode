class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows-1;
        while(top <= bottom){
            int midRow = (top + bottom)/2;
            if(target < matrix[midRow][0]){
                bottom = midRow - 1;
            }
            else if(target > matrix[midRow][cols-1]){
                top = midRow + 1;
            }
            else{
                int left = 0;
                int right = cols-1;
                while(left <= right){
                    int mid = (left + right)/2;
                    if(target < matrix[midRow][mid]){
                        right = mid - 1; 
                    }
                    else if(target > matrix[midRow][mid]){
                        left = mid + 1;
                    }
                    else{
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}