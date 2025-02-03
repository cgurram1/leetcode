class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        if beginWord not in wordList:
            wordList.insert(0,beginWord)
        grid = [[] for _ in range(len(wordList))]
        for i in range(len(grid)):
            for j in range(i+1,len(grid)):
                count = 0
                for k in range(len(wordList[i])):
                    if wordList[i][k] != wordList[j][k]:
                        count+=1
                        if count == 2:
                            break
                if count == 1:
                    grid[i].append(j)
                    grid[j].append(i)
        src = wordList.index(beginWord)
        dist = [float('inf') for _ in range(len(wordList))]
        dist[src] = 0
        queue = [src]
        dest = wordList.index(endWord)
        while(queue):
            curr = queue.pop(0)
            for nextNode in grid[curr]:
                if dist[curr] + 1 < dist[nextNode]:
                    dist[nextNode] = dist[curr] + 1
                    queue.append(nextNode)
        if dist[dest] == float('inf'):
            return 0
        return dist[dest] + 1