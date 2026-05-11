"""

rolls = [3,2,4,3], mean = 4, n = 2
 ( 10 + x ) // 8 = 6
 x = 38

 x = mean * (len(rolls)+n) - sum(rolls)
 x = 12
 n = 2

 n = 4

 17
 6,



"""

class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        target = mean * (len(rolls)+n) - sum(rolls)
        if 6 * n < target:
            return []
        curr = 6
        result = []
        while n>0 and curr > 0:
            if target - curr >= n-1:
                result.append(curr)
                target-=curr
                n-=1
            else:
                curr-=1
        return result