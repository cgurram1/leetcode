class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        S = sum(matchsticks)
        arr = [0] * 4
        if float(S // 4) != S/4:
            return False
        target = S // 4
        matchsticks.sort(reverse=True)

        def myFun(index):
            if index == len(matchsticks):
                return True
            for i in range(4):
                if arr[i]+ matchsticks[index] <= target:
                    arr[i] += matchsticks[index]
                    if myFun(index + 1) == True:
                        return True
                    arr[i]-=matchsticks[index]
            return False
        return myFun(0)


        