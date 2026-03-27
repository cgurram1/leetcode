class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        s = sum(nums)
        if float(s) // k != s/k:
            return False
        requiredSize = s//k
        
        groups = [0 for _ in range(k)]
        nums.sort(reverse=True)
        def REC(index,groups):
            if index == len(nums):
                return True
            for i in range(k):
                if i > 0 and groups[i] == groups[i-1]:
                    continue
                if groups[i] + nums[index] <= requiredSize:
                    groups[i] += nums[index]
                    if REC(index + 1,groups):
                        return True
                    groups[i] -= nums[index]
            return False
        return REC(0,groups)