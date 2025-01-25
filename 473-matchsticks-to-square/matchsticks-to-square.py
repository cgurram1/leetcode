class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        matchsticks.sort(reverse=True)
        s = sum(matchsticks)
        if (float(s // 4) != s/4) or matchsticks[0] > s//4:
            return False
        target = s // 4
        arr = [0] * 4
        def myFun(index):
            if index == len(matchsticks):
                return True
            for i in range(4):
                if arr[i]+matchsticks[index] <= target:
                    arr[i]+=matchsticks[index]
                    if myFun(index+1):
                        return True
                    arr[i]-=matchsticks[index]
                    if arr[i] == 0:
                        break
            return False
        return myFun(0)