func isAnagram(s string, t string) bool {
    charsS := strings.Split(s,"")
    sort.Strings(charsS)
    newS := strings.Join(charsS,"")
    charsT := strings.Split(t,"")
    sort.Strings(charsT)
    newT := strings.Join(charsT,"")
    return newS == newT
}