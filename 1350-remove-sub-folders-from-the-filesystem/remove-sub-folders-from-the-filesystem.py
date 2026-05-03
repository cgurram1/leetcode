class Trie:
    def __init__(self):
        self.root = TrieNode()
    def hasWord(self,word):
        currNode = self.root
        i = 0
        while i < len(word):
            ch = word[i]
            idx = -1
            if ch != '/':
                idx = ord(ch) - ord('a')
            else:
                idx = 26
            if currNode.arr[idx] == None:
                return False
            else:
                if i == len(word)-1:
                    if currNode.arr[idx].isEnd:
                        return True
                    else:
                        return False
                else:
                    currNode = currNode.arr[idx]
            i+=1
        return False         
                
    def addWord(self,word):
        currNode = self.root
        for i,ch in enumerate(word):
            if ch == '/':
                idx = 26
            else:
                idx = ord(ch) - ord('a')
            if currNode.arr[idx] == None:
                currNode.arr[idx] = TrieNode()
            if i == len(word) - 1 or word[i+1] == '/':
                if currNode.arr[idx] and currNode.arr[idx].isEnd == True:
                    return False
            if i == len(word)-1:
                currNode.arr[idx].isEnd = True
            currNode = currNode.arr[idx] 
        return True
class TrieNode:
    def __init__(self):
        self.arr = [None for _ in range(27)]
        self.isEnd = False
class Solution:
    def removeSubfolders(self, folders: List[str]) -> List[str]:
        folders.sort()
        res = []
        trie = Trie()
        for folder in folders:
            if trie.addWord(folder):
                res.append(folder)
        return res
