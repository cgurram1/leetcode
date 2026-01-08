class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        resSet = set()
        result = 0
        @lru_cache(None)
        def rec(index):
            nonlocal resSet
            if index >= len(nums):
                return 0
            if index not in resSet:
                resSet.add(index)
                return 1 + rec(nums[index])
            else:
                return 0

        for i in range(len(nums)):
            result = max(result, rec(i))
            resSet = set()

        return result
