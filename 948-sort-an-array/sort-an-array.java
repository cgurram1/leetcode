class Solution {
    public int [] numsG;
    public int[] sortArray(int[] nums) {
        numsG = nums;
        return divide(0,nums.length);
    }
    public int[] divide(int left, int right){
        if(right - left == 1){
            return new int[]{numsG[left]};
        }
        if(right - left == 0){
            return new int[0];
        }
        int [] leftSorted = divide(left, (left + right)/2);
        int [] rightSorted = divide((left + right)/2, right);
        return merge(leftSorted,rightSorted);
    }
    public int [] merge(int [] left, int [] right){
        int [] res = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                res[i] = left[l];
                l++;
            }
            else{
                res[i] = right[r];
                r++;
            }
            i++;
        }
        while(l < left.length){
            res[i] = left[l];
            l++;
            i++;
        }
        while(r < right.length){
            res[i] = right[r];
            r++;
            i++;
        }
        return res;
    }
}