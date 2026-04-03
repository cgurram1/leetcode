from sortedcontainers import SortedList
class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        proArr = [0 for _ in range(n)]
        for i,num in enumerate(nums):
            if num == target:
                proArr[i] = 1
            else:
                proArr[i] = -1
        sl = SortedList()
        sl.add(0)
        prefix = 0
        count = 0
        for val in proArr:
            prefix+=val
            sl.add(prefix)
            count += sl.bisect_left(prefix)
        
        return count

