class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        patternMap = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + '*' + word[i+1:]
                patternMap[pattern].append(word)
        queue = deque()
        queue.append((beginWord,1))
        visited = set()
        visited.add(beginWord)
        level = 1
        while queue:
            currWord,level = queue.popleft()
            for i in range(len(word)):
                pattern = currWord[:i] + '*' + currWord[i+1:]
                for adjWord in patternMap[pattern]:
                    if adjWord == endWord:
                        return level + 1
                    if adjWord not in visited:
                        visited.add(adjWord)
                        queue.append((adjWord,level + 1))
        return 0

