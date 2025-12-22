class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3){
            return 0;
        }
        int res = 0;
        for(int i = 1;i<arr.length-1;i++){
            int left = i - 1;
            int right = i + 1;
            while(left >=0 && arr[left] < arr[left+1]){
                left-=1;
            }
            left+=1;
            while(right < arr.length && arr[right] < arr[right-1]){
                right+=1;
            }
            right-=1;
            if(left < i && right > i){
                res = Math.max(res, right - left + 1);
            }
        }
        // if(res == 1){
        //     return 0;
        // }
        return res;
    }
}