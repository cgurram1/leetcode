class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def canDistribute(k):
            count = sum(1 for c in citations if c >= k)
            return count >= k        

        l, r = 1, len(citations)
        res = 0
        while l <= r:
            mid = (l + r) // 2
            if canDistribute(mid):
                res = mid
                l = mid + 1
            else:
                r = mid - 1
        
        return res
