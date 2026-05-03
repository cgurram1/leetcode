class Solution:
    def removeSubfolders(self, folders: List[str]) -> List[str]:
        folders.sort()
        res = [folders[0]]

        for folder in folders[1:]:
            prev = res[-1]
            if not (folder.startswith(prev) and folder[len(prev)] == '/'):
                res.append(folder)

        return res