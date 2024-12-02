class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split(' ')
        lenSearchWord = len(searchWord)
        for i,word in enumerate(words):
            if len(word) >= lenSearchWord:
                if searchWord == word[:lenSearchWord]:
                    return i + 1
        return -1