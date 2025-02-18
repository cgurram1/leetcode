class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        mySet = {}
        r = 0
        l = 0
        res = float('-inf')
        while(r < len(fruits)):
            if fruits[r] in mySet:
                mySet[fruits[r]] += 1
            else:
                mySet[fruits[r]] = 1
            if len(mySet) > 2:
                if mySet[fruits[l]] == 1:
                    del mySet[fruits[l]]
                else:
                    mySet[fruits[l]]-=1
                l+=1
            res = max(res,r-l+1)
            r+=1
        return res