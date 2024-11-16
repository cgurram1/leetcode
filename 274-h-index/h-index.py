class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations = sorted(citations)
        citations.insert(-1,0)
        left = 1
        right = len(citations) - 1
        res = 0
        while(left <= right):
            mid = (right + left) // 2
            count = 0
            for i in citations:
                if i >= mid:
                    count+=1
                if count == mid:
                    break
            if count == mid:
                res = max(res,count)
                left = mid + 1
            else:
                right = mid - 1
        return res
            