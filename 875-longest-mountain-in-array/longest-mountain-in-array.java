class Solution {
    public int longestMountain(int[] arr) {
        int up = 0;
        int down = 0;
        int res = 0;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] > arr[i-1]){
                if(down > 0){
                    down = 0;
                    up = 0;
                }
                up+=1;
            }
            else if(up > 0 && arr[i] < arr[i-1]){
                down+=1;
                res = Math.max(res, down + up + 1);
            }
            else if(arr[i] == arr[i-1]){
                up = 0;
                down = 0;
            }
            // System.out.println(i + " : " + up + " | " + down);
        }
        return res;
    }
}