class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        def DFS(index,k):
            #Base Case
            if index == len(target):
                return 1
            if k == len(words[0]):
                return 0
            if (index,k) in dp:
                return dp[(index,k)]
            count = 0
            count += DFS(index, k + 1)
            if precomputes[(k,target[index])] > 0:
                count+=(precomputes[(k,target[index])] * DFS(index + 1,k+1))
            dp[(index,k)] = count
            return count % mod
        dp = {}
        mod = 10**9 + 7
        precomputes = defaultdict(int)
        for word in words:
            for i,ch in enumerate(word):
                precomputes[(i,ch)]+=1
        return DFS(0,0)
