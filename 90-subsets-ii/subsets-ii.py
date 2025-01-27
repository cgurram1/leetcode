class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        def myFun(index,arr):
            res.append(arr[:])
            for j in range(index,len(nums)):
                if j > index and nums[j] == nums[j-1]:
                    continue
                arr.append(nums[j])
                myFun(j+1,arr)
                arr.pop(-1)
        myFun(0,[])
        return res