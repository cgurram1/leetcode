class Solution:
    def largestIsland(self, grid):
        n = len(grid)
        parent = {}
        size = {}

        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            p1, p2 = find(x), find(y)
            if p1 == p2:
                return size[p1]

            if size[p1] < size[p2]:
                p1, p2 = p2, p1

            parent[p2] = p1
            size[p1] += size[p2]

            return size[p1]

        # init
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    parent[(i,j)] = (i,j)
                    size[(i,j)] = 1

        # union
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                        ni, nj = i+di, j+dj
                        if 0 <= ni < n and 0 <= nj < n and grid[ni][nj] == 1:
                            union((i,j), (ni,nj))

        result = max(size.values(), default=0)

        # flip 0
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = set()
                    temp = 1
                    for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                        ni, nj = i+di, j+dj
                        if 0 <= ni < n and 0 <= nj < n and grid[ni][nj] == 1:
                            root = find((ni,nj))
                            if root not in seen:
                                seen.add(root)
                                temp += size[root]
                    result = max(result, temp)

        return result if result else n*n
        