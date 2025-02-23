class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        def func(goal):
            if goal < 0:
                return 0
            l = 0
            r = 0
            curr = 0
            count = 0
            while(r < len(nums)):
                curr+=nums[r]
                while(curr > goal):
                    curr-=nums[l]
                    l+=1
                count+=(r - l + 1)
                r+=1
            return count
        return func(goal) - func(goal-1)