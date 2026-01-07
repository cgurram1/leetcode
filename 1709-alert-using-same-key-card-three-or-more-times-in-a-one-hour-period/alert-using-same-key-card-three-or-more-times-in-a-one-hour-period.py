class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        ds = defaultdict(list)
        res = []
        for name, time in zip(keyName, keyTime):
            h,m = time.split(":")
            ds[name].append(int(h) * 60 + int(m))
        for name, times in ds.items():
            times = sorted(times)
            for i in range(2,len(times)):
                if(times[i] - times[i-2] <= 60):
                    res.append(name)
                    break
        return sorted(res)



