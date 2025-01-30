class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = []
        nextRotten = 0
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append((i,j))
                    nextRotten+=1
        x = [1,-1,0,0]
        y = [0,0,1,-1]
        while(queue):
            print(queue,nextRotten)
            rotten = nextRotten
            nextRotten = 0
            for _ in range(rotten):
                i,j = queue.pop(0)
                for k in range(4):
                    nexti = i + x[k]
                    nextj = j + y[k]
                    if nexti >= 0 and nexti < len(grid) and nextj >= 0 and nextj < len(grid[0]) and grid[nexti][nextj] == 1:
                        queue.append((nexti,nextj))
                        grid[nexti][nextj] = 2
                        nextRotten+=1
            res+=1
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    print("Hello")
                    return -1
        if res == 0:
            return 0
        return res - 1
        


