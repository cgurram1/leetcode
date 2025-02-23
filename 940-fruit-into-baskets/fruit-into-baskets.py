class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        l = 0
        r = 0 
        res = 0
        myDict = {}
        count = 0
        while(r < len(fruits)):
            count+=1
            if fruits[r] in myDict:
                myDict[fruits[r]]+=1
            else:
                myDict[fruits[r]] = 1
            if len(myDict) > 2:
                count-=1
                if myDict[fruits[l]] == 1:
                    del myDict[fruits[l]]
                else:
                    myDict[fruits[l]]-=1
                l+=1
            if len(myDict) <= 2:
                res = max(res,count)
            r+=1
        return res