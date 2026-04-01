class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isWord = False
class Trie:
    def __init__(self):
        self.node = TrieNode()
    def addWord(self,word):
        currNode = self.node
        for i,ch in enumerate(word):
            if currNode.children[ord(ch) - ord('a')] == None:
                currNode.children[ord(ch) - ord('a')] = TrieNode()
            currNode = currNode.children[ord(ch) - ord('a')]
            if i == len(word)-1:
                currNode.isWord = True
    def searchWord(self,word):
        currNode = self.node
        for i,ch in enumerate(word):
            if currNode.children[ord(ch) - ord('a')] == None:
                return False
            currNode = currNode.children[ord(ch) - ord('a')]
        return currNode.isWord
    def suggest(self,s):
        result = []
        currNode = self.node
        for ch in s:
            if currNode.children[ord(ch) - ord('a')] == None:
                return []
            currNode = currNode.children[ord(ch) - ord('a')]
        def DFS(node, curr):
            if len(result) < 3:
                if node.isWord == True:
                    result.append(''.join(curr))
                for i in range(26):
                    if node.children[i] != None:
                        curr.append(chr(i + ord('a')))
                        DFS(node.children[i], curr)
                        curr.pop()
        DFS(currNode, list(s))
        return result

            
class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        trieNode = Trie()
        for product in products:
            trieNode.addWord(product)
        result = []
        # for product in products:
        #     print(product, trieNode.searchWord(product))
        # print(trieNode.node.children)
        for i in range(len(searchWord)):
            result.append(trieNode.suggest(searchWord[:i+1]))
        return result