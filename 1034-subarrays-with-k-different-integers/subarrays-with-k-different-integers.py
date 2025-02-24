class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        def func(k):
            l = 0
            r = 0
            myDict = {}
            res = 0
            while(r < len(nums)):
                if nums[r] in myDict:
                    myDict[nums[r]]+=1
                else:
                    myDict[nums[r]] = 1
                while(len(myDict) > k):
                    if myDict[nums[l]] == 1:
                        del myDict[nums[l]]
                    else:
                        myDict[nums[l]]-=1
                    l+=1
                res+=(r - l + 1)
                r+=1
            return res
        return func(k) - func(k-1)