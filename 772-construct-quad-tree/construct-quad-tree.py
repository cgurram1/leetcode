"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':
        def REC(n,r,c):
            isSame = True
            for i in range(n):
                for j in range(n):
                    if grid[r][c] != grid[r + i][c + j]:
                        isSame = False
                        break
                if not isSame:
                    break
            if isSame:
                return Node(grid[r][c],True)
            n = n // 2
            Tleft = REC(n,r,c)
            Tright = REC(n,r,c+n)
            BLeft = REC(n,r+n,c)
            BRight = REC(n,r+n,c+n)
            return Node(-1,False,Tleft,Tright,BLeft,BRight)

        return REC(len(grid),0,0)