class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        total = sum(matchsticks)
        groupSize = total//4
        matchsticks = sorted(matchsticks,reverse=True)
        print(matchsticks)
        if groupSize != (int)(total/4):
            return False
        if(max(matchsticks) > groupSize):
            return False
        def fun(index,groups):
            if(index == len(matchsticks)):
                return True
            for i in range(4):
                if i > 0 and groups[i] == groups[i-1]:
                    continue
                if(groups[i] + matchsticks[index] <= groupSize):
                    groups[i] += matchsticks[index]
                    if fun(index + 1, groups):
                        return True
                    groups[i] -= matchsticks[index]
            return False
        return fun(0,[0,0,0,0])
                

