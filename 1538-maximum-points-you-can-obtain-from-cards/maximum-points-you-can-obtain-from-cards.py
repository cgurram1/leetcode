class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        l = 0
        r = len(cardPoints) - k - 1
        k_sum = sum(cardPoints[l:r+1])
        total_sum = k_sum + sum(cardPoints[r+1:])
        curr_max = float('-inf')
        while(r < len(cardPoints)-1):
            print(l,r,k_sum,curr_max)
            curr_max = max(curr_max, total_sum - k_sum)
            r+=1
            k_sum+=cardPoints[r]
            k_sum-=cardPoints[l]
            l+=1
        return max(curr_max, total_sum - k_sum)


