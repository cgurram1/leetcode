func isAnagram(s string, t string) bool {
    // charsS := strings.Split(s,"")
    // sort.Strings(charsS)
    // newS := strings.Join(charsS,"")
    // charsT := strings.Split(t,"")
    // sort.Strings(charsT)
    // newT := strings.Join(charsT,"")
    // return newS == newT


    sMap := make(map[rune]int)
    tMap := make(map[rune]int)
    for _,char := range s{
        sMap[char]+=1
    }
    for _,char := range t{
        tMap[char]+=1
    }
    if len(sMap) != len(tMap){
        return false
    }
    for key,val := range sMap{
        if tMap[key] != val{
            return false
        }
    }
    return true
}