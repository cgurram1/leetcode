"""
1,1
1,0


"""
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        parent = {}
        size = {}
        def find(cord):
            if cord != parent[cord]:
                parent[cord] = find(parent[cord])
            return parent[cord]
        def union(cord1, cord2):
            p1 = find(cord1)
            p2 = find(cord2)
            if size[p1] < size[p2]:
                p1, p2 = p2, p1
            parent[p1] = p2
            size[p2]+=size[p1]
            size.pop(p1)
            return size[p2]
        lands = deque()
        for i in range(len(grid)):
            for j in range(len(grid)):
                if grid[i][j] == 1:
                    parent[(i,j)] = (i,j)
                    size[(i,j)] = 1
                    lands.append((i,j))
        result = 1
        while lands:
            i,j = lands.popleft()
            for di,dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                ni,nj = di + i, dj + j
                if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]) and grid[ni][nj] == 1 and find((i,j)) != find((ni,nj)):
                    result = max(result,union((i,j),(ni,nj)))
        

        for i in range(len(grid)):
            for j in range(len(grid)):
                if grid[i][j] == 0:
                    tempSize = 0
                    parents = set()
                    for di,dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                        ni,nj = di + i, dj + j
                        if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]) and grid[ni][nj] == 1:
                            parents.add(find((ni,nj)))
                    for par in parents:
                        tempSize+=size[par]
                    result = max(result, tempSize+1)
        return result
