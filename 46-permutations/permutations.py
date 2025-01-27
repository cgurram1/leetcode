class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def myFun(arr):
            if len(arr) == len(nums):
                res.append(arr[:])
                return
            for i in range(len(nums)):
                if nums[i] not in arr:
                    arr.append(nums[i])
                    myFun(arr)
                    arr.pop(-1)
        myFun([])
        return res
            
                    