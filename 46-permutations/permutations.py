class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def myRec(arr):
            if len(arr) == len(nums):
                res.append(arr[:])
                return
            for i in nums:
                if i not in arr:
                    arr.append(i)
                    myRec(arr)
                    arr.pop() 
        res = []
        myRec([])
        return res