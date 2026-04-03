class Solution:
    def countAndSay(self, n: int) -> str:
        prev = "1"
        i = n
        for i in range(2,n+1):
            nextStr = []
            count = 1
            prevCh = prev[0]
            for j in range(1,len(prev)):
                if prev[j] == prevCh:
                    count+=1
                else:
                    nextStr.append(str(count))
                    nextStr.append(str(prevCh))
                    prevCh = prev[j]
                    count = 1
            nextStr.append(str(count))
            nextStr.append(str(prevCh))
            prev = ''.join(nextStr)
        return prev
