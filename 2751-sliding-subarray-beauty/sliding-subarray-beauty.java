class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int l = 0;
        int r = k-1;
        int n = nums.length;
        int [] res = new int[n - k + 1];
        int [] freq = new int[101];
        int index = 0;
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<=r;i++){
            freq[nums[i] + 50]+=1;
        }
        int total = 0;
        int xth = getXthSmallest(freq,x);
        int beauty = xth;
        if(beauty < 0){
            res[index] = beauty;
        }
        else{
            res[index] = 0;
        }
        index+=1;
        while(r < n-1){
            freq[nums[l] + 50]-=1;
            l+=1;
            r+=1;
            freq[nums[r] + 50]+=1;
            beauty = getXthSmallest(freq,x);
            if(beauty < 0){
                res[index] = beauty;
            }
            else{
                res[index] = 0;
            }
            index+=1;
        }
        return res;
    }
    public int getXthSmallest(int [] freq,int x){
        int total = 0;
        int xth = 0;
        for(int i = 0;i<101;i++){
            total+=freq[i];
            if(total >= x){
                xth = i-50;
                break;
            }
        }
        return xth;
    }
}