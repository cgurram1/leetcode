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
        level = 1
        while queue:
            currWord,level = queue.popleft()
            visited.add(currWord)
            for i in range(len(word)):
                pattern = currWord[:i] + '*' + currWord[i+1:]
                for adjWord in patternMap[pattern]:
                    if adjWord == endWord:
                        return level + 1
                    if adjWord not in visited:
                        queue.append((adjWord,level + 1))
        return 0

