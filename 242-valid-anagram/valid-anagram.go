func isAnagram(s string, t string) bool {

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