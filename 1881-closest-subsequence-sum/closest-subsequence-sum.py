class Solution:
    def minAbsDifference(self, nums: List[int], goal: int) -> int:
        def fun(index,s,arr,res):
            if index == len(arr):
                res.add(s)
                return
            fun(index + 1,s + arr[index],arr,res)
            fun(index + 1, s, arr,res)
        res1,res2 = set(),set()
        fun(0,0,nums[:len(nums)//2],res1)
        fun(0,0,nums[len(nums)//2:],res2)
        res = float('inf')
        res2 = sorted(res2)
        for val in res1:
            remain = goal - val
            right = bisect_left(res2,remain)
            if right < len(res2):
                res = min(res, res2[right] - remain)
            if res == 0:
                return 0
            if right > 0:
                res = min(res, remain - res2[right-1])
            if res == 0:
                return 0
        return res

