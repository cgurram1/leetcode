"""

[[0,2],[1,3],[1,1]]
1,2,3,4,5,10

4 10 5 3 2 1
1 3  2 1 0 0
0 1  2 3 4 5

"""
class Solution:
    def maxSumRangeQuery(self, nums: List[int], requests: List[List[int]]) -> int:
        freqs = [0] * (len(nums) + 1)

        for l, r in requests:
            freqs[l] += 1
            if r + 1 < len(freqs):
                freqs[r + 1] -= 1

        for i in range(1, len(nums)):
            freqs[i] += freqs[i - 1]
        
        freqs = sorted(freqs, reverse=True)
        nums = sorted(nums, reverse=True)
        result = 0
        counter = 0
        while(counter < len(nums) and freqs[counter] > 0):
            result = result + freqs[counter] * nums[counter]
            counter+=1
        return result % (10**9 + 7)
