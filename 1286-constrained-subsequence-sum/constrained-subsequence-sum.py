class Solution:
    def constrainedSubsetSum(self, nums, k):
        dq = deque()
        dp = nums[:]

        for i in range(len(nums)):
            while dq and dq[0] < i - k:
                dq.popleft()
            if dq:
                dp[i] = max(dp[i], dp[dq[0]] + nums[i])
            while dq and dp[dq[-1]] <= dp[i]:
                dq.pop()

            dq.append(i)

        return max(dp)
        
