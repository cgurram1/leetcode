"""

5

3,2,1


"""
class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        total = 0
        for num in nums:
            total+=num
        target = abs(goal - total)

        def rec(limit, target):
            if(target == 0):
                return 0
            if(limit == 0 or target < 0):
                return float('inf')
            return min(1 + rec(limit, target - limit), rec(limit-1,target))

        return math.ceil(target / limit)
        # return rec(limit, target)

