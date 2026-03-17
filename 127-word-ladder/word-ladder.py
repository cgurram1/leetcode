class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        patternMap = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + '*' + word[i+1:]
                patternMap[pattern].append(word)
        queue = deque()
        queue.append(beginWord)
        queue.append(None)
        visited = set()
        level = 1
        while queue[0] != None:
            level += 1
            while queue[0] != None:
                currWord = queue.popleft()
                visited.add(currWord)
                for i in range(len(word)):
                    pattern = currWord[:i] + '*' + currWord[i+1:]
                    for adjWord in patternMap[pattern]:
                        if adjWord == endWord:
                            return level
                        if adjWord not in visited:
                            queue.append(adjWord)
            queue.append(queue.popleft())
        return 0

