class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        def addEdge(e1,e2):
            pe1 = find(e1)
            pe2 = find(e2)
            parent[pe2] = pe1
        def find(e):
            if parent[e] == e:
                return e
            parent[e] = find(parent[e])
            return parent[e]
        

        parent = {}
        mapping = {}
        for account in accounts:
            for email in account[1:]:
                parent[email] = email
                mapping[email] = account[0]
        for account in accounts:
            for i in range(1,len(account)-1):
                addEdge(account[i],account[i+1])
        result = defaultdict(set)
        for account in accounts:
            for email in account[1:]:
                result[find(email)].add(email)
        answer = []
        for acc,val in result.items():
            answer.append([mapping[acc]] + sorted(list(val)))
        return(answer)