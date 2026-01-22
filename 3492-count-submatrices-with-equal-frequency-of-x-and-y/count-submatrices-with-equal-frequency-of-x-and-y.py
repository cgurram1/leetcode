class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        freqs = [[[0, 0] for _ in range(n)] for _ in range(m)]
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 'X':
                    freqs[i][j] = [1, 0]
                elif grid[i][j] == 'Y':
                    freqs[i][j] = [0, 1]

                if i > 0:
                    freqs[i][j][0] += freqs[i-1][j][0]
                    freqs[i][j][1] += freqs[i-1][j][1]

                if j > 0:
                    freqs[i][j][0] += freqs[i][j-1][0]
                    freqs[i][j][1] += freqs[i][j-1][1]
                
                if i > 0 and j > 0:
                    freqs[i][j][0] -= freqs[i-1][j-1][0]
                    freqs[i][j][1] -= freqs[i-1][j-1][1]

                if freqs[i][j][0] == freqs[i][j][1] and freqs[i][j][0] > 0:
                    count += 1

        return count
