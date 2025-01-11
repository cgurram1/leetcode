class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        def myRec(index,arr):
            if index == len(nums):
                if sorted(arr[:]) not in res:
                    res.append(sorted(arr[:])) 
                return
            arr.append(nums[index])
            myRec(index + 1, arr)
            arr.pop()
            myRec(index + 1, arr)
        res = []
        myRec(0,[])
        return res