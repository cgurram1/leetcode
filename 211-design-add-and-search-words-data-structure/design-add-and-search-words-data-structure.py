class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
class WordDictionary:

    def __init__(self):
        self.dictionary = TrieNode()
        

    def addWord(self, word: str) -> None:
        children = self.dictionary.children
        for i,ch in enumerate(word):
            if ch not in children:
                children[ch] = TrieNode()
            if i == len(word)-1:
                children[ch].isWord = True    
            children = children[ch].children

    def search(self, word: str) -> bool:
        def REC(index,Node):
            if index == len(word):
                if Node.isWord == True:
                    return True
                else:
                    return False
            if word[index] != '.' and word[index] not in Node.children:
                return False
            elif word[index] != '.':
                return REC(index + 1, Node.children[word[index]])
            else:
                for key in Node.children:
                    if REC(index + 1, Node.children[key]) == True:
                        return True
            return False
        
        return REC(0,self.dictionary)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)