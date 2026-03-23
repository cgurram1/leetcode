class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:

        def rec(index,word):
            if index == len(word):
                return 0
            count = float('-inf')
            for i in range(index,len(word)):
                if word[index:i+1] in s:
                    if i+1 not in dp:
                        dp[i+1] = rec(i+1, word)
                    ret = dp[i+1]
                    if ret != float('-inf'):
                        count = max(count,1 + ret)
            dp[index] = count
            return dp[index]
        result = []
        s = set(words)
        for word in words:
            dp = {}
            if rec(0,word) >= 2:
                result.append(word)
        return result