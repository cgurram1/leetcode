class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        N = len(nums)
        prefix_sum = [0] * N
        prefix_sum[0] = nums[0]
        res = 0
        hashMap = {}
        hashMap[0] = 1
        if nums[0] - k in hashMap:
            res+=1
        if nums[0] in hashMap:
            hashMap[nums[0]]+=1
        else:
            hashMap[nums[0]] = 1
        for i in range(1,N):
            prefix_sum[i] = prefix_sum[i-1] + nums[i]
            if prefix_sum[i] - k in hashMap:
                res+=hashMap[prefix_sum[i] - k]
            if prefix_sum[i] in hashMap:
                hashMap[prefix_sum[i]]+=1
            else:
                hashMap[prefix_sum[i]]=1
        return res