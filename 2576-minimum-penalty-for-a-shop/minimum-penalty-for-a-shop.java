/**

NNNNYYYYYYYYYYYYYYY
 
     c
  YYNY
-10123
[[0,0],[1,0],[]]
[]
At every index I need no of Y's N's before and after
 */

class Solution {
    public int bestClosingTime(String customers) {
        int ys = 0;
        int ns = 0;
        int [][] left = new int[customers.length()+1][2];
        int [][] right = new int[customers.length()+1][2];
        for(int i = 1;i<=customers.length();i++){
            if(customers.charAt(i-1) == 'Y'){
                left[i][1] = left[i-1][1];
            }
            else{
                left[i][1] = left[i-1][1] + 1;
            }
        }
        for(int i = customers.length()-2;i>=-1;i--){
            if(customers.charAt(i+1) == 'Y'){
                right[i+1][0] = right[i+2][0] + 1;
            }
            else{
                right[i+1][0] = right[i+2][0];
            }
        }
        int minRes = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i<left.length;i++){
            if(left[i][1] + right[i][0] < minRes){
                minRes = left[i][1] + right[i][0];
                res = i;
            }
        }
        return res;
    }
}