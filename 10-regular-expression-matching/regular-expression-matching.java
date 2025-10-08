class Solution {
    public String sg;
    public String pg;

    public boolean isMatch(String s, String p) {
        sg = s;
        pg = p;
        return fun(0, 0);
    }

    public boolean fun(int sIndex, int pIndex) {
        if (sIndex == sg.length() && pIndex == pg.length()) {
            // System.out.println("5");
            return true;
        }

        if (pIndex == pg.length()) {
            // System.out.println("1");
            return false;
        }
        if (pIndex + 1 < pg.length() && pg.charAt(pIndex + 1) == '*') {
            // Case 1: skip 'x*'
            if (fun(sIndex, pIndex + 2)) {
                return true;
            }
            // Case 2: use '*' if current matches
            if (sIndex < sg.length() && (pg.charAt(pIndex) == sg.charAt(sIndex) || pg.charAt(pIndex) == '.')) {
                if (fun(sIndex + 1, pIndex)) {
                    return true;
                }
            }
            return false;
        }
        if (sIndex < sg.length() &&
                (pg.charAt(pIndex) == sg.charAt(sIndex) || pg.charAt(pIndex) == '.')) {
            if (fun(sIndex + 1, pIndex + 1)) {
                return true;
            }
        }

        // System.out.println("4");
        return false;
    }
}
