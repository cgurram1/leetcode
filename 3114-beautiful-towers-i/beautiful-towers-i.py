class Solution:
    def maximumSumOfHeights(self, heights: List[int]) -> int:
        n = len(heights)
        left_sum = [0] * n
        stack = []
        for i in range(n):
            while stack and heights[stack[-1]] > heights[i]:
                stack.pop()
            if stack:
                left_sum[i] = left_sum[stack[-1]] + (heights[i] * (i - stack[-1]))
            else:
                left_sum[i] = heights[i] * (i + 1)
            stack.append(i)
        right_sum = [0] * n
        stack = []
        for i in range(n - 1, -1, -1):
            print(stack)
            while stack and heights[stack[-1]] > heights[i]:
                stack.pop()
            if stack:
                right_sum[i] = right_sum[stack[-1]] + (heights[i] * (stack[-1] - i))
            else:
                right_sum[i] = heights[i] * (n - i)
            stack.append(i)
        max_sum = 0
        for i in range(n):
            max_sum = max(max_sum, left_sum[i] + right_sum[i] - heights[i])
        return max_sum