class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        resSet = set()
        result = 0
        @lru_cache(None)
        def rec(index):
            nonlocal resSet
            if index >= len(nums):
                return
            if index not in resSet:
                resSet.add(index)
                rec(nums[index])
            else:
                return

        for i in range(len(nums)):
            rec(i)
            result = max(result, len(resSet))
            resSet = set()

        return result
