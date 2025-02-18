class Solution:
    def maximumSumOfHeights(self, heights: List[int]) -> int:
        res = float('-inf')
        def current_max(heights,peak):
            current_max = heights[peak]
            res = 0
            for i in range(peak - 1,-1,-1):
                if heights[i] <= current_max:
                    res+=heights[i]
                    current_max = heights[i]
                else:
                    res+=current_max
            current_max = heights[peak]
            for i in range(peak + 1,len(heights)):
                if heights[i] <= current_max:
                    res+=heights[i]
                    current_max = heights[i]
                else:
                    res+=current_max
            return res + heights[peak]
        for i in range(len(heights)):
            curr = current_max(heights,i)
            res = max(res,curr)
        return res