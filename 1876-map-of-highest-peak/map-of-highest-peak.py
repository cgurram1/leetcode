from collections import deque

class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        m, n = len(isWater), len(isWater[0])
        peaks = [[-1]*n for _ in range(m)]
        q = deque()

        for i in range(m):
            for j in range(n):
                if isWater[i][j] == 1:
                    peaks[i][j] = 0
                    q.append((i, j))

        while q:
            i, j = q.popleft()
            for di, dj in [(1,0),(-1,0),(0,1),(0,-1)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and peaks[ni][nj] == -1:
                    peaks[ni][nj] = peaks[i][j] + 1
                    q.append((ni, nj))

        return peaks
