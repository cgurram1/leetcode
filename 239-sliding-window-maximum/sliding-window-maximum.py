class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        q = deque()
        result = []
        right = k-1
        left = 0
        for i in range(k):
            while q and q[-1] < nums[i]:
                q.pop()
            q.append(nums[i])
        while right < len(nums):
            # print(q)
            result.append(q[0])
            if q[0] == nums[left]:
                q.popleft()
            left+=1
            right+=1
            if right < len(nums):
                while q and q[-1] < nums[right]:
                    q.pop()
                q.append(nums[right])
        return result