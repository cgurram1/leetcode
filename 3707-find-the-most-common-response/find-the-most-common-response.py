class Solution:
    def findCommonResponse(self, responses: List[List[str]]) -> str:
        freqs = defaultdict(int)
        for i in range(len(responses)):
            res = set(responses[i])
            for word in res:
                freqs[word]+=1
        return sorted(freqs.items(), key=lambda x: (-x[1],x[0]))[0][0]