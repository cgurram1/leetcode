class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def myRec(arr,level,res):
            if level == len(nums):
                res.append(arr[:])
                return
            myRec(arr,level + 1,res)
            arr.append(nums[level])
            myRec(arr, level + 1,res)
            arr.pop()
            return
        res = []
        myRec([],0,res)
        return res