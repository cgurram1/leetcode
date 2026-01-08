class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        x = [1,-1,0,0]
        y = [0,0,1,-1]
        visited = set()
        result = []

        def dfs(i,j):
            nonlocal curr,visited
            visited.add((i,j))
            curr[0] = max(curr[0],i)
            curr[1] = max(curr[1],j)
            for k in range(4):
                if(i + x[k] >= 0 and i + x[k] < len(land) and j + y[k] >= 0 and j + y[k] < len(land[0]) and (i+x[k], j+y[k]) not in visited and land[i+x[k]][j+y[k]] == 1):
                    dfs(i+x[k],j+y[k])
        
        for i in range(len(land)):
            for j in range(len(land[0])):
                if((i,j) not in visited and land[i][j] == 1):
                    curr = [-1,-1]
                    dfs(i,j)
                    result.append([i,j] + curr.copy())
        
        return result
