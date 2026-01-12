class Solution:
    def compressedString(self, word: str) -> str:
        res = []
        count = 1
        for i in range(1,len(word)):
            if word[i] == word[i-1] and count <= 8:
                count+=1
            else:
                res.append(str(count))
                res.append(word[i-1])
                count = 1
        res.append(str(count))
        res.append(word[-1])
        return ''.join(res)
            