class Solution:
    def trap(self, height: List[int]) -> int:
        left = [-1] * len(height)
        right = [-1] * len(height)
        curr_max_left = -1
        curr_max_right = -1
        N = len(height)
        res = 0
        for i in range(N):
            curr_max_left = max(curr_max_left,height[i])
            curr_max_right = max(curr_max_right,height[N - i - 1])
            left[i] = curr_max_left
            right[N-i-1] = curr_max_right
        for i in range(N):
            res += abs(min(left[i],right[i])-height[i])
        return res
