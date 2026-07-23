class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        # ans = set()
        # for i in range(len(nums)):
        #     for j in range(i,len(nums)):
        #         for k in range(j,len(nums)):
        #             ans.add((nums[i] ^ nums[j]) ^ nums[k])
        # return len(ans)

        n = len(nums)
        if n <= 2:
            return n
        count = 0
        while n > 0:
            n = n//2
            count+=1
        return 2 ** count


