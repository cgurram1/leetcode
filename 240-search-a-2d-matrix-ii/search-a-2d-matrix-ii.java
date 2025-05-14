class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        for(int i = 0;i<matrix.length;i++){
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1]){
                System.out.println(i);
                int left = 0;
                int right = matrix[i].length - 1;
                while(left <= right){
                    int inMid = (left + right)/2;
                    if(target == matrix[i][inMid]){
                        return true;
                    }
                    if(target > matrix[i][inMid]){
                        left = inMid + 1;
                    }
                    else{
                        right = inMid - 1;
                    }
                }
            }
        }
        return false; 
    }
}