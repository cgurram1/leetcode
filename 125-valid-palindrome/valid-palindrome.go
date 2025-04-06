func isPalindrome(s string) bool {
    chars := []rune(s)
    left := 0
    right := len(s)-1
    for left < right {
        for left< right && !isAlphanumeric(chars[left]){
            left++
        }
        for left < right && !isAlphanumeric(chars[right]){
            right--
        }
        if(unicode.ToLower(chars[left]) != unicode.ToLower(chars[right])){
            return false
        }
        left++
        right--
    }
    return true

}
func isAlphanumeric(r rune) bool {
    return unicode.IsLetter(r) || unicode.IsDigit(r)
}