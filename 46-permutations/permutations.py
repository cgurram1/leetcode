class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def myFun(level,arr):
            if level == len(arr):
                res.append(arr[:])
            for i in range(level,len(nums)):
                new_arr = arr[:]
                new_arr[i],new_arr[level] = new_arr[level],new_arr[i]
                myFun(level + 1,new_arr)
        myFun(0,nums)
        return res
            
                    