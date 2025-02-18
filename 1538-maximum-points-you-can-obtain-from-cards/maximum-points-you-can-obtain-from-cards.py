class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        l = 0
        r = len(cardPoints) - k - 1
        k_sum = sum(cardPoints[l:r+1])
        curr_min = float('inf')
        while(r < len(cardPoints)-1):
            curr_min = min(curr_min, k_sum)
            r+=1
            k_sum+=cardPoints[r]
            k_sum-=cardPoints[l]
            l+=1
        curr_min = min(curr_min, k_sum)
        return sum(cardPoints) - curr_min


