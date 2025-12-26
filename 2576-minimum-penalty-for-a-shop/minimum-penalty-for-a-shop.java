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
        int [] left = new int[customers.length()+1];
        int [] right = new int[customers.length()+1];
        for(int i = 1;i<=customers.length();i++){
            left[i] = left[i-1];
            if(customers.charAt(i-1) == 'N'){
                left[i] += 1;
            }
        }
        for(int i = customers.length()-2;i>=-1;i--){
            right[i+1] = right[i+2];
            if(customers.charAt(i+1) == 'Y'){
                right[i+1] += 1;
            }
        }
        int minRes = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i<left.length;i++){
            if(left[i] + right[i] < minRes){
                minRes = left[i] + right[i];
                res = i;
            }
        }
        return res;
    }
}