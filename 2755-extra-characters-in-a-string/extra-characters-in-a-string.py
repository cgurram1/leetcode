class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
class Trie:
    def __init__(self):
        self.node = TrieNode()
    def addWord(self,word):
        currNode = self.node
        for i,ch in enumerate(word):
            if ch not in currNode.children:
                currNode.children[ch] = TrieNode()
            if i == len(word)-1:
                currNode.children[ch].isWord = True 
            currNode = currNode.children[ch]
    def searchWord(self,word):
        currNode = self.node
        for i,ch in enumerate(word):
            if ch not in currNode.children:
                return False
            if i == len(word)-1 and currNode.children[ch].isWord == False:
                return False
            currNode = currNode.children[ch]
        return True
            
            

class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        trie = Trie()
        for word in dictionary:
            trie.addWord(word)
        dp = {}
        def REC(index):
            if index == len(s):
                return 0
            if index in dp:
                return dp[index]
            chars = 1 + REC(index + 1)
            currNode = trie.node
            for i in range(index, len(s)):
                ch = s[i]
                if ch in currNode.children:
                    if currNode.children[ch].isWord == True:
                        chars = min(chars,REC(i+1))
                    currNode = currNode.children[ch]
                elif ch not in currNode.children:
                    break
            dp[index] = chars
            return chars
        return REC(0)
