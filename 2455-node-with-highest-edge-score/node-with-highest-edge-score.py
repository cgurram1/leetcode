class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        score = [0 for _ in range(len(edges))]
        for i in range(len(edges)):
            score[edges[i]] += i
        resV = 0
        resK = -1
        for i in range(len(score)):
            if(score[i] > resV):
                resV = score[i]
                resK = i
        return resK

