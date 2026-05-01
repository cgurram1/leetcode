class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        words = set(wordDict)
        dp = {}
        def fun(index):
            if index == len(s):
                return [[]]
            if index in dp:
                return dp[index]
            res = []
            for i in range(index+1,len(s)+1):
                currWord = s[index:i]
                if currWord in words:
                    innerres = fun(i)
                    for innerList in innerres:
                        ls = innerList.copy()
                        ls.append(currWord)
                        res.append(ls)
            dp[index] = res
            return res
        answer = []
        result = fun(0)
        for l in result:
            answer.append(" ".join(l[::-1]))
        return answer