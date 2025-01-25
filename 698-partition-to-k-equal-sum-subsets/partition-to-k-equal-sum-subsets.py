class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        nums.sort(reverse = True)
        s = sum(nums)
        target = s//k
        if float(s//k) != s/k or nums[0] > target:
            return False
        arr = [0] * k
        def myFun(index):
            if index >= len(nums):
                return True
            for i in range(k):
                if arr[i]+nums[index] <= target:
                    arr[i]+=nums[index]
                    if myFun(index + 1):
                        return True
                    arr[i]-=nums[index]
                    if arr[i] == 0:
                        break
            return False
        return myFun(0)