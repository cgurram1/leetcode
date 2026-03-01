"""
1--> 1
2--> 1
3--> 3
4--> 6
5-->10
6


4
2,2 (4)
1,1 (1)
1,1 (1)


1,3 (3)
1,2 (2)
1,1 (1)


5
1,4.(4)  2,3. (6)   
(6).    (1) + (3)

"""
class Solution:
    def minCost(self, n: int) -> int:
        if n == 1 or n == 2:
            return n - 1
        prev = 1
        i = 3
        while i <= n:
            prev = (i-1 + prev)
            i+=1
        return prev
        