class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        while(first <= last){
            int mid = (first + last)/2;
            if(nums[mid] == target){
                int left = 0;
                int right = mid;
                while(left <= right){
                    mid = (left + right)/2;
                    if(nums[mid] == target){
                        if(mid == left || nums[mid-1] != target){
                            first = mid;
                            break;
                        }
                        else{
                            right = mid - 1;
                        }
                    }
                    else{
                        left = mid + 1;
                    }
                }
                left = mid;
                right = nums.length-1;
                while(left <= right){
                    mid = (left + right)/2;
                    if(nums[mid] == target){
                        if(mid == right || nums[mid+1] != target){
                            last = mid;
                            break;
                        }
                        else{
                            left = mid + 1;
                        }
                    }
                    else{
                        right = mid - 1;
                    }
                }
                return new int[]{first,last};

            }
            else if(nums[mid] < target){
                first = mid + 1;
            }
            else{
                last = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}